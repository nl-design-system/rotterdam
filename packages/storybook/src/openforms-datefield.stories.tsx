import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-date-field',
  args: {
    extraComponentProperties: {
      datePicker: {
        maxDate: null,
        minDate: null,
      },
      enableTime: false,
      format: 'dd-MM-yyyy',

      placeholder: 'dd-mm-yyyy',
    },
    type: 'date',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/DateField',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {};

export const Disabled: Story = {
  args: {
    extraComponentProperties: {
      disabled: true,
    },
  },
};
