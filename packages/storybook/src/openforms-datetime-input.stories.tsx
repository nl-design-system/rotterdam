import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-date-time-field',
  args: {
    extraComponentProperties: {
      extraComponentProperties: {
        datePicker: {
          maxDate: null,
          minDate: null,
        },
        enableTime: true,
        format: 'dd-MM-yyyy HH:mm',
        placeholder: 'dd-MM-yyyy HH:mm',
        time_24hr: true,
        timePicker: {
          arrowkeys: true,
          hourStep: 1,
          minuteStep: 1,
          mousewheel: true,
          readonlyInput: false,
          showMeridian: false,
        },
      },
      type: 'datetime',
    },
    type: 'date',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/DateTimeField',
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
