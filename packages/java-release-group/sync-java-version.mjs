import { execSync } from 'child_process';
import fs from 'fs';
import path from 'path';
import { fileURLToPath } from 'url';

/**
 * Syncs all Maven POM files to the version defined in this package's package.json.
 *
 * This script is run as part of `pnpm run version:changeset` (changeset version hook).
 * It ensures that when Changesets bumps the java-release-group package version,
 * all Maven POM files are updated to the same release version.
 *
 * The script is a no-op when the current java-release-group version already has
 * a corresponding `java-<version>` git tag (meaning it was already released).
 */

const __dirname = path.dirname(fileURLToPath(import.meta.url));
const ROOT = path.resolve(__dirname, '../..');

/** Read the target version from this package's package.json */
function getJavaReleaseGroupVersion() {
  const pkgPath = path.join(__dirname, 'package.json');
  return JSON.parse(fs.readFileSync(pkgPath, 'utf8')).version;
}

/** Read the current project version from Maven using the Maven Wrapper. */
function getCurrentPomVersion() {
  const version = execSync('./mvnw help:evaluate -Dexpression=project.version -q -DforceStdout', {
    cwd: ROOT,
    encoding: 'utf8',
  }).trim();
  if (!version) {
    throw new Error('Could not determine project version from Maven');
  }
  return version;
}

/** Check whether a git tag exists locally (requires tags to be fetched). */
function tagExists(tagName) {
  try {
    const output = execSync(`git tag -l "${tagName}"`, { encoding: 'utf8' });
    return output.trim() === tagName;
  } catch {
    return false;
  }
}

/** Recursively find all pom.xml files, skipping build artefact directories. */
function findPomFiles(dir) {
  const SKIP_DIRS = new Set(['target', 'node_modules', '.git', 'node', 'dist']);
  const results = [];
  for (const entry of fs.readdirSync(dir, { withFileTypes: true })) {
    if (SKIP_DIRS.has(entry.name)) continue;
    const fullPath = path.join(dir, entry.name);
    if (entry.isDirectory()) {
      results.push(...findPomFiles(fullPath));
    } else if (entry.name === 'pom.xml') {
      results.push(fullPath);
    }
  }
  return results;
}

function main() {
  const newVersion = getJavaReleaseGroupVersion();
  const javaTag = `java-${newVersion}`;

  // If the tag already exists this version has been released; nothing to do.
  if (tagExists(javaTag)) {
    console.log(`Tag ${javaTag} already exists — version ${newVersion} was already released. Skipping Maven POM sync.`);
    return;
  }

  const oldVersion = getCurrentPomVersion();

  if (oldVersion === newVersion) {
    console.log(`Maven POMs are already at version ${newVersion}. No sync needed.`);
    return;
  }

  const escapedOld = oldVersion.replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
  const pattern = new RegExp(`<version>${escapedOld}</version>`, 'g');
  const replacement = `<version>${newVersion}</version>`;

  // Replaces every occurrence of <version>${oldVersion}</version> in each POM.
  // This is intentional: the project version (e.g. "0.0.10-SNAPSHOT") appears in
  //   • the root POM's own <version>,
  //   • each child POM's <parent><version>,
  //   • the dependency-management entries in the parent-wicket POM.
  // All of these must be updated together. Third-party library versions use
  // entirely different version numbers (e.g. "10.6.0", "12.1.0") and are
  // therefore never matched by this replacement.

  const pomFiles = findPomFiles(ROOT);
  console.log(`Syncing Maven POMs from ${oldVersion} to ${newVersion}...`);

  for (const filePath of pomFiles) {
    const content = fs.readFileSync(filePath, 'utf8');
    const updated = content.replace(pattern, replacement);
    if (content !== updated) {
      fs.writeFileSync(filePath, updated);
      console.log(`  Updated ${path.relative(ROOT, filePath)}`);
    }
  }

  console.log(`Maven POMs synced to ${newVersion}.`);
}

main();
