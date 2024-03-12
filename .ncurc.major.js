const minorConfig = require('./.ncurc.minor');

module.exports = {
  ...minorConfig,
  reject: [...minorConfig.reject, 'storybook', '@storybook/*'],
  target: 'latest',
};
