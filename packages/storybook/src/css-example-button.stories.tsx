/* @license CC0-1.0 */

import readme from '@gemeente-rotterdam/components-css/button/README.md?raw';
import type { Meta, StoryObj } from '@storybook/react';
import { PropsWithChildren } from 'react';
import '@gemeente-rotterdam/components-css/button/index.scss';

const Button = ({ children }: PropsWithChildren<{}>) => (
  <button className="example-button" type="button">
    <span className="example-button__text">{children}</span>
  </button>
);

const meta = {
  title: 'CSS Component/Example button (do not use)',
  id: 'css-example-button',
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
    children: 'Opslaan en verder',
  },
  tags: ['autodocs'],
  parameters: {
    docs: {
      description: {
        component: readme,
      },
    },
  },
} satisfies Meta<typeof Button>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Example button',
};