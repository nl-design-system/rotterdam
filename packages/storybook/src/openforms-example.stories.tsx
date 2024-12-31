import { Meta, StoryObj } from '@storybook/react';
import { MultipleFormioComponents } from './StoryUtil';

const meta = {
  id: 'open-forms-voorbeeld',
  args: {
    components: [
      {
        key: '',
        label: '',
        type: '',
      },
    ],
  },
  component: MultipleFormioComponents,
  title: 'Open Formulieren/Voorbeeld',
} satisfies Meta<typeof MultipleFormioComponents>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    components: [
      {
        extraComponentProperties: {
          description: 'Text field description',
          validate: {
            pattern: '^\\d+',
            required: true,
          },
        },
        key: 'textfield',
        label: 'Required text field',
        type: 'textfield',
      },
      {
        extraComponentProperties: {
          validate: {
            required: true,
          },
          values: [
            { label: 'Option A', value: 'a' },
            { label: 'Option B', value: 'b' },
          ],
        },
        key: 'radio',
        label: 'Required radio',
        type: 'radio',
      },
      {
        extraComponentProperties: {
          customClass: 'info',
          html: '<p>Some WYSIWYG content</p>',
        },
        key: 'content',
        label: 'Content',
        type: 'content',
      },
      {
        extraComponentProperties: {
          components: [
            {
              key: 'checkbox',
              label: 'Checkbox',
              type: 'checkbox',
            },
            {
              key: 'nestedTextfield',
              label: 'Nested text field',
              type: 'textfield',
            },
          ],
          hideHeader: true,
        },
        key: 'fieldset',
        label: 'Fieldset label',
        type: 'fieldset',
      },
      {
        extraComponentProperties: {
          hidden: true,
        },
        key: 'hiddenTextfield',
        label: 'Hidden text field',
        type: 'textfield',
      },
      {
        extraComponentProperties: {
          input: true,
          showValidations: false,
        },
        key: 'submit1',
        label: 'Submit',
        type: 'button',
      },
    ],
  },
};
