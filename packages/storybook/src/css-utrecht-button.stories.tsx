/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Button } from '@utrecht/component-library-react/dist/css-module';
import readme from './button.md?raw';
import '@gemeente-rotterdam/components-css/button/index.scss';

const meta = {
  title: 'CSS Component/Button',
  id: 'css-utrecht-button',
  component: Button,
  argTypes: {
    children: {
      name: 'Content',
      description: 'Button text',
      type: {
        name: 'string',
        required: true,
      },
      defaultValue: '',
    },
  },
  args: {
    children: '',
  },
  tags: ['autodocs'],
  parameters: {
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
} satisfies Meta<typeof Button>;

export default meta;

type Story = StoryObj<typeof meta>;

export const DefaultButton: Story = {
  name: 'Default button',
  args: {
    children: 'Label',
  },
};

export const PrimaryActionButton: Story = {
  name: 'Primary action button',
  args: {
    appearance: 'primary-action-button',
    children: 'Label',
  },
};

export const SecondaryActionButton: Story = {
  name: 'Secondary action button',
  args: {
    appearance: 'secondary-action-button',
    children: 'Label',
  },
};

export const SubtleButton: Story = {
  name: 'Subtle button',
  args: {
    appearance: 'subtle-button',
    children: 'Label',
  },
};
