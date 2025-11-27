/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react-vite';
import { Heading } from '@utrecht/component-library-react/dist/css-module';
import readme from './heading.md?raw';

const meta = {
  id: 'css-utrecht-heading',
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
  component: Heading,
  parameters: {
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Fheading',
    design: {
      type: 'figma',
      url: 'https://www.figma.com/design/RiVsTfcbmnKSU2BGqQBI9n/RODS-fundament?node-id=1-2957&t=y0jresab3mn2Swvw-4',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
  tags: ['autodocs'],
  title: 'CSS Component/Heading',
} satisfies Meta<typeof Heading>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Heading1: Story = {
  name: 'Heading 1',
  args: {
    children: 'Heading 1',
    level: 1,
  },
};

export const Heading2: Story = {
  name: 'Heading 2',
  args: {
    children: 'Heading 2',
    level: 2,
  },
};

export const Heading3: Story = {
  name: 'Heading 3',
  args: {
    children: 'Heading 3',
    level: 3,
  },
};

export const Heading4: Story = {
  name: 'Heading 4',
  args: {
    children: 'Heading 4',
    level: 4,
  },
};

export const Heading5: Story = {
  name: 'Heading 5',
  args: {
    children: 'Heading 5',
    level: 5,
  },
};

export const Heading6: Story = {
  name: 'Heading 6',
  args: {
    children: 'Heading 6',
    level: 6,
  },
};
