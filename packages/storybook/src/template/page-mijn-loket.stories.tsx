import { Meta, StoryObj } from '@storybook/react';

const meta = {
  title: 'Template/Mijn Loket',
  id: 'template-mijn-loket',
} satisfies Meta;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  render: (args) => (
    <div {...args}>
      <p>Hello world!</p>
    </div>
  ),
};
