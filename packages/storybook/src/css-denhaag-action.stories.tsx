/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { ActionSingle } from '@gemeente-denhaag/action';
import readme from './action.md?raw';

const meta = {
  id: 'css-denhaag-action',
  args: {
    defaultValue: '',
  },
  argTypes: {
    defaultValue: {
      name: 'Content',
      defaultValue: '',
      type: {
        name: 'string',
        required: true,
      },
    },
  },
  component: ActionSingle,
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
  tags: ['autodocs'],
  title: 'CSS Component/Action',
} satisfies Meta<typeof ActionSingle>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Single action',
  args: {
    children: <strong>Betaal uw parkeerbon van €68,90</strong>,
    dateTime: '2023-09-30T19:47:36.593Z',
    labels: {
      approachingDeadline: () => 'nog 2 dagen',
      before: 'vóór',
      today: 'vandaag',
      yesterday: 'gisteren',
    },
    link: '#',
    now: '2023-09-28T19:47:36.593Z',
    relativeDate: true,
  },
};
