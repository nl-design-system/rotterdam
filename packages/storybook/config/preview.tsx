import '@gemeente-rotterdam/design-tokens/dist/index.css';
import '@gemeente-rotterdam/font/src/index.scss';
import { defineCustomElements } from '@gemeente-rotterdam/web-components-stencil/loader/index.js';
import { withThemeByClassName } from '@storybook/addon-themes';
import { Controls, Description, Primary, Stories } from '@storybook/blocks';
import type { Preview } from '@storybook/react';
import { ButtonGroup, Document } from '@utrecht/component-library-react/dist/css-module';
import { FigmaBlock } from './FigmaBlock';
import { GitHubBlock } from './GitHubBlock';

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
        const buttons = [<FigmaBlock />, <GitHubBlock />].filter(Boolean);
        // Exclude `<Title>` because the title comes from the Markdown file
        return (
          <>
            <Description />
            {buttons.length > 0 ? <ButtonGroup>{buttons}</ButtonGroup> : null}
            <Primary />
            <Controls />
            <Stories />
          </>
        );
      },
    },
    options: {
      panelPosition: 'right',
      storySort: {
        order: [
          'Rotterdam',
          ['Rotterdam Design System', 'NL Design System', 'Color', 'Typography'],
          'CSS Component',
          'Web Component',
          'Template',
          'Apache Wicket',
          ['Aan de slag', 'README'],
          'Mendix',
          ['README'],
        ],
      },
    },
  },
};

export default preview;
