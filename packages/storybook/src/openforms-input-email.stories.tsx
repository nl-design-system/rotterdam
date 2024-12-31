import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-email',
  args: {
    key: '',
    label: '',
    type: 'email',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/Email',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    key: 'email',
    label: 'Email',
  },
};
export const Disabled: Story = {
  args: {
    extraComponentProperties: {
      disabled: true,
    },
    key: 'email',
    label: 'Email',
  },
};
