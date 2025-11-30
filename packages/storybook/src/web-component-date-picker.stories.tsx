/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react-vite';
import readme from '@gemeente-rotterdam/date-picker-element/README.md?raw';
import { DecoratorFunction } from 'storybook/internal/csf';

const DatePicker = ({ lang, options, value }: DatePickerProps) => (
  <rods-date-picker lang={lang || undefined} value={value || undefined} options={JSON.stringify(options)}>
    {/* Hack to prevent a self-closing tag in "Show code" in Storybook*/}
    {'\u00A0'}
  </rods-date-picker>
);

DatePicker.displayName = 'rods-date-picker';

const meta = {
  id: 'rods-date-picker',
  args: {
    options: [{ value: '2025-11-02T13:00' }, { value: '2025-12-31T09:00' }, { value: '2026-01-15T20:00' }],
  },
  argTypes: {
    lang: {
      name: 'Language',
      control: 'select',
      defaultValue: '',
      options: [undefined, 'nl', 'en'],
    },
    options: {
      name: 'Options',
      control: 'select',
      defaultValue: '',
      options: [
        [{ value: '2025-11-02T13:00' }, { value: '2025-12-31T09:00' }, { value: '2026-01-15T20:00' }],
        [
          { label: 'middag', value: '2025-11-02T13:00' },
          { label: 'ochtend', value: '2025-12-31T09:00' },
          { label: 'avond', value: '2026-01-15T20:00' },
        ],
      ],
    },
    value: {
      name: 'Value',
      defaultValue: '',
      description: 'For example: 2025-12-31T12:00:00',
      type: {
        name: 'string',
        required: true,
      },
    },
  },
  component: DatePicker,
  parameters: {
    docs: {
      description: {
        component: readme,
      },
    },
  },
  tags: ['autodocs'],
  title: 'Web Component/Date Picker',
} satisfies Meta<typeof DatePicker>;

export default meta;

const DesktopDecorator: DecoratorFunction = (Story) => <div style={{ minInlineSize: '1280px' }}>{Story()}</div>;

const MobileDecorator: DecoratorFunction = (Story) => (
  <div style={{ maxInlineSize: '1179px', position: 'relative' }}>{Story()}</div>
);
type Story = StoryObj<typeof meta>;

export const Desktop: Story = {
  name: 'Desktop layout',
  args: {},
  decorators: [DesktopDecorator],
};

export const Mobile: Story = {
  name: 'Mobile layout',
  args: {},
  decorators: [MobileDecorator],
};

export const DesktopValue: Story = {
  name: 'Desktop with existing value',
  args: {
    options: [{ value: '2025-12-31T12:00:00' }],
    value: '2025-12-31T12:00:00',
  },
  decorators: [DesktopDecorator],
};

export const English: Story = {
  name: 'English user interface',
  args: {
    lang: 'en',
  },
  decorators: [DesktopDecorator],
};

export const CustomOptionLabel: Story = {
  name: 'Custom option label',
  args: {
    options: [
      {
        label: 'ochtend',
        value: '2025-12-31T09:00:00',
      },
      {
        label: 'middag',
        value: '2025-12-31T13:00:00',
      },
      {
        label: 'avond',
        value: '2025-12-31T18:00:00',
      },
    ],
  },
  decorators: [DesktopDecorator],
};
