/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Button } from '@utrecht/component-library-react/dist/css-module';
import '@gemeente-rotterdam/mendix-css/dist/mendix-nl-design-system-rotterdam-theme.css';

const meta = {
  title: 'Mendix Component/Form field textarea',
  id: 'mendix-form-field-textarea',
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
      data-mendix-id="31.Forms.Page1_TextInput.textArea1$formGroup"
      data-widget-wrapper="true"
      className=""
      id="mxui_widget_Wrapper_14"
      widgetid="mxui_widget_Wrapper_14"
      style={{ display: ' contents !important;' }}
    >
      <div className="mx-name-textArea1 mx-textarea form-group no-columns">
        <label
          className="control-label"
          htmlFor="31.Forms.Page1_TextInput.textArea1_rai_34"
          id="31.Forms.Page1_TextInput.textArea1_rai_34-label"
        >
          Inputs come in various shapes and sizes
        </label>
        <textarea
          id="31.Forms.Page1_TextInput.textArea1_rai_34"
          className="form-control mx-textarea-input mx-textarea-noresize"
          maxLength={200}
          style={{ height: '144px !important' }}
        ></textarea>
      </div>
    </div>
  ),
};

export const DisabledTextarea: Story = {
  name: 'Disabled textarea',
  args: {
    children: 'Label',
  },
  render: () => (
    <div
      data-mendix-id="31.Forms.Page1_TextInput.textArea1$formGroup"
      data-widget-wrapper="true"
      className=""
      id="mxui_widget_Wrapper_14"
      widgetid="mxui_widget_Wrapper_14"
      style={{ display: ' contents !important;' }}
    >
      <div className="mx-name-textArea1 mx-textarea form-group no-columns">
        <label
          className="control-label"
          htmlFor="31.Forms.Page1_TextInput.textArea1_rai_34"
          id="31.Forms.Page1_TextInput.textArea1_rai_34-label"
        >
          Inputs come in various shapes and sizes
        </label>
        <textarea
          id="31.Forms.Page1_TextInput.textArea1_rai_34"
          className="form-control mx-textarea-input mx-textarea-noresize"
          maxLength={200}
          style={{ height: '144px !important' }}
          disabled
        ></textarea>
      </div>
    </div>
  ),
};
