/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Button } from '@utrecht/component-library-react/dist/css-module';
import '@gemeente-rotterdam/mendix-css/dist/mendix-nl-design-system-rotterdam-theme.css';

const meta = {
  id: 'mendix-badge',
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
  parameters: {},
  tags: ['autodocs'],
  title: 'Mendix Component/Badge',
} satisfies Meta<typeof Button>;

export default meta;

type Story = StoryObj<typeof meta>;

// export const NumberBadge: Story = {
//   name: 'Number badge',
//   args: {
//     children: 'Label',
//   },
//   render: () => <span className="widget-badge badge mx-name-badge1">42</span>,
// };

export const DefaultBadge: Story = {
  name: 'Default badge',
  args: {
    children: 'Label',
  },
  render: () => <span className="widget-badge badge mx-name-badge1">Default badge</span>,
};

export const BrandPrimary: Story = {
  name: 'Brand primary badge',
  args: {
    children: 'Label',
  },
  render: () => <span className="widget-badge badge mx-name-badge2 label-primary">Brand primary</span>,
};

export const BrandSecondary: Story = {
  name: 'Brand secondary badge',
  args: {
    children: 'Label',
  },
  render: () => <span className="widget-badge badge mx-name-badge3 label-secondary">Brand secondary</span>,
};

export const BrandSuccess: Story = {
  name: 'Brand success badge',
  args: {
    children: 'Label',
  },
  render: () => <span className="widget-badge badge mx-name-badge4 label-success">Brand success</span>,
};

export const BrandWarning: Story = {
  name: 'Brand warning badge',
  args: {
    children: 'Label',
  },
  render: () => <span className="widget-badge badge mx-name-badge5 label-warning">Brand warning</span>,
};

export const BrandDanger: Story = {
  name: 'Brand danger badge',
  args: {
    children: 'Label',
  },
  render: () => <span className="widget-badge badge mx-name-badge6 label-danger">Brand danger</span>,
};
