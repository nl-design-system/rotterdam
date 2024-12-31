import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-currency',
  args: {
    type: 'currency',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/Currency',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    extraComponentProperties: {
      allowNegative: true,
      currency: 'EUR',
      decimalLimit: 2,
      defaultValue: 0,
    },
  },
};

export const AllowNegative: Story = {
  args: {
    extraComponentProperties: {
      allowNegative: true,
      currency: 'EUR',
      decimalLimit: 2,
      defaultValue: -100,
    },
  },
};

export const AmericanDollars: Story = {
  args: {
    extraComponentProperties: {
      allowNegative: true,
      currency: 'USD',
      decimalLimit: 2,
      defaultValue: 1000.0,
    },
  },
};

export const BritishPound: Story = {
  args: {
    extraComponentProperties: {
      allowNegative: true,
      currency: 'GBP',
      decimalLimit: 2,
      defaultValue: 1000.0,
    },
  },
};

export const JapaneseYen: Story = {
  args: {
    extraComponentProperties: {
      allowNegative: true,
      currency: 'JPY',
      decimalLimit: 2,
      defaultValue: 1000.0,
    },
  },
};

export const SurinaamseDollar: Story = {
  args: {
    extraComponentProperties: {
      allowNegative: true,
      currency: 'SRD',
      decimalLimit: 2,
      defaultValue: 1000.0,
    },
  },
};
export const Disabled: Story = {
  args: {
    extraComponentProperties: {
      allowNegative: true,
      currency: 'EUR',
      decimalLimit: 2,
      defaultValue: 0,
      disabled: true,
    },
  },
};
