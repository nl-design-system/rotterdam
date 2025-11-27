/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react-vite';
import { OrderedList, OrderedListItem } from '@utrecht/component-library-react/dist/css-module';
import readme from './ordered-list.md?raw';

const meta = {
  id: 'css-utrecht-ordered-list',
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
  component: OrderedList,
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
  tags: ['autodocs'],
  title: 'CSS Component/Ordered list',
} satisfies Meta<typeof OrderedList>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Ordered list',
  args: {
    children: (
      <>
        <OrderedListItem>
          In deze app staan niet de dagen waarop wij de wijkcontainers legen, alleen de huiscontainers (kliko’s)
        </OrderedListItem>
        <OrderedListItem>
          In deze app staan niet de dagen waarop wij de wijkcontainers legen, alleen de huiscontainers (kliko’s)
        </OrderedListItem>
        <OrderedListItem>
          In deze app staan niet de dagen waarop wij de wijkcontainers legen, alleen de huiscontainers (kliko’s)
        </OrderedListItem>
      </>
    ),
  },
};
