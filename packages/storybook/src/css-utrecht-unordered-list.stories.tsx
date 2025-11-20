/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react-vite';
import { UnorderedList, UnorderedListItem } from '@utrecht/component-library-react/dist/css-module';
import readme from './unordered-list.md?raw';

const meta = {
  id: 'css-utrecht-unordered-list',
  args: {
    children: '',
  },
  argTypes: {
    children: {
      name: 'Content',
      defaultValue: '',
      type: {
        name: 'string',
        required: true,
      },
    },
  },
  component: UnorderedList,
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
  tags: ['autodocs'],
  title: 'CSS Component/Unordered list',
} satisfies Meta<typeof UnorderedList>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Unordered list',
  args: {
    children: (
      <>
        <UnorderedListItem>
          In deze app staan niet de dagen waarop wij de wijkcontainers legen, alleen de huiscontainers (kliko’s)
        </UnorderedListItem>
        <UnorderedListItem>
          In deze app staan niet de dagen waarop wij de wijkcontainers legen, alleen de huiscontainers (kliko’s)
        </UnorderedListItem>
        <UnorderedListItem>
          In deze app staan niet de dagen waarop wij de wijkcontainers legen, alleen de huiscontainers (kliko’s)
        </UnorderedListItem>
      </>
    ),
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/design/iWuQsxelJzXVfCge87Og81/RODS-component?node-id=1-3754&t=5SS9SJ1KhfLkhqSu-4',
    },
  },
};
