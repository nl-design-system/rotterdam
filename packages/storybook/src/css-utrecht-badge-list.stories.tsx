/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { BadgeList, DataBadge, Link } from '@utrecht/component-library-react/dist/css-module';
import readme from './badge-list.md?raw';

const meta = {
  title: 'CSS Component/Badge list',
  id: 'css-utrecht-badge-list',
  component: BadgeList,
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
} satisfies Meta<typeof BadgeList>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Default',
  args: {
    children: [
      <Link href="#">
        <DataBadge>duurzaamheid</DataBadge>
      </Link>,
      <Link href="#">
        <DataBadge>schoon, heel en veilig</DataBadge>
      </Link>,
    ],
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=16340-13147',
    },
  },
};
