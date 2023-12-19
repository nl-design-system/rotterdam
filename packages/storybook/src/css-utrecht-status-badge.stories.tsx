/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { StatusBadge } from '@utrecht/component-library-react/dist/css-module';
import readme from './status-badge.md?raw';

const meta = {
  title: 'CSS Component/Status badge',
  id: 'css-utrecht-status-badge',
  component: StatusBadge,
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
        'Light blue': 'utrecht-status-badge--rods-light-yellow',
        Blue: 'utrecht-status-badge--rods-blue',
        'Dark blue': 'utrecht-status-badge--rods-dark-blue',
        'Green blue': 'utrecht-status-badge--rods-green-blue',
        Red: 'utrecht-status-badge--rods-red',
        'Dark yellow': 'utrecht-status-badge--rods-dark-yellow',
      },
    },
  },
  args: {
    children: '',
    status: 'fixme',
  },
  tags: ['autodocs'],
  parameters: {
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Fstatus-badge',
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=6359-9671',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
} satisfies Meta<typeof StatusBadge>;

export default meta;

type Story = StoryObj<typeof meta>;

export const LightBlue: Story = {
  name: 'Light blue',
  args: {
    children: 'label',
    className: 'utrecht-status-badge--rods-light-blue',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=23506-12391&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};

export const Blue: Story = {
  name: 'Blue',
  args: {
    children: 'label',
    className: 'utrecht-status-badge--rods-blue',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=17304-11317&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};

export const DarkBlue: Story = {
  name: 'Dark blue',
  args: {
    children: 'label',
    className: 'utrecht-status-badge--rods-dark-blue',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=23506-12383&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};

export const GreenBlue: Story = {
  name: 'Green blue',
  args: {
    children: 'label',
    className: 'utrecht-status-badge--rods-green-blue',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=23506-12151&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};

export const Red: Story = {
  name: 'Red',
  args: {
    children: 'label',
    className: 'utrecht-status-badge--rods-red',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=23506-12367&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};

export const DarkYellow: Story = {
  name: 'Dark yellow',
  args: {
    children: 'label',
    className: 'utrecht-status-badge--rods-dark-yellow',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=23506-12375&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};
