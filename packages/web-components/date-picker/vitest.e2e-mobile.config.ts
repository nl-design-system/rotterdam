import { playwright } from '@vitest/browser-playwright';
import { defineConfig } from 'vitest/config';

export default defineConfig({
  test: {
    browser: {
      enabled: true,
      headless: true,
      instances: [{ browser: 'chromium' }],
      provider: playwright({
        launchOptions: {},
      }),
      screenshotDirectory: new URL('./tmp/__screenshots__', import.meta.url).pathname,
      viewport: {
        // https://infrequently.org/#test-devices
        // Queried at December 25th 2025
        // Samsung Galaxy A24 4G
        height: 2340 / 2,
        width: 1080 / 2,
      },
    },
    include: ['./src/*.e2e-mobile.(ts|js)'],
  },
});
