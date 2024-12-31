import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-phone-number',
  args: {
    key: '',
    label: '',
    type: 'phoneNumber',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/PhoneNumber',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    extraComponentProperties: {
      inputMask: null,
    },
    key: 'phone-number',
    label: 'Telefoonnummer',
  },
};
export const Disabled: Story = {
  args: {
    extraComponentProperties: {
      disabled: true,
      inputMask: null,
    },
    key: 'phone-number',
    label: 'Telefoonnummer',
  },
};
