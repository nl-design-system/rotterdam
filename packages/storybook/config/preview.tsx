import { defineCustomElements } from '@gemeente-rotterdam/web-components-stencil/loader/index.js';
import { withThemeByClassName } from '@storybook/addon-styling';
import { Controls, Description, Primary, Stories } from '@storybook/blocks';
import type { Preview } from '@storybook/react';
import { Document } from '@utrecht/component-library-react/dist/css-module';
import { FigmaBlock } from './FigmaBlock';
import '@gemeente-rotterdam/design-tokens/dist/index.css';
import '@gemeente-rotterdam/font/src/index.scss';

defineCustomElements();

const preview: Preview = {
  decorators: [
    withThemeByClassName({
      themes: {
        Rotterdam: 'rods-theme',
        'Rotterdam dark color scheme': 'rods-theme rods-theme--media-query-color-scheme-dark',
      },
      defaultTheme: 'Rotterdam',
    }),
    (Story: any) => <Document>{Story()}</Document>,
  ],
  parameters: {
    controls: { expanded: false },
    docs: {
      page: () => {
        // Exclude `<Title>` because the title comes from the Markdown file
        return (
          <>
            <Description />
            <FigmaBlock />
            <Primary />
            <Controls />
            <Stories />
          </>
        );
      },
    },
    status: {
      statuses: {
        PRODUCTION: {
          background: '#088008',
          color: '#ffffff',
          description:
            'Used in production in a variety of situations, well tested, stable APIs, mostly patches and minor releases.',
        },
        BETA: {
          background: '#3065ee',
          color: '#ffffff',
          description:
            'Used in production in a specific situation, evolving APIs based on feedback, breaking changes are still likely.',
        },
        ALPHA: {
          background: '#e0bc2e',
          color: '#000000',
          description:
            'Used in prototypes and in projects that are still in development, breaking changes occur frequently and are not communicated.',
        },
        'WORK IN PROGRESS': {
          background: '#cc0000',
          color: '#ffffff',
          description:
            'Do not use in production. Does not follow semantic versioning and any published packages are for internal use only.',
        },
      },
    },
    options: {
      panelPosition: 'right',
      storySort: {
        order: ['Rotterdam', 'CSS Component'],
      },
    },
  },
};

export default preview;
