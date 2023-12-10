/* @license CC0-1.0 */

import { RodsLogoImage } from '@gemeente-rotterdam/web-components-react';
import type { Meta, StoryObj } from '@storybook/react';
import readme from './logo-image.md?raw';

const meta = {
  title: 'Web Component/Logo image',
  id: 'web-component-rods-logo-image',
  component: RodsLogoImage,
  argTypes: {},
  args: {},
  tags: ['autodocs'],
  parameters: {
    docs: {
      description: {
        component: readme,
      },
    },
  },
} satisfies Meta<typeof RodsLogoImage>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {};
