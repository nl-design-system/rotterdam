/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Textbox } from '@utrecht/component-library-react/dist/css-module';
import readme from './textbox.md?raw';

const meta = {
  title: 'CSS Component/Textbox',
  id: 'css-utrecht-textbox',
  component: Textbox,
  argTypes: {
    defaultValue: {
      name: 'Content',
      type: {
        name: 'string',
        required: true,
      },
      defaultValue: '',
    },
  },
  args: {
    defaultValue: '',
  },
  tags: ['autodocs'],
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=521-28176',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
} satisfies Meta<typeof Textbox>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Textbox',
  args: {
    defaultValue: 'Text',
  },
};

export const Disabled: Story = {
  name: 'Disabled',
  args: {
    defaultValue: 'Text',
    disabled: true,
  },
};

export const Invalid: Story = {
  name: 'Invalid',
  args: {
    defaultValue: 'Text',
    invalid: true,
  },
};

export const Search: Story = {
  name: 'Search',
  args: {
    defaultValue: '',
    placeholder: 'Zoeken',
    type: 'search',
  },
};
