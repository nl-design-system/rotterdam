import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-number',
  args: {
    key: '',
    label: '',
    type: 'number',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/Number',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    key: 'number',
    label: 'Nummer',
  },
};

export const WithPrefix: Story = {
  args: {
    extraComponentProperties: {
      prefix: '%',
    },
    key: 'number',
    label: 'Nummer',
  },
};

export const WithSuffix: Story = {
  args: {
    extraComponentProperties: {
      suffix: 'm<sup>3</sup>',
    },
    key: 'number',
    label: 'Nummer',
  },
};
export const Disabled: Story = {
  args: {
    extraComponentProperties: {
      disabled: true,
    },
    key: 'number',
    label: 'Nummer',
  },
};
