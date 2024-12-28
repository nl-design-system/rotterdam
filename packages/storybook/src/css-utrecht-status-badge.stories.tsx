/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { StatusBadge } from '@utrecht/component-library-react/dist/css-module';
import readme from './status-badge.md?raw';

const meta = {
  id: 'css-utrecht-status-badge',
  args: {
    children: '',
    status: 'fixme',
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
          Blue: 'utrecht-status-badge--rods-blue',
          'Dark blue': 'utrecht-status-badge--rods-dark-blue',
          'Dark yellow': 'utrecht-status-badge--rods-dark-yellow',
          'Green blue': 'utrecht-status-badge--rods-green-blue',
          'Light blue': 'utrecht-status-badge--rods-light-yellow',
          Red: 'utrecht-status-badge--rods-red',
        },
        type: 'select',
      },
      options: [
        'utrecht-status-badge--rods-light-yellow',
        'utrecht-status-badge--rods-blue',
        'utrecht-status-badge--rods-dark-blue',
        'utrecht-status-badge--rods-green-blue',
        'utrecht-status-badge--rods-red',
        'utrecht-status-badge--rods-dark-yellow',
      ],
    },
  },
  component: StatusBadge,
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
  tags: ['autodocs'],
  title: 'CSS Component/Status badge',
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
      url: 'https://www.figma.com/design/iWuQsxelJzXVfCge87Og81/RODS-component?node-id=1-5900&t=EXoPmctpkctdqa4z-4',
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
