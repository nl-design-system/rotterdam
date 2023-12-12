/* @license CC0-1.0 */

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
import { Meta, StoryObj } from '@storybook/react';
import '@gemeente-rotterdam/components-css/grid/index.scss';
import { BadgeCounter } from '@utrecht/component-library-react/dist/css-module';

const meta = {
  title: 'Template/Mijn Loket',
  id: 'template-mijn-loket',
} satisfies Meta;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  render: (args) => (
    <div {...args} style={{ containerType: 'inline-size' }}>
      <div className={'rods-grid'}>
        <div className={'rods-grid__full-width'} style={{ backgroundColor: 'cadetblue' }}>
          <p>Full width segment.</p>
        </div>
        <div className={'rods-grid__one-fourth'} style={{ backgroundColor: 'lightsalmon' }}>
          <Sidenav>
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
          </Sidenav>
        </div>
        <div className={'rods-grid__two-third'} style={{ backgroundColor: 'olive' }}>
          <h1>Hallo mevrouw van Bergenhenegouwen</h1>
          <p>
            Via Mijn Loket kunt u veel zelf regelen met de gemeente. Bijvoorbeeld een afspraak maken om uw paspoort te
            verlengen, of een subsidie aanvraag indienen. U kunt ook zien welke dingen u nog moet regelen of die wij van
            u vragen. Bijvoorbeeld het betalen van gemeentelijke belastingen. Zie hiervoor ‘Wat ik moet regelen’.
          </p>
        </div>
      </div>
    </div>
  ),
};
