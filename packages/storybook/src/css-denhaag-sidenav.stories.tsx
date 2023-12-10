/* @license CC0-1.0 */

import { Sidenav, SidenavItem, SidenavLink, SidenavList } from '@gemeente-denhaag/sidenav';
import type { Meta, StoryObj } from '@storybook/react';
import { BadgeCounter } from '@utrecht/component-library-react/dist/css-module';
import readme from './sidenav.md?raw';
import '@gemeente-rotterdam/components-css/button/index.scss';

const meta = {
  title: 'CSS Component/Side navigation',
  id: 'css-denhaag-sidenav',
  component: Sidenav,
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
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=501-18760',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
} satisfies Meta<typeof Sidenav>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Side navigation',
  args: {
    children: [
      <SidenavList>
        <SidenavItem>
          <SidenavLink current href="/#">
            Overzicht
          </SidenavLink>
        </SidenavItem>
        <SidenavItem>
          <SidenavLink href="/#">
            Mijn berichten
            <BadgeCounter>2</BadgeCounter>
          </SidenavLink>
        </SidenavItem>
        <SidenavItem>
          <SidenavLink href="/#">Mijn lopende zaken</SidenavLink>
        </SidenavItem>
        <SidenavItem>
          <SidenavLink href="/#">Zelf regelen</SidenavLink>
        </SidenavItem>
      </SidenavList>,
      <SidenavList>
        <SidenavItem>
          <SidenavLink href="/#">Belastingen</SidenavLink>
        </SidenavItem>
        <SidenavItem>
          <SidenavLink href="/#">Werk &amp; Inkomen</SidenavLink>
        </SidenavItem>
        <SidenavItem>
          <SidenavLink href="/#">Parkeren</SidenavLink>
        </SidenavItem>
      </SidenavList>,
      <SidenavList>
        <SidenavItem>
          <SidenavLink href="/#">Mijn gegevens</SidenavLink>
        </SidenavItem>
      </SidenavList>,
    ],
  },
};
