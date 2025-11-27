import js from "@eslint/js";
import json from "@eslint/json";
import eslintConfigPrettier from "eslint-config-prettier";
import perfectionist from "eslint-plugin-perfectionist";
import react from "eslint-plugin-react";
import storybook from "eslint-plugin-storybook";
import globals from "globals";
import tseslint from "typescript-eslint";

export default tseslint.config(
  {
    name: "nl-design-system/global-ignores",
    ignores: ["**/dist/", "**/build/", "**/coverage/"],
  },
  {
    name: "rotterdam/global-ignores",
    ignores: [
      "**/target/**",
      "**/tmp/",
      "**/package-lock.json",
      "components/components.d.ts",
      "packages/web-components-angular/src/directives/angular-component-lib/utils.ts",
      "packages/web-components-angular/src/directives/proxies.ts",
      "packages/web-components-stencil/loader",
      "packages/web-components-react/src/react-component-lib/",
      "packages/web-components-react/src/components.ts",
    ],
  },
  {
    name: "nl-design-system/plugins-settings",
    plugins: { perfectionist, react },
    settings: {
      react: {
        version: "detect",
      },
    },
  },
  {
    name: "@eslint/js/recommended",
    files: [
      "**/*.js",
      "**/*.cjs",
      "**/*.mjs",
      "**/*.jsx",
      "**/*.ts",
      "**/*.tsx",
    ],
    ...js.configs.recommended,
  },
  {
    name: "typescript-eslint/configs/strict",
    extends: [...tseslint.configs.strict],
    files: ["**/*.ts", "**/*.mts", "**/*.tsx"],
  },
  {
    name: "eslint-plugin-perfectionist/recommended-natural",
    ...perfectionist["recommended-natural"],
  },
  {
    name: "eslint-plugin-react/recommended",
    files: ["**/*.jsx", "**/*.tsx"],
    ...react.configs.flat.recommended,
    // Stencil uses a different type of JSX syntax, some rules do not apply.
    // For example: `react/no-unknown-property` finds that `fill-rule` needs to be named `fillRule`.
    // But in Stencil JSX `fill-rule` is correct.
    ignores: ["packages/web-components-stencil/src/**"],
    rules: {
      "react/no-unknown-property": ["error", { ignore: ["widgetid"] }],
    },
  },
  {
    name: "eslint-plugin-react/jsx-runtime",
    files: ["**/*.jsx", "**/*.tsx"],
    ...react.configs.flat["jsx-runtime"],
  },
  {
    // Source code that ends up in a browser
    name: "nl-design-system/browser",
    files: ["**/src/*.ts", "**/src/*.tsx"],
    languageOptions: {
      globals: { ...globals.browser },
    },
  },
  {
    // Node.js based scripts and tooling configuration
    name: "nl-design-system/node",
    files: ["**/*.js", "**/*.cjs", "**/*.mjs"],
    languageOptions: {
      globals: { ...globals.node },
    },
  },
  {
    // JSON
    name: "@eslint/json/recommended",
    files: ["**/*.json"],
    ignores: ["**/package.json"],
    language: "json/json",
    ...json.configs.recommended,
  }, //{
  //files: ['**/*.js', '**/*.cjs', '**/*.mjs', '**/*.jsx', '**/*.ts', '**/*.tsx'],
  //rules: {
  //...nlDesignSystemJS.rules,
  //},
  //},
  {
    // This section applies to all files
    name: "nl-design-system/all",
    rules: {
      "array-callback-return": ["error", { checkForEach: false }],
      "block-scoped-var": "error",
      "consistent-return": "error",
      eqeqeq: "error",
      "no-alert": "error",
      "no-caller": "error",
      "no-constructor-return": "error",
      "no-eval": "error",
      "no-implicit-globals": "error",
      "no-implied-eval": "error",
      "no-inner-declarations": "error",
      "no-invalid-this": "error",
      "no-lone-blocks": "error",
      "no-loop-func": "error",
      "no-multi-str": "error",
      "no-new-func": "error",
      "no-new-wrappers": "error",
      "no-octal-escape": "error",
      "no-param-reassign": "error",
      "no-return-assign": "error",
      "no-self-compare": "error",
      "no-sequences": "error",
      "no-throw-literal": "error",
      "no-unmodified-loop-condition": "error",
      "no-unused-expressions": "error",
      "no-useless-call": "error",
      "no-useless-concat": "error",
      "no-useless-return": "error",
      "no-void": "error",
      "perfectionist/sort-imports": [
        "error",
        {
          ignoreCase: false,
          newlinesBetween: "never",
        },
      ],
      "perfectionist/sort-objects": [
        "error",
        {
          customGroups: {
            first: ["id", "name"],
            last: ["overrides"],
          },
          groups: ["first", "unknown", "last"],
        },
      ],
      "prefer-regex-literals": "error",
      radix: "error",
      "typescript-eslint/no-unused-expressions": "off",
      yoda: "error",
    },
  },
  {
    name: "eslint-config-prettier",
    ...eslintConfigPrettier,
  },
  {
    name: "rotterdam/wicket",
    files: ["rotterdam-nlds-parent-wicket/*/src/**/*.js"],
    languageOptions: {
      globals: {
        ...globals.browser,
      },
    },
  },
  storybook.configs["flat/recommended"],
);
