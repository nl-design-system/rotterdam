/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react-vite';
import {
  RodsLogoImage,
  RodsLogoImageAvatar,
  RodsLogoImageMark,
  RodsLogoImageSquare,
} from '@gemeente-rotterdam/web-components-react';
import logoImageAvatarDocs from './_logo-image-avatar.md?raw';
import logoImageBaseDocs from './_logo-image-base.md?raw';
import logoImageMarkDocs from './_logo-image-mark.md?raw';
import logoImageSquareDocs from './_logo-image-square.md?raw';
import readme from './logo-image.md?raw';

const meta = {
  id: 'web-component-rods-logo-image',
  args: {},
  argTypes: {},
  component: RodsLogoImage,
  parameters: {
    docs: {
      description: {
        component: readme,
      },
    },
  },
  tags: ['autodocs'],
  title: 'Web Component/Logo image',
} satisfies Meta<typeof RodsLogoImage>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Base: Story = {
  name: 'Base logo',
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/design/RiVsTfcbmnKSU2BGqQBI9n/RODS-fundament?node-id=1-1385',
    },
    docs: {
      description: {
        story: logoImageBaseDocs,
      },
    },
  },
};

export const Square: Story = {
  name: 'Square logo',
  parameters: {
    docs: {
      description: {
        story: logoImageSquareDocs,
      },
    },
  },
  render: () => <RodsLogoImageSquare />,
};

export const Mark: Story = {
  name: 'Mark',
  parameters: {
    docs: {
      description: {
        story: logoImageMarkDocs,
      },
    },
  },
  render: () => <RodsLogoImageMark />,
};

export const Avatar: Story = {
  name: 'Avatars & favicons',
  parameters: {
    docs: {
      description: {
        story: logoImageAvatarDocs,
      },
    },
  },
  render: () => <RodsLogoImageAvatar />,
};
