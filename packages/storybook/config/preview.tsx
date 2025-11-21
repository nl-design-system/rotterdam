import '@gemeente-rotterdam/design-tokens/dist/index.css';
import '@gemeente-rotterdam/font/src/index.scss';
import type { Preview } from '@storybook/react-vite';
import { defineCustomElements } from '@gemeente-rotterdam/web-components-stencil/loader/index.js';
import { Controls, Description, Primary, Stories } from '@storybook/addon-docs/blocks';
import { withThemeByClassName } from '@storybook/addon-themes';
import { ButtonGroup, Document } from '@utrecht/component-library-react/dist/css-module';
import { FigmaBlock } from './FigmaBlock';
import { GitHubBlock } from './GitHubBlock';

defineCustomElements();

const preview: Preview = {
  decorators: [
    withThemeByClassName({
      defaultTheme: 'Rotterdam',
      themes: {
        Rotterdam: 'rods-theme',
        'Rotterdam dark color scheme': 'rods-theme rods-theme--media-query-color-scheme-dark',
      },
    }),
    (Story) => <Document>{Story()}</Document>,
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
          ['README'],
        ],
      },
    },
  },

  tags: ['autodocs'],
};

export default preview;
