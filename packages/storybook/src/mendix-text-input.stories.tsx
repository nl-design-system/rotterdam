/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Button } from '@utrecht/component-library-react/dist/css-module';
import '@gemeente-rotterdam/mendix-css/dist/mendix-nl-design-system-rotterdam-theme.css';

const meta = {
  id: 'mendix-form-fieldtext-input',
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
  title: 'Mendix Component/Form field text input',
} satisfies Meta<typeof Button>;

export default meta;

type Story = StoryObj<typeof meta>;

export const TextInput: Story = {
  name: 'Textbox',
  args: {
    children: 'Label',
  },
  render: () => (
    <div className="mx-textbox form-group no-columns">
      <label
        className="control-label"
        htmlFor="31.Forms.Page1_TextInput.textBox13_rai_32"
        id="31.Forms.Page1_TextInput.textBox13_rai_32-label"
      >
        Ask a question here or request information
      </label>
      <input
        id="31.Forms.Page1_TextInput.textBox13_rai_32"
        className="form-control"
        type="text"
        maxLength={200}
        mask=""
        autoComplete="on"
        value=""
      />
    </div>
  ),
};

export const TextInputNoLabel: Story = {
  name: 'Textbox without label',
  render: () => (
    <div className="mx-textbox form-group no-columns">
      <input className="form-control" type="text" maxLength={2000} mask="" autoComplete="name" value="" />
    </div>
  ),
};

export const DisabledTextInput: Story = {
  name: 'Disabled textbox',
  args: {
    children: 'Label',
  },
  render: () => (
    <div className="mx-textbox form-group no-columns">
      <label
        className="control-label"
        htmlFor="31.Forms.Page1_TextInput.textBox13_rai_35"
        id="31.Forms.Page1_TextInput.textBox13_rai_35-label"
      >
        Ask a question here or request information
      </label>
      <input
        id="31.Forms.Page1_TextInput.textBox13_rai_35"
        className="form-control"
        type="text"
        maxLength={200}
        mask=""
        autoComplete="on"
        value=""
        disabled
      />
    </div>
  ),
};
