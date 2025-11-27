/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react-vite';
import RodsIconBadgeAlert from '@gemeente-rotterdam/web-components-react/dist/RodsIconBadgeAlert';
import RodsIconBadgeAlertSolid from '@gemeente-rotterdam/web-components-react/dist/RodsIconBadgeAlertSolid';
import RodsIconBadgeCheck from '@gemeente-rotterdam/web-components-react/dist/RodsIconBadgeCheck';
import RodsIconBadgeInfo from '@gemeente-rotterdam/web-components-react/dist/RodsIconBadgeInfo';
import { Alert, Paragraph } from '@utrecht/component-library-react/dist/css-module';
import readme from './alert.md?raw';

const meta = {
  id: 'css-utrecht-alert',
  args: {
    children: '',
  },
  argTypes: {
    children: {
      name: 'Content',
      defaultValue: '',
      type: {
        name: 'string',
        required: true,
      },
    },
  },
  component: Alert,
  parameters: {
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Falert',
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=506-18997',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
  tags: ['autodocs'],
  title: 'CSS Component/Alert',
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
    icon: <RodsIconBadgeInfo />,
    type: 'info',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/design/iWuQsxelJzXVfCge87Og81/RODS-component?node-id=22-8275&t=5SS9SJ1KhfLkhqSu-4',
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
    icon: <RodsIconBadgeAlertSolid />,
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
    icon: <RodsIconBadgeAlert />,
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
    icon: <RodsIconBadgeCheck />,
    type: 'ok',
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=507-21473&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};
