import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-license-plate',
  args: {
    key: '',
    label: '',
    type: 'licenseplate',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/LicensePlateField',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    key: 'licenseplate',
    label: 'Kentekennummer',
  },
};

export const Disabled: Story = {
  args: {
    extraComponentProperties: {
      disabled: true,
    },
    key: 'licenseplate',
    label: 'Kentekennummer',
  },
};
