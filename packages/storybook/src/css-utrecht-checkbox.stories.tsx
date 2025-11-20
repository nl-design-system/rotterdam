/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react-vite';
import { Checkbox } from '@utrecht/component-library-react/dist/css-module';
import readme from './checkbox.md?raw';

const meta = {
  id: 'css-utrecht-checkbox',
  args: {},
  argTypes: {
    defaultValue: {
      name: 'Content',
      type: {
        name: 'string',
        required: true,
      },
    },
  },
  component: Checkbox,
  parameters: {
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Fcheckbox',
    docs: {
      description: {
        component: readme,
      },
    },
  },
  tags: ['autodocs'],
  title: 'CSS Component/Checkbox',
} satisfies Meta<typeof Checkbox>;

export default meta;

type Story = StoryObj<typeof meta>;

export const DefaultCheckbox: Story = {
  name: 'Checkbox',
};

export const CheckedCheckbox: Story = {
  name: 'Checked Checkbox',
  args: {
    defaultChecked: true,
  },
};
