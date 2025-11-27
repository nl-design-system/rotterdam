/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react-vite';
import { BadgeList, DataBadge, Link } from '@utrecht/component-library-react/dist/css-module';
import readme from './badge-list.md?raw';

const meta = {
  id: 'css-utrecht-badge-list',
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
  component: BadgeList,
  parameters: {
    docs: {
      description: {
        component: readme,
      },
    },
  },
  tags: ['autodocs'],
  title: 'CSS Component/Badge list',
} satisfies Meta<typeof BadgeList>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Default',
  args: {
    children: (
      <>
        <Link href="#">
          <DataBadge>duurzaamheid</DataBadge>
        </Link>
        <Link href="#">
          <DataBadge>schoon, heel en veilig</DataBadge>
        </Link>
      </>
    ),
  },
  parameters: {
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Fbadge-list',
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=16340-13147',
    },
  },
};
