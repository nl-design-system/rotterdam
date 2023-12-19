/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { OrderedList, OrderedListItem } from '@utrecht/component-library-react/dist/css-module';
import readme from './ordered-list.md?raw';

const meta = {
  title: 'CSS Component/Ordered list',
  id: 'css-utrecht-ordered-list',
  component: OrderedList,
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
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Fordered-list',
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
} satisfies Meta<typeof OrderedList>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Ordered list',
  args: {
    children: [
      <OrderedListItem>
        In deze app staan niet de dagen waarop wij de wijkcontainers legen, alleen de huiscontainers (kliko’s)
      </OrderedListItem>,
      <OrderedListItem>
        In deze app staan niet de dagen waarop wij de wijkcontainers legen, alleen de huiscontainers (kliko’s)
      </OrderedListItem>,
      <OrderedListItem>
        In deze app staan niet de dagen waarop wij de wijkcontainers legen, alleen de huiscontainers (kliko’s)
      </OrderedListItem>,
    ],
  },
};
