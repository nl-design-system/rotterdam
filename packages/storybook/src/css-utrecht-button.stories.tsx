/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Button } from '@utrecht/component-library-react/dist/css-module';
import readme from './button.md?raw';

const meta = {
  id: 'css-utrecht-button',
  args: {
    children: '',
  },
  argTypes: {
    children: {
      name: 'Content',
      defaultValue: '',
      description: 'Button text',
      type: {
        name: 'string',
        required: true,
      },
    },
  },
  component: Button,
  parameters: {
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Fbutton',
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=415-12054',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
  tags: ['autodocs'],
  title: 'CSS Component/Button',
} satisfies Meta<typeof Button>;

export default meta;

type Story = StoryObj<typeof meta>;

export const DefaultButton: Story = {
  name: 'Default button',
  args: {
    children: 'Label',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/design/iWuQsxelJzXVfCge87Og81/RODS-component?node-id=1-56&t=5SS9SJ1KhfLkhqSu-4',
    },
  },
};

export const PrimaryActionButton: Story = {
  name: 'Primary action button',
  args: {
    appearance: 'primary-action-button',
    children: 'Label',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=487-17716&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};

export const SecondaryActionButton: Story = {
  name: 'Secondary action button',
  args: {
    appearance: 'secondary-action-button',
    children: 'Label',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=772-28371&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};

export const SubtleButton: Story = {
  name: 'Subtle button',
  args: {
    appearance: 'subtle-button',
    children: 'Label',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=487-17717&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};
