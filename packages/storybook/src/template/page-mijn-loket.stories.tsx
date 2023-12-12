/* @license CC0-1.0 */

import { ActionSingle } from '@gemeente-denhaag/action';
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
        <div className={'rods-grid__full-width'}>
          <p>Full width segment.</p>
        </div>
        <div className={'rods-grid__one-fourth'}>
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
        <div className={'rods-grid__two-third'}>
          <section>
            <h1>Hallo mevrouw van Bergenhenegouwen</h1>
            <p>
              Via Mijn Loket kunt u veel zelf regelen met de gemeente. Bijvoorbeeld een afspraak maken om uw paspoort te
              verlengen, of een subsidie aanvraag indienen. U kunt ook zien welke dingen u nog moet regelen of die wij
              van u vragen. Bijvoorbeeld het betalen van gemeentelijke belastingen. Zie hiervoor ‘Wat ik moet regelen’.
            </p>
          </section>
          <section>
            <h2>Wat moet ik regelen</h2>
            <div>
              <ActionSingle
                dateTime="2023-09-30T19:47:36.593Z"
                labels={{
                  approachingDeadline: () => 'nog 2 dagen',
                  before: 'vóór',
                  today: 'vandaag',
                  yesterday: 'gisteren',
                }}
                link="#"
                now="2023-09-28T19:47:36.593Z"
                relativeDate
              >
                <strong>Betaal uw parkeerbon van €68,90</strong>
              </ActionSingle>
              <ActionSingle
                dateTime="2023-05-31T19:47:36.593Z"
                labels={{
                  approachingDeadline: () => 'nog 2 dagen',
                  before: 'vóór',
                  today: 'vandaag',
                  yesterday: 'gisteren',
                }}
                link="#"
                now="2023-03-00T19:47:36.593Z"
                relativeDate
              >
                <strong>Betaal uw gemeentelijke belastingen</strong>
              </ActionSingle>
              <ActionSingle
                dateTime="2023-05-31T19:47:36.593Z"
                labels={{
                  approachingDeadline: () => 'nog 2 dagen',
                  before: 'vóór',
                  today: 'vandaag',
                  yesterday: 'gisteren',
                }}
                link="#"
                now="2023-03-00T19:47:36.593Z"
                relativeDate
              >
                <strong>Uw parkeervergunning loopt af</strong>
              </ActionSingle>
            </div>
          </section>
          <section>
            <h2>Zelf regelen</h2>
          </section>
        </div>
      </div>
    </div>
  ),
};
