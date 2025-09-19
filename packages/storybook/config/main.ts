import type { StorybookConfig } from '@storybook/react-vite';

const config: StorybookConfig = {
  addons: [
    '@storybook/addon-a11y',
    '@storybook/addon-docs',
    '@storybook/addon-viewport',
    '@storybook/addon-designs',
    '@storybook/addon-themes',
  ],
  core: {
    disableTelemetry: true,
    disableWhatsNewNotifications: true,
  },
  docs: {
    autodocs: true,
  },
  features: {},
  framework: {
    name: '@storybook/react-vite',
    options: {},
  },
  staticDirs: ['../../../proprietary/assets/src'],
  stories: ['../src/**/*stories.@(js|jsx|ts|tsx)', '../src/**/*.mdx', '../../../wicket/docs-wicket/stories/*.mdx'],
};

export default config;
