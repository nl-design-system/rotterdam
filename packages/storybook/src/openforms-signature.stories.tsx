import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-signature',
  args: {
    extraComponentProperties: {
      description: '',
    },
    label: '',
    type: 'signature',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/Signature',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    extraComponentProperties: {
      description: 'Plaats hierboven uw handtekening',
    },
    label: 'Handtekening',
  },
};
