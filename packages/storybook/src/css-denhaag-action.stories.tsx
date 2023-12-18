/* @license CC0-1.0 */

import { ActionSingle } from '@gemeente-denhaag/action';
import type { Meta, StoryObj } from '@storybook/react';
import readme from './action.md?raw';

const meta = {
  title: 'CSS Component/Action',
  id: 'css-denhaag-Action',
  component: ActionSingle,
  argTypes: {
    defaultValue: {
      name: 'Content',
      type: {
        name: 'string',
        required: true,
      },
      defaultValue: '',
    },
  },
  args: {
    defaultValue: '',
  },
  tags: ['autodocs'],
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/hQPGq7PNYv3RvBdzSeqKf2/Mijn-Loket-2.0?node-id=810%3A3078',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
} satisfies Meta<typeof ActionSingle>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Action',
  args: {
    children: <strong>Taak</strong>,
  },
};
