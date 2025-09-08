import { readFile, writeFile } from "node:fs/promises";

/*
 * Unfortunately the Mendix SCSS is configured without `!default` for the variables.
 * If `@mendix/atlas-ui` was published as regular npm pacakge, we could have used
 * `pnpm patch`.
 *
 * We have created this little script instead.
 */
const init = async () => {
  const paths = [
    "./node_modules/@mendix/atlas/packages/atlas/src/theme/web/custom-variables.scss",
  ];

  paths.forEach(async (path) => {
    const file = await readFile(path, "utf-8");

    /**
     * Replace all SCSS variables in `_exclusion-variables-defaults.scss` that are hardcoded,
     * with variables that can be configured because of `!default`.
     */
    const fixed = file.replace(/(\$[^:]+\s*:\s*[^!;]+\s*);/g, "$1 !default;");

    writeFile(path, fixed);
  });
};

init();
