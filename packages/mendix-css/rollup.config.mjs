import postcss from "rollup-plugin-postcss";
import discardDuplicates from "postcss-discard-duplicates";

export default [
  {
    input: "src/mendix-nl-design-system-rotterdam-theme.scss",
    output: {
      dir: "./dist",
      sourcemap: false,
      format: "esm",
      compact: true,
    },
    plugins: [
      postcss({
        extensions: [".css", ".scss"],
        plugins: [discardDuplicates()],
        extract: true,
      }),
    ],
  },
  {
    input: "src/mendix-nl-design-system-theme.scss",
    output: {
      dir: "./dist",
      sourcemap: false,
      format: "esm",
      compact: true,
    },
    plugins: [
      postcss({
        extensions: [".css", ".scss"],
        plugins: [discardDuplicates()],
        extract: true,
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
      dir: "./dist",
      sourcemap: false,
      format: "esm",
      compact: true,
    },
    plugins: [
      postcss({
        extensions: [".css", ".scss"],
        plugins: [discardDuplicates()],
        extract: true,
      }),
    ],
  },
];
