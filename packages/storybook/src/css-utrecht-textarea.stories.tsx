/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Textarea } from '@utrecht/component-library-react/dist/css-module';
import readme from './textarea.md?raw';

const meta = {
  id: 'css-utrecht-textarea',
  args: {
    defaultValue: '',
  },
  argTypes: {
    defaultValue: {
      name: 'Content',
      defaultValue: '',
      type: {
        name: 'string',
        required: true,
      },
    },
  },
  component: Textarea,
  parameters: {
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Ftextarea',
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=1076-6680',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
  tags: ['autodocs'],
  title: 'CSS Component/Textarea',
} satisfies Meta<typeof Textarea>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Textarea',
  args: {
    defaultValue:
      'You can use this input field in your design when you want to use input fields with much more text in it.',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/design/iWuQsxelJzXVfCge87Og81/RODS-component?node-id=238-4947&t=5SS9SJ1KhfLkhqSu-4',
    },
  },
};
