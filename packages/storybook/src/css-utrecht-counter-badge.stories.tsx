/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { BadgeCounter } from '@utrecht/component-library-react/dist/css-module';
import readme from './counter-badge.md?raw';

const meta = {
  id: 'css-utrecht-badge-counter',
  args: {
    children: '',
  },
  argTypes: {
    children: {
      name: 'Content',
      defaultValue: '',
      type: {
        name: 'string',
        required: true,
      },
    },
    className: {
      name: 'Appearance',
      control: {
        labels: {
          Blue: 'utrecht-badge-counter--rods-blue',
          'Dark blue': 'utrecht-badge-counter--rods-dark-blue',
          'Dark yellow': 'utrecht-badge-counter--rods-dark-yellow',
          'Green blue': 'utrecht-badge-counter--rods-green-blue',
          'Light blue': 'utrecht-badge-counter--rods-light-yellow',
          Red: 'utrecht-badge-counter--rods-red',
        },
        type: 'select',
      },
      options: [
        'utrecht-badge-counter--rods-light-yellow',
        'utrecht-badge-counter--rods-blue',
        'utrecht-badge-counter--rods-dark-blue',
        'utrecht-badge-counter--rods-green-blue',
        'utrecht-badge-counter--rods-red',
        'utrecht-badge-counter--rods-dark-yellow',
      ],
    },
  },
  component: BadgeCounter,
  parameters: {
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Fcounter-badge',
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
  tags: ['autodocs'],
  title: 'CSS Component/Counter badge',
} satisfies Meta<typeof BadgeCounter>;

export default meta;

type Story = StoryObj<typeof meta>;

export const LightBlue: Story = {
  name: 'Light blue',
  args: {
    children: '35',
    className: 'utrecht-badge-counter--rods-light-blue',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/design/iWuQsxelJzXVfCge87Og81/RODS-component?node-id=26-8429&t=EXoPmctpkctdqa4z-4',
    },
  },
};

export const Blue: Story = {
  name: 'Blue',
  args: {
    children: '35',
    className: 'utrecht-badge-counter--rods-blue',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=7927-10550&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};

export const DarkBlue: Story = {
  name: 'Dark blue',
  args: {
    children: '35',
    className: 'utrecht-badge-counter--rods-dark-blue',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=7961-9861&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};

export const GreenBlue: Story = {
  name: 'Green blue',
  args: {
    children: '35',
    className: 'utrecht-badge-counter--rods-green-blue',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=7961-9852&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};

export const Red: Story = {
  name: 'Red',
  args: {
    children: '35',
    className: 'utrecht-badge-counter--rods-red',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=7961-9855&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};

export const DarkYellow: Story = {
  name: 'Dark yellow',
  args: {
    children: '35',
    className: 'utrecht-badge-counter--rods-dark-yellow',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=7961-9858&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};
