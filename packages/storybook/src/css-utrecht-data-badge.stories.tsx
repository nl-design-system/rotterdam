/* @license CC0-1.0 */

import type { Decorator, Meta, StoryObj } from '@storybook/react-vite';
import { DataBadge, Link } from '@utrecht/component-library-react/dist/css-module';
import readme from './data-badge.md?raw';

const LinkDecorator: Decorator = (Story) => <Link href="#">{Story()}</Link>;

const meta = {
  id: 'css-utrecht-data-badge',
  args: {
    children: '',
  },
  argTypes: {
    children: {
      name: 'Content',
      defaultValue: '',
      description: 'Data badge text',
      type: {
        name: 'string',
        required: true,
      },
    },
  },
  component: DataBadge,
  parameters: {
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Fdata-badge',
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=20736-12320',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
  tags: ['autodocs'],
  title: 'CSS Component/Data badge',
} satisfies Meta<typeof DataBadge>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Default',
  args: {
    children: 'sustainability',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/design/iWuQsxelJzXVfCge87Og81/RODS-component?node-id=1-5876&t=EXoPmctpkctdqa4z-4',
    },
  },
};

export const BadgeAsLink: Story = {
  name: 'Badge as link',
  args: {
    children: 'sustainability',
  },
  decorators: [LinkDecorator],
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=8202-9795',
    },
    status: {
      type: 'ALPHA',
    },
  },
};

export const LightBlue: Story = {
  name: 'Light blue',
  args: {
    children: 'sustainability',
    className: 'utrecht-data-badge--rods-light-blue',
  },
  parameters: {
    docs: {
      description: {
        story: 'Do not use: this is not part of the Figma designs yet.',
      },
    },
    status: {
      type: 'WORK IN PROGRESS',
    },
  },
};

export const Blue: Story = {
  name: 'Blue',
  args: {
    children: 'sustainability',
    className: 'utrecht-data-badge--rods-blue',
  },
  parameters: {
    docs: {
      description: {
        story: 'Do not use: this is not part of the Figma designs yet.',
      },
    },
    status: {
      type: 'WORK IN PROGRESS',
    },
  },
};

export const DarkBlue: Story = {
  name: 'Dark blue',
  args: {
    children: 'sustainability',
    className: 'utrecht-data-badge--rods-dark-blue',
  },
  parameters: {
    docs: {
      description: {
        story: 'Do not use: this is not part of the Figma designs yet.',
      },
    },
    status: {
      type: 'WORK IN PROGRESS',
    },
  },
};

export const GreenBlue: Story = {
  name: 'Green blue',
  args: {
    children: 'sustainability',
    className: 'utrecht-data-badge--rods-green-blue',
  },
  parameters: {
    docs: {
      description: {
        story: 'Do not use: this is not part of the Figma designs yet.',
      },
    },
    status: {
      type: 'WORK IN PROGRESS',
    },
  },
};

export const Red: Story = {
  name: 'Red',
  args: {
    children: 'sustainability',
    className: 'utrecht-data-badge--rods-red',
  },
  parameters: {
    docs: {
      description: {
        story: 'Do not use: this is not part of the Figma designs yet.',
      },
    },
    status: {
      type: 'WORK IN PROGRESS',
    },
  },
};

export const DarkYellow: Story = {
  name: 'Dark yellow',
  args: {
    children: 'sustainability',
    className: 'utrecht-data-badge--rods-dark-yellow',
  },
  parameters: {
    docs: {
      description: {
        story: 'Do not use: this is not part of the Figma designs yet.',
      },
    },
    status: {
      type: 'WORK IN PROGRESS',
    },
  },
};
