/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react-vite';
import RodsIconArrowRight from '@gemeente-rotterdam/web-components-react/dist/RodsIconArrowRight';
import { LinkList } from '@utrecht/component-library-react/dist/css-module';
import readme from './link-list.md?raw';

const meta = {
  id: 'css-utrecht-link-list',
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
  component: LinkList,
  parameters: {
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Flink-list',
    docs: {
      description: {
        component: readme,
      },
    },
  },
  tags: ['autodocs'],
  title: 'CSS Component/Link list',
} satisfies Meta<typeof LinkList>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Link list',
  args: {
    icon: () => <RodsIconArrowRight />,
    links: [
      {
        children: 'Direct regelen',
        href: '#',
      },
      { children: 'Meer informatie op Rotterdam.nl', href: '#' },
    ],
  },
};
