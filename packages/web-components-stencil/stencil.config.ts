import { Config } from '@stencil/core';
import { reactOutputTarget } from '@stencil/react-output-target';
import { sass } from '@stencil/sass';

export const config: Config = {
  extras: { enableImportInjection: true },
  namespace: 'rods',
  outputTargets: [
    {
      esmLoaderPath: '../loader',
      type: 'dist',
    },
    {
      customElementsExportBehavior: 'bundle',
      type: 'dist-custom-elements',
    },
    {
      serviceWorker: null, // disable service workers
      type: 'www',
    },
    reactOutputTarget({
      componentCorePackage: '@gemeente-rotterdam/web-components-stencil',
      proxiesFile: '../web-components-react/src/components.ts',
    }),
  ],
  plugins: [sass()],
  srcDir: './src/',
};
