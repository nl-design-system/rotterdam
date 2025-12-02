const stringSort = (a, b) => (a === b ? 0 : a > b ? 1 : -1);

const sortByName = (a, b) => stringSort(a.name, b.name);

export const createConfig = ({
  buildPath = "dist/",
  className = "",
  selector,
  source = ["figma/*.tokens.json"],
  useTokensStudioTransformGroup = true,
}) => {
  const prefix = selector ? selector.replace(/^\.(.+)-theme/, "$1") : "";
  let themeName = className || (prefix ? `${prefix}-theme` : "theme");
  const transformGroup = useTokensStudioTransformGroup ? "tokens-studio" : "";

  return {
    hooks: {
      formats: {
        "json/list": function ({ dictionary }) {
          return JSON.stringify(
            dictionary.allTokens.sort(sortByName),
            null,
            "  ",
          );
        },
      },
    },
    log: {
      verbosity: "verbose",
    },
    platforms: {
      css: {
        buildPath,
        files: [
          {
            destination: "theme.css",
            format: "css/variables",
            options: {
              outputReferences: true,
              selector: `.${themeName}`,
            },
          },
          {
            destination: "variables.css",
            format: "css/variables",
            options: {
              outputReferences: true,
              selector: `:root`,
            },
          },
        ],
        transformGroup: transformGroup,
        transforms: ["name/kebab"],
      },
      js: {
        buildPath,
        files: [
          {
            destination: "variables.cjs",
            format: "javascript/module-flat",
          },
          {
            destination: "variables.mjs",
            format: "javascript/es6",
          },
        ],
        transformGroup: transformGroup,
        transforms: ["name/camel"],
      },
      json: {
        buildPath,
        files: [
          {
            destination: "tokens.json",
            format: "json",
          },
          {
            destination: "list.json",
            format: "json/list",
          },
          {
            destination: "variables.json",
            format: "json/flat",
          },
        ],
        transformGroup: transformGroup,
        transforms: ["name/camel"],
      },
      less: {
        buildPath,
        files: [
          {
            destination: "variables.less",
            format: "less/variables",
            options: {
              outputReferences: true,
            },
          },
        ],
        transformGroup: transformGroup,
        transforms: ["name/kebab"],
      },
      scss: {
        buildPath,
        files: [
          {
            destination: "_variables.scss",
            format: "scss/variables",
            options: {
              outputReferences: true,
              themeable: true,
            },
          },
        ],
        transformGroup: transformGroup,
        transforms: ["name/kebab"],
      },
      "scss-theme-mixin": {
        buildPath,
        files: [
          {
            destination: "_mixin.scss",
            format: "css/variables",
            options: {
              outputReferences: true,
              selector: `@mixin ${themeName}`,
            },
          },
        ],
        transforms: ["name/kebab"],
      },
      tokenTree: {
        buildPath,
        files: [
          {
            destination: "tokens.cjs",
            format: "javascript/module",
          },
        ],
        transformGroup: transformGroup,
        transforms: ["name/camel"],
      },
      typescript: {
        buildPath,
        files: [
          {
            destination: "variables.d.ts",
            format: "typescript/es6-declarations",
          },
          {
            destination: "tokens.d.ts",
            format: "typescript/module-declarations",
          },
        ],
        transformGroup: "js",
        transforms: ["name/camel"],
      },
    },
    source,
  };
};
