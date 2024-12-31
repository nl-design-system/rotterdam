import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-cosign',
  args: {
    type: 'cosign',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/Cosign',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    extraComponentProperties: {
      authPlugin: 'digid',
      validateOn: 'blur',
    },
    key: 'cosign',
    label: 'Co-signer email address',
  },
};
export const Disabled: Story = {
  args: {
    extraComponentProperties: {
      authPlugin: 'digid',
      disabled: true,
      validateOn: 'blur',
    },
    key: 'cosign',
    label: 'Co-signer email address',
  },
};
