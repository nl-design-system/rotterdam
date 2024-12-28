/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Button } from '@utrecht/component-library-react/dist/css-module';
import '@gemeente-rotterdam/mendix-css/dist/mendix-nl-design-system-rotterdam-theme.css';

const meta = {
  id: 'mendix-breadcrumb-nav',
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
  title: 'Mendix Component/Breadcrumbs',
} satisfies Meta<typeof Button>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Breadcrumbs: Story = {
  name: 'Breadcrumbs',
  args: {
    children: 'Label',
  },
  render: () => (
    <div className="mx-name-container14 breadcrumb spacing-outer-bottom-large">
      <a
        className="mx-link mx-name-actionButton13 breadcrumb-item"
        href="#"
        role="button"
        title=""
        data-button-id="16.Forms.Home_Anonymous.actionButton13"
        data-disabled="false"
      >
        {' '}
        Item 1
      </a>
      <a
        className="mx-link mx-name-actionButton12 breadcrumb-item"
        href="#"
        role="button"
        title=""
        data-button-id="16.Forms.Home_Anonymous.actionButton12"
        data-disabled="false"
      >
        {' '}
        Item 2
      </a>
      <a
        className="mx-link mx-name-actionButton14 breadcrumb-item"
        href="#"
        role="button"
        title=""
        data-button-id="16.Forms.Home_Anonymous.actionButton14"
        data-disabled="false"
      >
        {' '}
        Item 3
      </a>
    </div>
  ),
};
