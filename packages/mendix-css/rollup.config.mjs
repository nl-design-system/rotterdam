import discardDuplicates from "postcss-discard-duplicates";
import postcss from "rollup-plugin-postcss";

export default [
  {
    input: "src/mendix-nl-design-system-rotterdam-theme.scss",
    output: {
      compact: true,
      dir: "./dist",
      format: "esm",
      sourcemap: false,
    },
    plugins: [
      postcss({
        extensions: [".css", ".scss"],
        extract: true,
        plugins: [discardDuplicates()],
      }),
    ],
  },
  {
    input: "src/mendix-nl-design-system-theme.scss",
    output: {
      compact: true,
      dir: "./dist",
      format: "esm",
      sourcemap: false,
    },
    plugins: [
      postcss({
        extensions: [".css", ".scss"],
        extract: true,
        plugins: [discardDuplicates()],
      }),
    ],
  },
  // {
  //   input: "src/mendix-rotterdam-theme.scss",
  //   output: {
  //     dir: "./dist",
  //     sourcemap: false,
  //     format: "esm",
  //     compact: true,
  //   },
  //   plugins: [
  //     postcss({
  //       extensions: [".css", ".scss"],
  //       plugins: [discardDuplicates()],
  //       extract: true,
  //     }),
  //   ],
  // },
  {
    input: "src/mendix-default-theme.scss",
    output: {
      compact: true,
      dir: "./dist",
      format: "esm",
      sourcemap: false,
    },
    plugins: [
      postcss({
        extensions: [".css", ".scss"],
        extract: true,
        plugins: [discardDuplicates()],
      }),
    ],
  },
];
