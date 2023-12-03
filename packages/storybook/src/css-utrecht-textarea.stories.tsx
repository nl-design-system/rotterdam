/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Textarea } from '@utrecht/component-library-react/dist/css-module';
import readme from './textarea.md?raw';

const meta = {
  title: 'CSS Component/Textarea',
  id: 'css-utrecht-textarea',
  component: Textarea,
  argTypes: {
    defaultValue: {
      name: 'Content',
      type: {
        name: 'string',
        required: true,
      },
      defaultValue: '',
    },
  },
  args: {
    defaultValue: '',
  },
  tags: ['autodocs'],
  parameters: {
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
} satisfies Meta<typeof Textarea>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Textarea',
  args: {
    defaultValue:
      'You can use this input field in your design when you want to use input fields with much more text in it.',
  },
};
