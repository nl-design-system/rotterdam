/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Checkbox } from '@utrecht/component-library-react/dist/css-module';
import readme from './checkbox.md?raw';

const meta = {
  title: 'CSS Component/Checkbox',
  id: 'css-utrecht-checkbox',
  component: Checkbox,
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
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=13-619',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
} satisfies Meta<typeof Checkbox>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Checkbox',
  args: {},
};

export const Checked: Story = {
  name: 'Checked',
  args: {
    defaultChecked: true,
  },
};

export const Disabled: Story = {
  name: 'Disabled',
  args: {
    checked: false,
    disabled: true,
  },
};

export const CheckedDisabled: Story = {
  name: 'Checked and disabled',
  args: {
    checked: true,
    disabled: true,
  },
};
