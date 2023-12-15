/* @license CC0-1.0 */

import { RodsIconArrowRight } from '@gemeente-rotterdam/web-components-react';
import type { Meta, StoryObj } from '@storybook/react';
import { LinkList } from '@utrecht/component-library-react/dist/css-module';
import readme from './link-list.md?raw';

const meta = {
  title: 'CSS Component/Link list',
  id: 'css-utrecht-link-list',
  component: LinkList,
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
    docs: {
      description: {
        component: readme,
      },
    },
  },
} satisfies Meta<typeof LinkList>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Link list',
  args: {
    icon: () => <RodsIconArrowRight />,
    links: [
      {
        href: '#',
        children: 'Direct regelen',
      },
      { href: '#', children: 'Meer informatie op Rotterdam.nl' },
    ],
  },
};
