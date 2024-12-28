/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Sidenav, SidenavItem, SidenavLink, SidenavList } from '@gemeente-denhaag/sidenav';
import {
  RodsIconBox,
  RodsIconCoins,
  RodsIconInbox,
  RodsIconMoney2,
  RodsIconOverview,
  RodsIconParking,
  RodsIconSummary,
  RodsIconUser,
} from '@gemeente-rotterdam/web-components-react';
import { BadgeCounter } from '@utrecht/component-library-react/dist/css-module';
import readme from './sidenav.md?raw';

const meta = {
  id: 'css-denhaag-sidenav',
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
  component: Sidenav,
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
  tags: ['autodocs'],
  title: 'CSS Component/Side navigation',
} satisfies Meta<typeof Sidenav>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Side navigation',
  args: {
    children: (
      <>
        <SidenavList>
          <SidenavItem>
            <SidenavLink current href="/#">
              <RodsIconOverview /> Overzicht
            </SidenavLink>
          </SidenavItem>
          <SidenavItem>
            <SidenavLink href="/#">
              <RodsIconInbox />
              Mijn berichten
              <BadgeCounter>2</BadgeCounter>
            </SidenavLink>
          </SidenavItem>
          <SidenavItem>
            <SidenavLink href="/#">
              <RodsIconBox /> Mijn lopende zaken
            </SidenavLink>
          </SidenavItem>
          <SidenavItem>
            <SidenavLink href="/#">
              <RodsIconSummary /> Zelf regelen
            </SidenavLink>
          </SidenavItem>
        </SidenavList>
        <SidenavList>
          <SidenavItem>
            <SidenavLink href="/#">
              <RodsIconCoins /> Belastingen
            </SidenavLink>
          </SidenavItem>
          <SidenavItem>
            <SidenavLink href="/#">
              <RodsIconMoney2 /> Werk &amp; Inkomen
            </SidenavLink>
          </SidenavItem>
          <SidenavItem>
            <SidenavLink href="/#">
              <RodsIconParking /> Parkeren
            </SidenavLink>
          </SidenavItem>
        </SidenavList>
        <SidenavList>
          <SidenavItem>
            <SidenavLink href="/#">
              <RodsIconUser />
              Mijn gegevens
            </SidenavLink>
          </SidenavItem>
        </SidenavList>
      </>
    ),
  },
};
