import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-checkbox',
  args: {
    key: '',
    label: '',
    type: 'checkbox',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/Checkbox',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    key: 'checkbox',
    label: 'Ik heb de voorwaarden gelezen en ga hiermee akkoord.',
  },
};

export const Required: Story = {
  args: {
    extraComponentProperties: { validate: { required: true } },
    key: 'checkbox',
    label: 'Ik heb de voorwaarden gelezen en ga hiermee akkoord.',
  },
};

export const Checked: Story = {
  args: {
    extraComponentProperties: {
      defaultValue: true,
    },
    key: 'checkbox',
    label: 'Ik heb de voorwaarden gelezen en ga hiermee akkoord.',
  },
};
export const Disabled: Story = {
  args: {
    extraComponentProperties: {
      disabled: true,
    },
    key: 'checkbox',
    label: 'Ik heb de voorwaarden gelezen en ga hiermee akkoord.',
  },
};
