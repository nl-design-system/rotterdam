import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-postcode',
  args: {
    key: '',
    label: '',
    type: 'postcode',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/PostcodeField',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    key: 'postcode',
    label: 'Postcode',
  },
};
export const Disabled: Story = {
  args: {
    extraComponentProperties: {
      disabled: true,
    },
    key: 'postcode',
    label: 'Postcode',
  },
};
