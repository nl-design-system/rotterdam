import discardDuplicates from "postcss-discard-duplicates";
import postcss from "rollup-plugin-postcss";

export default [
  {
    input: "src/index.scss",
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
