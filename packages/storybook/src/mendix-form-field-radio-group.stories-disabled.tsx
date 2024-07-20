/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Button } from '@utrecht/component-library-react/dist/css-module';
import '@gemeente-rotterdam/mendix-css/dist/mendix-nl-design-system-rotterdam-theme.css';

const meta = {
  title: 'Mendix Component/Form field radio group',
  id: 'mendix-form-field-radio-group',
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
  name: 'Form field with radio group',
  args: {
    children: 'Label',
  },
  render: () => (
    <div
      data-mendix-id="31.Forms.Page1_TextInput.dataView3"
      data-widget-wrapper="true"
      className=""
      id="mxui_widget_Wrapper_18"
      widgetid="mxui_widget_Wrapper_18"
      style={{ display: ' contents !important;' }}
    >
      <div className="mx-dataview mx-name-dataView3 form-vertical">
        <div className="mx-dataview-content">
          <div className="mx-name-radioButtons5 mx-radiobuttons form-group no-columns">
            <label
              className="control-label"
              for="31.Forms.Page1_TextInput.radioButtons5_rai_37"
              id="31.Forms.Page1_TextInput.radioButtons5_rai_37-label"
            >
              Answer as single choice
            </label>
            <div
              id="31.Forms.Page1_TextInput.radioButtons5_rai_37"
              className="mx-radiogroup"
              aria-labelledby="31.Forms.Page1_TextInput.radioButtons5_rai_37-label"
              role="radiogroup"
            >
              <div className="radio">
                <input
                  type="radio"
                  id="31.Forms.Page1_TextInput.radioButtons5_rai_37_0"
                  name="31.Forms.Page1_TextInput.radioButtons5_rai_37"
                  value="Choice1"
                />
                <label for="31.Forms.Page1_TextInput.radioButtons5_rai_37_0">Choice 1</label>
              </div>
              <div className="radio">
                <input
                  type="radio"
                  id="31.Forms.Page1_TextInput.radioButtons5_rai_37_1"
                  name="31.Forms.Page1_TextInput.radioButtons5_rai_37"
                  value="Choice2"
                  tabindex="-1"
                />
                <label for="31.Forms.Page1_TextInput.radioButtons5_rai_37_1">Choice 2</label>
              </div>
              <div className="radio">
                <input
                  type="radio"
                  id="31.Forms.Page1_TextInput.radioButtons5_rai_37_2"
                  name="31.Forms.Page1_TextInput.radioButtons5_rai_37"
                  value="Choice3"
                  tabindex="-1"
                />
                <label for="31.Forms.Page1_TextInput.radioButtons5_rai_37_2">Choice 3</label>
              </div>
            </div>
          </div>
        </div>
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
      data-mendix-id="31.Forms.Page1_TextInput.dataView3"
      data-widget-wrapper="true"
      className=""
      id="mxui_widget_Wrapper_18"
      widgetid="mxui_widget_Wrapper_18"
      style={{ display: ' contents !important;' }}
    >
      <div className="mx-dataview mx-name-dataView3 form-vertical">
        <div className="mx-dataview-content">
          <div className="mx-name-radioButtons5 mx-radiobuttons form-group no-columns">
            <label
              className="control-label"
              for="31.Forms.Page1_TextInput.radioButtons5_rai_37"
              id="31.Forms.Page1_TextInput.radioButtons5_rai_37-label"
            >
              Answer as single choice
            </label>
            <div
              id="31.Forms.Page1_TextInput.radioButtons5_rai_37"
              className="mx-radiogroup"
              aria-labelledby="31.Forms.Page1_TextInput.radioButtons5_rai_37-label"
              role="radiogroup"
            >
              <div className="radio">
                <input
                  type="radio"
                  id="31.Forms.Page1_TextInput.radioButtons5_rai_37_0"
                  name="31.Forms.Page1_TextInput.radioButtons5_rai_37"
                  value="Choice1"
                  disabled
                />
                <label for="31.Forms.Page1_TextInput.radioButtons5_rai_37_0">Choice 1</label>
              </div>
              <div className="radio">
                <input
                  type="radio"
                  id="31.Forms.Page1_TextInput.radioButtons5_rai_37_1"
                  name="31.Forms.Page1_TextInput.radioButtons5_rai_37"
                  value="Choice2"
                  tabindex="-1"
                  disabled
                />
                <label for="31.Forms.Page1_TextInput.radioButtons5_rai_37_1">Choice 2</label>
              </div>
              <div className="radio">
                <input
                  type="radio"
                  id="31.Forms.Page1_TextInput.radioButtons5_rai_37_2"
                  name="31.Forms.Page1_TextInput.radioButtons5_rai_37"
                  value="Choice3"
                  tabindex="-1"
                  disabled
                />
                <label for="31.Forms.Page1_TextInput.radioButtons5_rai_37_2">Choice 3</label>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  ),
};
