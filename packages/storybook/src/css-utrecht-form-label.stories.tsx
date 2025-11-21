/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react-vite';
import { FormLabel } from '@utrecht/component-library-react/dist/css-module';
import readme from './form-label.md?raw';

const meta = {
  id: 'css-utrecht-form-label',
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
  },
  component: FormLabel,
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
  tags: ['autodocs'],
  title: 'CSS Component/Form label',
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
