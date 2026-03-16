# How to Release the Java Packages

This document describes how Java components of the NL Design System for
Rotterdam are versioned, built, signed, and published to Maven Central.
It also defines the security model, rotation policies, and responsibilities
for maintainers.

---

## 1. Instructions for Creating a Release

Java releases are created automatically through the same
[Changesets](https://github.com/changesets/changesets)-based workflow
that governs the npm packages in this repository.

### 1. Add a changeset to your PR

Every PR that contains a releasable Java change must include a changeset
that targets the `@gemeente-rotterdam/java-release-group` package. All Java/Wicket modules
share a single version number and are always released together.

Run the CLI and follow the prompts, or create the file manually:

```bash
pnpm changeset
```

Choose `@gemeente-rotterdam/java-release-group` as the package and select the appropriate
bump type:

| Wijziging                         | Bump type |
| --------------------------------- | --------- |
| Bugfix                            | `patch`   |
| Nieuwe component / feature        | `minor`   |
| Breaking API- of versie-wijziging | `major`   |

The changeset file is committed together with your code changes.

Example changeset file (`.changeset/<random-name>.md`):

```md
---
"@gemeente-rotterdam/java-release-group": minor
---

Adds the new `RdColorPicker` component to the Wicket component library.
```

### 2. Merge the PR

After the PR is merged to `main`, the CI automatically creates or updates
a **"docs(release): design system packages"** pull request that:

- Bumps `packages/java-release-group/package.json` to the new version
- Updates all Maven POM files to the same release version (removes `-SNAPSHOT`)
- Updates `packages/java-release-group/CHANGELOG.md`

Review the version bump PR, approve it, and merge it.

### 3. CI publishes to Maven Central

After the version PR is merged, the CI pipeline:

1. Detects the new `@gemeente-rotterdam/java-release-group` version
2. Creates the `java-<version>` git tag (e.g. `java-0.0.11`)
3. The tag triggers the Maven Central release workflow:
   [maven-central-sonatype.yml](.github/workflows/maven-central-sonatype.yml)

This workflow:

- Builds the Java modules
- Generates sources & javadoc JARs
- Signs all artifacts using the PGP key
- Uploads them to Sonatype Central
- Auto-publishes them to Maven Central
- Waits until publication is fully complete
- Commits the next `-SNAPSHOT` version directly to `main`

### 4. Rotterdam internal Maven caching

It may take some time before Maven caches within Rotterdam's infrastructure
make the new version available.

---

## 2. Set Up of the Release Process

Java libraries are published to the official Maven Central Repository:
<https://central.sonatype.com/>

Publishing has been set up based on Sonatype’s documentation:
<https://central.sonatype.org/publish/publish-portal-guide/>

The [GitHub Action](.github/workflows/maven-central-sonatype.yml) used for
Java publishing supports two modes:

### A. Validate-only (manual trigger)

Can be run manually from the GitHub Actions UI.
This mode:

- Builds
- Signs
- Uploads to Sonatype Central
- Waits until validation completes
- **Does not auto-publish**

Useful for verifying that everything is configured correctly.

### B. Full release (tag-triggered)

Triggered automatically by the `publish-npm` job in
[publish.yml](.github/workflows/publish.yml) when a new `java-<version>`
tag is created.
This mode:

- Builds
- Signs
- Uploads
- **Auto-publishes to Maven Central**
- Waits until artifacts are published and indexed

---

## 3. GitHub Secrets Used for Publishing

Publishing requires several secrets to authenticate with Sonatype and to sign artifacts:

| Secret Name                        | Description                                   |
| ---------------------------------- | --------------------------------------------- |
| `CENTRAL_SONATYPE_USERNAME`        | Sonatype Portal Token username (Token ID)     |
| `CENTRAL_SONATYPE_PASSWORD`        | Sonatype Portal Token password (Token Secret) |
| `CENTRAL_SONATYPE_GPG_PRIVATE_KEY` | ASCII-armored PGP private key for signing     |
| `CENTRAL_SONATYPE_GPG_PASSPHRASE`  | Passphrase for the PGP private key            |

Sonatype Portal Tokens are created following:
<https://central.sonatype.org/publish/generate-portal-token/>

These secrets must only be stored in GitHub Secrets, never in the repository.

---

## 4. PGP Signing Key

All Maven Central releases must be cryptographically signed.

### Current Signing Key

- **Public Key Fingerprint:**
  `88E232FB40DA012BA01A77B3118AC35D68EF0314`
- **Public Key URL:**
  <https://keys.openpgp.org/vks/v1/by-fingerprint/88E232FB40DA012BA01A77B3118AC35D68EF0314>
- The **private key** is securely stored only in GitHub Secrets.
- The key was generated on a development workstation and uploaded to <https://keys.openpgp.org/>.

### PGP Key Rotation Policy

When the responsible maintainer leaves the NL Design System Rotterdam project:

1. A new PGP key pair must be generated by a Rotterdam employee.
2. The public key must be uploaded to <https://keys.openpgp.org/>.
3. GitHub Secrets must be updated with the new key and passphrase.
4. The old key should be revoked or archived securely.
5. The leaving person must be removed from the GitHub repository.

---

## 5. Maven Central Namespace & Sonatype Permissions

Artifacts are published under the Namespace:

`nl.rotterdam`

Ownership of this namespace has been verified using a DNS TXT record on `rotterdam.nl`.

Maintainers with access to the namespace can manage users in the Sonatype Central portal:

<https://central.sonatype.com/>

### User & Token Rotation Policy

When a maintainer leaves:

1. Remove their Sonatype account from the `nl.rotterdam` namespace.
2. Remove their access via the NL Design System Terraform repository:
   <https://github.com/nl-design-system/terraform>
3. A new maintainer should generate a new Portal Token if they are responsible for releases.
4. GitHub Secrets must be updated if the responsible maintainer changes.

---

## 6. Developer Responsibilities

Contributors working on Java artifacts must:

- Never commit credentials or private signing keys
- Use PRs and follow the release workflow
- Update versions via `mvn versions:set`
- Use the correct tag naming convention (`java-<version>`)
- Ensure their personal Sonatype credentials remain secure
- Remove their own access and tokens upon leaving the project
