/* @license CC0-1.0 */

import '@gemeente-rotterdam/mendix-css/dist/mendix-nl-design-system-rotterdam-theme.css';
import type { Meta, StoryObj } from '@storybook/react';
import { Button, ButtonProps } from '@utrecht/component-library-react/dist/css-module';

const meta = {
  id: 'mendix-button',
  argTypes: {
    disabled: {
      name: 'Disabled',
      control: { type: 'radio' },
      defaultValue: '',
      description: 'Disabled state',
      options: [true, false],
      type: {
        name: 'boolean',
        required: false,
      },
    },
    label: {
      name: 'Content',
      defaultValue: '',
      description: 'Button text',
      type: {
        name: 'string',
        required: true,
      },
    },
    title: {
      name: 'Tooltip',
      defaultValue: 'Tooltip text',
      description: 'Default HTML tooltip text',
      type: {
        name: 'string',
        required: false,
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
    disabled: false,
    label: 'Button',
    title: '',
  },
  render: (props: ButtonProps) => (
    <button
      type="button"
      className="btn mx-button btn-default"
      title={props.title}
      data-disabled={props.disabled}
      disabled={props.disabled}
    >
      {props.label}
    </button>
  ),
};

export const DefaultDisabledButton: Story = {
  name: 'Disabled button',
  args: {
    disabled: true,
    label: 'Button',
  },
  render: (props: ButtonProps) => (
    <button
      type="button"
      className="btn mx-button btn-default"
      title={props.title}
      data-disabled={props.disabled}
      disabled={props.disabled}
    >
      {props.label}
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
  render: (props: ButtonProps) => (
    <button
      type="button"
      className="btn mx-button btn-inverse"
      title={props.title}
      data-disabled={props.disabled}
      disabled={props.disabled}
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
  render: (props: ButtonProps) => (
    <button
      type="button"
      className="btn mx-button btn-primary"
      title={props.title}
      data-disabled={props.disabled}
      disabled={props.disabled}
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
  render: (props: ButtonProps) => (
    <button
      type="button"
      className="btn mx-button btn-info"
      title={props.title}
      data-disabled={props.disabled}
      disabled={props.disabled}
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
  render: (props: ButtonProps) => (
    <button
      type="button"
      className="btn mx-button btn-success"
      title={props.title}
      data-disabled={props.disabled}
      disabled={props.disabled}
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
  render: (props: ButtonProps) => (
    <button
      type="button"
      className="btn mx-button btn-warning"
      title={props.title}
      data-disabled={props.disabled}
      disabled={props.disabled}
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
  render: (props: ButtonProps) => (
    <button
      type="button"
      className="btn mx-button btn-danger"
      title={props.title}
      data-disabled={props.disabled}
      disabled={props.disabled}
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
  render: (props: ButtonProps) => (
    <a
      className="mx-link"
      href="#"
      role="button"
      title={props.title}
      data-disabled={props.disabled}
      // disabled={props.disabled}
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
      className="mx-link"
      href="#"
      role="button"
      title=""
      data-disabled="false"
    >
      Button that looks like a link
    </a>
  ),
};
*/
