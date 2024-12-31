import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-bsn',
  args: {
    key: '',
    label: '',
    type: 'bsn',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/BSNField',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    key: 'bsn',
    label: 'Burgerservicenummer (BSN)',
  },
};
export const Disabled: Story = {
  args: {
    extraComponentProperties: {
      disabled: true,
    },
    key: 'bsn',
    label: 'Burgerservicenummer (BSN)',
  },
};
