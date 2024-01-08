/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { RadioButton } from '@utrecht/component-library-react/dist/css-module';
import readme from './radio-group.md?raw';

const meta = {
  title: 'CSS Component/Radio-group',
  id: 'css-denhaag-Radio-Group',
  component: RadioButton,
  tags: ['autodocs'],
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=521%3A28182',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
} satisfies Meta<typeof RadioButton>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Radio Group',
  args: {
    checked: false,
    disabled: false,
    invalid: false,
  },
};
