import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-textarea',
  args: {
    extraComponentProperties: {
      description: '',
    },
    label: '',
    type: 'textarea',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/Textarea',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    extraComponentProperties: {
      description: 'Plaats hierboven uw handtekening',
    },
    label: 'Textarea',
  },
};
export const disabled: Story = {
  args: {
    extraComponentProperties: {
      defaultValue: 'dit is de text in de text area',
      disabled: true,
    },
    label: 'Textarea',
  },
};
