/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { UnorderedList, UnorderedListItem } from '@utrecht/component-library-react/dist/css-module';
import readme from './unordered-list.md?raw';

const meta = {
  title: 'CSS Component/Unordered list',
  id: 'css-utrecht-unordered-list',
  component: UnorderedList,
  argTypes: {
    children: {
      name: 'Content',
      type: {
        name: 'string',
        required: true,
      },
      defaultValue: '',
    },
  },
  args: {
    children: '',
  },
  tags: ['autodocs'],
  parameters: {
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Funordered-list',
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=490-17441',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
} satisfies Meta<typeof UnorderedList>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Unordered list',
  args: {
    children: [
      <UnorderedListItem>
        In deze app staan niet de dagen waarop wij de wijkcontainers legen, alleen de huiscontainers (kliko’s)
      </UnorderedListItem>,
      <UnorderedListItem>
        In deze app staan niet de dagen waarop wij de wijkcontainers legen, alleen de huiscontainers (kliko’s)
      </UnorderedListItem>,
      <UnorderedListItem>
        In deze app staan niet de dagen waarop wij de wijkcontainers legen, alleen de huiscontainers (kliko’s)
      </UnorderedListItem>,
    ],
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=174-1308&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};
