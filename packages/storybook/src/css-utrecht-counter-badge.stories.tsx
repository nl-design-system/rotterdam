/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { BadgeCounter } from '@utrecht/component-library-react/dist/css-module';
import readme from './counter-badge.md?raw';

const meta = {
  title: 'CSS Component/Counter badge',
  id: 'css-utrecht-badge-counter',
  component: BadgeCounter,
  argTypes: {
    children: {
      name: 'Content',
      type: {
        name: 'string',
        required: true,
      },
      defaultValue: '',
    },
    className: {
      name: 'Appearance',
      control: 'select',
      options: {
        'Light blue': 'utrecht-badge-counter--rods-light-yellow',
        Blue: 'utrecht-badge-counter--rods-blue',
        'Dark blue': 'utrecht-badge-counter--rods-dark-blue',
        'Green blue': 'utrecht-badge-counter--rods-green-blue',
        Red: 'utrecht-badge-counter--rods-red',
        'Dark yellow': 'utrecht-badge-counter--rods-dark-yellow',
      },
    },
  },
  args: {
    children: '',
  },
  tags: ['autodocs'],
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=7927-10549',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
} satisfies Meta<typeof BadgeCounter>;

export default meta;

type Story = StoryObj<typeof meta>;

export const LightBlue: Story = {
  name: 'Light blue',
  args: {
    children: '35',
    className: 'utrecht-badge-counter--rods-light-blue',
  },
};

export const Blue: Story = {
  name: 'Blue',
  args: {
    children: '35',
    className: 'utrecht-badge-counter--rods-blue',
  },
};

export const DarkBlue: Story = {
  name: 'Dark blue',
  args: {
    children: '35',
    className: 'utrecht-badge-counter--rods-dark-blue',
  },
};

export const GreenBlue: Story = {
  name: 'Green blue',
  args: {
    children: '35',
    className: 'utrecht-badge-counter--rods-green-blue',
  },
};

export const Red: Story = {
  name: 'Red',
  args: {
    children: '35',
    className: 'utrecht-badge-counter--rods-red',
  },
};

export const DarkYellow: Story = {
  name: 'Dark yellow',
  args: {
    children: '35',
    className: 'utrecht-badge-counter--rods-dark-yellow',
  },
};
