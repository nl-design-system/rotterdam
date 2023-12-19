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
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Ftextbox',
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
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=435-13663&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};

export const Disabled: Story = {
  name: 'Disabled',
  args: {
    defaultValue: 'Text',
    disabled: true,
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=521-26535&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};

export const Invalid: Story = {
  name: 'Invalid',
  args: {
    defaultValue: 'Text',
    invalid: true,
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=519-32348&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};

export const Search: Story = {
  name: 'Search',
  args: {
    defaultValue: '',
    placeholder: 'Zoeken',
    type: 'search',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=520-26373&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};
