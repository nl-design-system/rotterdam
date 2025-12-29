/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import readme from '../../web-components/date-picker/README.md?raw';

const DatePicker = () => <img src="date-picker.png" alt="screenshot van Date Picker" style={{ width: '1220px' }} />;
const meta = {
  id: 'rods-date-picker',
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
  component: DatePicker,
  parameters: {
    docs: {
      description: {
        component: readme,
      },
    },
  },
  tags: ['autodocs'],
  title: 'Web Component/Date Picker',
} satisfies Meta<typeof DatePicker>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Default',
  args: {},
};
