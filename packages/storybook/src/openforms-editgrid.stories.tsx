import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const innerComponents = [
  {
    input: true,
    key: 'name',
    label: 'Item name',
    type: 'textfield',
  },
  {
    allowNegative: false,
    currency: 'EUR',
    delimiter: true,
    input: true,
    key: 'prijs',
    label: 'Price',
    type: 'currency',
  },
  {
    html: '<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>',
    input: false,
    key: 'content',
    label: '',
    tableView: false,
    type: 'content',
  },
];

const meta = {
  id: 'open-forms-edit-grid',
  args: {
    extraComponentProperties: {
      addAnother: 'Add new',
      components: innerComponents,
      description: 'Adds a new group to the grid',
      disableAddingRemovingRows: false,
      groupLabel: '',
      hideLabel: false,
      inlineEdit: false,
      maxLength: null,
      removeRow: 'Remove',
      saveRow: 'Confirm',
    },

    type: 'editgrid',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/EditGrid',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {};
