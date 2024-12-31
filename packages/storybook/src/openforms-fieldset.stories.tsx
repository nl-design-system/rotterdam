import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-fieldset',
  args: {
    key: 'fieldset',
    label: 'Fieldset',
    type: 'fieldset',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/Fieldset',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    extraComponentProperties: {
      components: [
        {
          description: 'Voor- en achternaam zoals op je identiteitsbewijs',
          input: true,
          key: 'name-a',
          label: 'Naam persoon 1',
          required: true,
          type: 'textfield',
        },
        {
          description: 'Voor- en achternaam zoals op je identiteitsbewijs',
          input: true,
          key: 'name-b',
          label: 'Naam persoon 2',
          required: true,
          type: 'textfield',
        },
      ],
    },
  },
};
