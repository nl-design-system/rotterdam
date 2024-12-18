/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { FormLabel } from '@utrecht/component-library-react/dist/css-module';
import readme from './form-label.md?raw';

const meta = {
  title: 'CSS Component/Form label',
  id: 'css-utrecht-form-label',
  component: FormLabel,
  argTypes: {
    children: {
      name: 'Content',
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
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Fform-label',
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=435-13376',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
} satisfies Meta<typeof FormLabel>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Form label',
  args: {
    children: 'Label',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/design/iWuQsxelJzXVfCge87Og81/RODS-component?node-id=1-4753&t=EXoPmctpkctdqa4z-4',
    },
  },
};
