import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-timefield',
  args: {
    extraComponentProperties: {
      inputType: '',
    },
    label: '',
    type: 'time',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/TimeField',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    extraComponentProperties: {
      inputType: 'text',
    },
    label: 'Tijd',
  },
};
export const Disabled: Story = {
  args: {
    extraComponentProperties: {
      disabled: true,
      inputType: 'text',
    },
    label: 'Tijd',
  },
};
