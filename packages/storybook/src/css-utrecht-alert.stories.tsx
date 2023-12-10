/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Alert, Paragraph } from '@utrecht/component-library-react/dist/css-module';
import readme from './alert.md?raw';

const meta = {
  title: 'CSS Component/Alert',
  id: 'css-utrecht-alert',
  component: Alert,
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
  args: {
    children: '',
  },
  tags: ['autodocs'],
  parameters: {
    // design: {
    //   type: 'figma',
    //   url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=506-18997',
    // },
    docs: {
      description: {
        component: readme,
      },
    },
  },
} satisfies Meta<typeof Alert>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Info: Story = {
  name: 'Notification',
  args: {
    children: (
      <Paragraph>
        Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet
        kloppen, kunt u dit wijzigen in het BRP.
      </Paragraph>
    ),
    type: 'info',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=507-21455',
    },
  },
};

export const Error: Story = {
  name: 'Alert',
  args: {
    children: (
      <Paragraph>
        Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet
        kloppen, kunt u dit wijzigen in het BRP.
      </Paragraph>
    ),
    type: 'error',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=507-21457',
    },
  },
};

export const Warning: Story = {
  name: 'Warning',
  args: {
    children: (
      <Paragraph>
        Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet
        kloppen, kunt u dit wijzigen in het BRP.
      </Paragraph>
    ),
    type: 'warning',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=507-21465&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};

export const OK: Story = {
  name: 'OK',
  args: {
    children: (
      <Paragraph>
        Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet
        kloppen, kunt u dit wijzigen in het BRP.
      </Paragraph>
    ),
    type: 'ok',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=507-21473&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};
