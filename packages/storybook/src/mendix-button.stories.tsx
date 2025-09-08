/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Button } from '@utrecht/component-library-react/dist/css-module';
import '@gemeente-rotterdam/mendix-css/dist/mendix-nl-design-system-rotterdam-theme.css';

const meta = {
  id: 'mendix-button',
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
  title: 'Mendix Component/Button',
} satisfies Meta<typeof Button>;

export default meta;

type Story = StoryObj<typeof meta>;

export const DefaultButton: Story = {
  name: 'Default button',
  args: {
    children: 'Label',
  },
  render: () => (
    <button
      type="button"
      className="btn mx-button mx-name-actionButton3 btn-default"
      title=""
      data-button-id="18.Forms.Home_Anonymous.actionButton3"
      data-disabled="false"
    >
      Button
    </button>
  ),
};

export const DefaultDisabledButton: Story = {
  name: 'Disabled button',
  args: {
    children: 'Label',
  },
  render: () => (
    <button
      type="button"
      className="btn mx-button mx-name-actionButton3 btn-default"
      title=""
      data-button-id="18.Forms.Home_Anonymous.actionButton3"
      data-disabled="false"
      disabled
    >
      Button
    </button>
  ),
};

/* TODO: Support icons */
/*
export const ButtonWithIcon: Story = {
  name: 'Button with icon',
  args: {
    children: 'Label',
  },
  render: () => (
    <button
      type="button"
      className="btn mx-button mx-name-actionButton1 btn-default"
      title=""
      data-button-id="18.Forms.Home_Anonymous.actionButton1"
      data-disabled="false"
    >
      <span className="mx-icon-lined mx-icon-zoom-in" aria-hidden="true"></span> Button with icon
    </button>
  ),
};
*/

export const InverseButton: Story = {
  name: 'Inverse button',
  args: {
    children: 'Label',
  },
  render: () => (
    <button
      type="button"
      className="btn mx-button mx-name-actionButton4 btn-inverse"
      title=""
      data-button-id="18.Forms.Home_Anonymous.actionButton4"
      data-disabled="false"
    >
      Inverse button
    </button>
  ),
};

export const PrimaryButton: Story = {
  name: 'Primary button',
  args: {
    children: 'Label',
  },
  render: () => (
    <button
      type="button"
      className="btn mx-button mx-name-actionButton5 btn-primary"
      title=""
      data-button-id="18.Forms.Home_Anonymous.actionButton5"
      data-disabled="false"
    >
      Primary button
    </button>
  ),
};

export const InfoButton: Story = {
  name: 'Info button',
  args: {
    children: 'Label',
  },
  render: () => (
    <button
      type="button"
      className="btn mx-button mx-name-actionButton6 btn-info"
      title=""
      data-button-id="18.Forms.Home_Anonymous.actionButton6"
      data-disabled="false"
    >
      Info button
    </button>
  ),
};
export const SuccessButton: Story = {
  name: 'Success button',
  args: {
    children: 'Label',
  },
  render: () => (
    <button
      type="button"
      className="btn mx-button mx-name-actionButton7 btn-success"
      title=""
      data-button-id="18.Forms.Home_Anonymous.actionButton7"
      data-disabled="false"
    >
      Success button
    </button>
  ),
};
export const WarningButton: Story = {
  name: 'Warning button',
  args: {
    children: 'Label',
  },
  render: () => (
    <button
      type="button"
      className="btn mx-button mx-name-actionButton8 btn-warning"
      title=""
      data-button-id="18.Forms.Home_Anonymous.actionButton8"
      data-disabled="false"
    >
      Warning button
    </button>
  ),
};

export const DangerButton: Story = {
  name: 'Danger button',
  args: {
    children: 'Label',
  },
  render: () => (
    <button
      type="button"
      className="btn mx-button mx-name-actionButton9 btn-danger"
      title=""
      data-button-id="18.Forms.Home_Anonymous.actionButton9"
      data-disabled="false"
    >
      Danger button
    </button>
  ),
};

export const ButtonAsLink: Story = {
  name: 'Button as link',
  args: {
    children: 'Label',
  },
  render: () => (
    <a
      className="mx-link mx-name-actionButton10"
      href="#"
      role="button"
      title=""
      data-button-id="16.Forms.Home_Anonymous.actionButton10"
      data-disabled="false"
    >
      Button that looks like a link
    </a>
  ),
};

/* TODO: Support icons */
/*
export const ButtonAsLinkWithIcon: Story = {
  name: 'Button as link with icon',
  args: {
    children: 'Label',
  },
  render: () => (
    <a
      className="mx-link mx-name-actionButton10"
      href="#"
      role="button"
      title=""
      data-button-id="16.Forms.Home_Anonymous.actionButton10"
      data-disabled="false"
    >
      Button that looks like a link
    </a>
  ),
};
*/
