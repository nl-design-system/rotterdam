import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-iban',
  args: {
    key: '',
    label: '',
    type: 'iban',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/IBANField',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    key: 'iban',
    label: 'IBAN',
  },
};

export const Disabled: Story = {
  args: {
    extraComponentProperties: {
      disabled: true,
    },
    key: 'iban',
    label: 'IBAN',
  },
};
