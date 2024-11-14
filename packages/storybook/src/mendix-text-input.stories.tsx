/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Button } from '@utrecht/component-library-react/dist/css-module';
import '@gemeente-rotterdam/mendix-css/dist/mendix-nl-design-system-rotterdam-theme.css';

const meta = {
  title: 'Mendix Component/Form field text input',
  id: 'mendix-form-fieldtext-input',
  component: Button,
  argTypes: {
    children: {
      name: 'Content',
      description: 'Button text',
      type: {
        name: 'string',
        required: true,
      },
      defaultValue: '',
    },
  },
  args: {
    children: '',
  },
  tags: ['autodocs'],
  parameters: {},
} satisfies Meta<typeof Button>;

export default meta;

type Story = StoryObj<typeof meta>;

export const TextInput: Story = {
  name: 'Text input',
  args: {
    children: 'Label',
  },
  render: () => (
    <div
      data-mendix-id="31.Forms.Page1_TextInput.textBox13$formGroup"
      data-widget-wrapper="true"
      className=""
      id="mxui_widget_Wrapper_11"
      widgetid="mxui_widget_Wrapper_11"
      style={{ display: ' contents !important;' }}
    >
      <div className="mx-name-textBox13 mx-textbox form-group no-columns">
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
    </div>
  ),
};

export const DisabledTextInput: Story = {
  name: 'Disabled text input',
  args: {
    children: 'Label',
  },
  render: () => (
    <div
      data-mendix-id="31.Forms.Page1_TextInput.textBox13$formGroup"
      data-widget-wrapper="true"
      className=""
      id="mxui_widget_Wrapper_11"
      widgetid="mxui_widget_Wrapper_11"
      style={{ display: ' contents !important;' }}
    >
      <div className="mx-name-textBox13 mx-textbox form-group no-columns">
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
          disabled
        />
      </div>
    </div>
  ),
};
