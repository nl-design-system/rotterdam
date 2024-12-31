import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-columns',
  args: {
    extraComponentProperties: {
      columns: [
        {
          components: [
            {
              key: '',
              label: '',
              type: '',
            },
          ],
          size: '',
          sizeMobile: '',
        },
        {
          components: [
            {
              key: '',
              label: '',
              type: '',
            },
          ],
          size: '',
          sizeMobile: '',
        },
      ],
    },
    key: '',
    type: 'columns',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/Columns',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    extraComponentProperties: {
      columns: [
        {
          components: [
            {
              key: 'postcode',
              label: 'Postcode',
              type: 'postcode',
            },
          ],
          size: 3,
          sizeMobile: 6,
        },
        {
          components: [
            {
              key: 'number',
              label: 'Huisnummer',
              type: 'textfield',
            },
          ],
          size: 3,
          sizeMobile: 6,
        },
      ],
    },
    key: 'cosign',
    label: 'columns',
  },
};
