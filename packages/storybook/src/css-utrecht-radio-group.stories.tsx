/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import {
  Fieldset,
  FieldsetLegend,
  FormField,
  FormLabel,
  Paragraph,
  RadioButton,
} from '@utrecht/component-library-react/dist/css-module';
import readme from './radio-group.md?raw';

const meta = {
  title: 'CSS Component/Radio-group',
  id: 'css-denhaag-Radio-Group',
  component: Fieldset,
  argTypes: {
    children: {
      name: 'Content',
      type: {
        name: 'string',
        required: true,
      },
      defaultValue: '',
    },
  },
  tags: ['autodocs'],
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=521%3A28182',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
} satisfies Meta<typeof Fieldset>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Radio Group',
  args: {
    children: [
      <FieldsetLegend>Choose your option</FieldsetLegend>,
      <FormField type="radio">
        <Paragraph className="utrecht-form-field__label utrecht-form-field__label--radio">
          <FormLabel htmlFor="800b7f3f-5048-4dcc-8f23-d04fa6ca4199" type="radio">
            <RadioButton
              className="utrecht-form-field__input"
              id="800b7f3f-5048-4dcc-8f23-d04fa6ca4199"
              name="828aa90e-0e99-4db9-a5e5-d39f689cf7b3"
              value="1"
            />
            Option 1
          </FormLabel>
        </Paragraph>
      </FormField>,
      <FormField type="radio">
        <Paragraph className="utrecht-form-field__label utrecht-form-field__label--radio">
          <FormLabel htmlFor="fbc03e63-42c2-46e3-9acc-183fa64c6dcd" type="radio">
            <RadioButton
              className="utrecht-form-field__input"
              id="fbc03e63-42c2-46e3-9acc-183fa64c6dcd"
              name="828aa90e-0e99-4db9-a5e5-d39f689cf7b3"
              value="2"
            />
            Option 2
          </FormLabel>
        </Paragraph>
      </FormField>,
      <FormField type="radio">
        <Paragraph className="utrecht-form-field__label utrecht-form-field__label--radio">
          <FormLabel htmlFor="62824075-bcc1-4563-a97b-78d1eae3544f" type="radio">
            <RadioButton
              className="utrecht-form-field__input"
              id="62824075-bcc1-4563-a97b-78d1eae3544f"
              name="828aa90e-0e99-4db9-a5e5-d39f689cf7b3"
              value="3"
            />
            Option 3
          </FormLabel>
        </Paragraph>
      </FormField>,
    ],
  },
};
