import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-radio',
  args: {
    type: 'radio',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/Radio',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    extraComponentProperties: {
      values: [
        {
          label: 'Optie A',
          value: 'radioA',
        },
        {
          label: 'Optie B',
          value: 'radioB',
        },
        {
          label:
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
          value: 'radioC',
        },
      ],
    },
    type: 'radio',
  },
};

export const Checked: Story = {
  args: {
    extraComponentProperties: {
      defaultValue: 'radioA',
      values: [
        {
          label: 'Optie A',
          value: 'radioA',
        },
        {
          label: 'Optie B',
          value: 'radioB',
        },
        {
          label: 'Optie C',
          value: 'radioC',
        },
      ],
    },
    type: 'radio',
  },
};
export const Disabled: Story = {
  args: {
    extraComponentProperties: {
      defaultValue: 'radioA',
      disabled: true,
      values: [
        {
          label: 'Optie A',
          value: 'radioA',
        },
        {
          label: 'Optie B',
          value: 'radioB',
        },
        {
          label: 'Optie C',
          value: 'radioC',
        },
      ],
    },
  },
};
