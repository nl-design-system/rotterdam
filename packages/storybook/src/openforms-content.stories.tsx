import { Meta, StoryObj } from '@storybook/react';
import { SingleFormioComponent } from './StoryUtil';

const meta = {
  id: 'open-forms-content',
  args: {
    key: '',
    type: 'content',
  },
  component: SingleFormioComponent,
  title: 'Open Formulieren/Content',
} satisfies Meta<typeof SingleFormioComponent>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    extraComponentProperties: {
      html: `<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
    Quisque a felis ante. Nunc dictum, <b>dui et scelerisque euismod</b>, ex dui sodales magna,
    quis vehicula nulla justo sed urna. <i>Integer maximus tempus tellus</i> vel commodo.
    Orci varius natoque penatibus et magnis <a href="#">dis parturient montes.</a></p>`,
    },
    key: 'content',
  },
};
