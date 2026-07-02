import minorConfig from './.ncurc.minor.mjs';

export default {
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
