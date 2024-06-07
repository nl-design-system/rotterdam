const minorConfig = require('./.ncurc.minor');

module.exports = {
  ...minorConfig,
  reject: [...minorConfig.reject, 'eslint', 'eslint-plugin-json'],
  target: 'latest',
};
