import type { StorybookConfig } from '@storybook/react-vite';
import { createRequire } from 'node:module';
import { dirname, join } from 'node:path';

const require = createRequire(import.meta.url);
const getAbsolutePath = (value: string): string => {
  return dirname(require.resolve(join(value, 'package.json')));
};

const config: StorybookConfig = {
  addons: [
    getAbsolutePath('@storybook/addon-a11y'),
    getAbsolutePath('@storybook/addon-docs'),
    getAbsolutePath('@storybook/addon-designs'),
    getAbsolutePath('@storybook/addon-themes'),
  ],

  core: {
    disableTelemetry: true,
    disableWhatsNewNotifications: true,
  },

  features: {},

  framework: {
    name: getAbsolutePath('@storybook/react-vite'),
    options: {},
  },

  staticDirs: ['../../../proprietary/assets/src'],

  stories: [
    '../src/**/*stories.@(js|jsx|ts|tsx)',
    '../src/**/*.mdx',
    '../../../rotterdam-nlds-parent-wicket/docs-wicket/stories/*.mdx',
  ],
};

export default config;
