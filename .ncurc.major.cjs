const minorConfig = require("./.ncurc.minor.cjs");

module.exports = {
  ...minorConfig,
  reject: [
    ...minorConfig.reject,
    "@types/react",
    "@types/react-dom",
    "eslint-plugin-perfectionist",
    "react",
    "react-dom",
  ],
  target: "latest",
};
