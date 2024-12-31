import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-textfield',
  args: {
    key: '',
    label: '',
    type: 'textfield',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/Textfield',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    key: 'textfield',
    label: 'Voornaam',
  },
};
export const disabled: Story = {
  args: {
    extraComponentProperties: {
      defaultValue: 'dit is de text in de text field',
      disabled: true,
    },
    key: 'textfield',
    label: 'Voornaam',
  },
};
