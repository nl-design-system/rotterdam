/* @license CC0-1.0 */

import { ActionSingle } from '@gemeente-denhaag/action';
import { Sidenav, SidenavItem, SidenavLink, SidenavList } from '@gemeente-denhaag/sidenav';
import {
  RodsIconArrowLeft,
  RodsIconArrowRight,
  RodsIconBox,
  RodsIconCoins,
  RodsIconDocument,
  RodsIconEnvelope,
  RodsIconGlobe,
  RodsIconInbox,
  RodsIconLogOut,
  RodsIconMoney2,
  RodsIconOverview,
  RodsIconParking,
  RodsIconShoppingCart,
  RodsIconSummary,
  RodsIconUser,
  RodsLogoImage,
} from '@gemeente-rotterdam/web-components-react';
import { Meta, StoryObj } from '@storybook/react';
import '@gemeente-rotterdam/components-css/grid/index.scss';
import './index.scss';
import {
  BadgeCounter,
  BreadcrumbNav,
  BreadcrumbNavLink,
  BreadcrumbNavSeparator,
  Link,
  NavList,
  NavListLink,
  PageHeader,
} from '@utrecht/component-library-react/dist/css-module';

const meta = {
  title: 'Template/Mijn Loket',
  id: 'template-mijn-loket',
  parameters: {
    layout: 'fullscreen',
    viewport: {
      viewports: {
        desktop: {
          name: 'Desktop',
          styles: {
            width: '1280px',
            height: '1528px',
          },
        },
      },
      defaultViewport: 'desktop',
    },
  },
  decorators: [(Story) => <div style={{ minInlineSize: '1280px' }}>{Story()}</div>],
} satisfies Meta;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  render: (args) => (
    <div {...args} style={{ containerType: 'inline-size' }}>
      <PageHeader>
        <div className="example-page-header__top-bar">
          <Link href="#" className="utrecht-link--backlink utrecht-link--with-icon">
            <RodsIconArrowLeft />
            Rotterdam.nl
          </Link>
          <nav>
            <NavList>
              <NavListLink href="#">
                <RodsIconGlobe />
                Translate
              </NavListLink>
              <div className="utrecht-nav-list__link">|</div>
              <NavListLink href="#">
                <RodsIconUser />
                Unilever Nederland Holding B.V.
              </NavListLink>
              <NavListLink href="#">
                <RodsIconLogOut />
                Uitloggen
              </NavListLink>
              <NavListLink href="#">
                <RodsIconShoppingCart />
                Winkelmandje
              </NavListLink>
            </NavList>
          </nav>
        </div>
        <div className="example-page-header__content">
          <RodsLogoImage className="example-page-header__logo" />
          <div>Nav buttons here</div>
        </div>
      </PageHeader>
      <div className={'rods-grid'}>
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
          <BreadcrumbNav>
            <BreadcrumbNavLink href="/" rel="home" index={0}>
              Home
            </BreadcrumbNavLink>
            <BreadcrumbNavSeparator>›</BreadcrumbNavSeparator>
            <BreadcrumbNavLink href="/a/" index={1}>
              Parkeren in Rotterdam
            </BreadcrumbNavLink>
            <BreadcrumbNavSeparator>›</BreadcrumbNavSeparator>
            <BreadcrumbNavLink href="/a/b/" rel="up" index={2} disabled current>
              Product aanvragen
            </BreadcrumbNavLink>
          </BreadcrumbNav>
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
            <div className={'example-card-group'}>
              <div className={'example-card'}>
                <RodsIconDocument />
                <p className={'example-card-title'}>Passport vernieuwen of aanvragen</p>
                <div className={'example-link-list'}>
                  <a className={'example-link'} href={'#'}>
                    <RodsIconArrowRight />
                    Direct regelen
                  </a>
                  <a className={'example-link'} href={'#'}>
                    <RodsIconArrowRight />
                    Meer informatie op Rotterdam.nl
                  </a>
                </div>
              </div>
              <div className={'example-card'}>
                <RodsIconParking />
                <p className={'example-card-title'}>Parkeervergunning aanvragen of beheren</p>
                <div className={'example-link-list'}>
                  <a className={'example-link'} href={'#'}>
                    <RodsIconArrowRight />
                    Direct regelen
                  </a>
                  <a className={'example-link'} href={'#'}>
                    <RodsIconArrowRight />
                    Meer informatie op Rotterdam.nl
                  </a>
                </div>
              </div>

              <div className={'example-card'}>
                <RodsIconEnvelope />
                <p className={'example-card-title'}>Belastingzaken</p>
                <div className={'example-link-list'}>
                  <a className={'example-link'} href={'#'}>
                    <RodsIconArrowRight />
                    Direct regelen
                  </a>
                  <a className={'example-link'} href={'#'}>
                    <RodsIconArrowRight />
                    Meer informatie op Rotterdam.nl
                  </a>
                </div>
              </div>
              <div className={'example-card'}>
                <RodsIconEnvelope />
                <p className={'example-card-title'}>Belastingzaken</p>
                <div className={'example-link-list'}>
                  <a className={'example-link'} href={'#'}>
                    <RodsIconArrowRight />
                    Direct regelen
                  </a>
                  <a className={'example-link'} href={'#'}>
                    <RodsIconArrowRight />
                    Meer informatie op Rotterdam.nl
                  </a>
                </div>
              </div>
            </div>
          </section>
        </div>
        <footer className="example-footer rods-grid__full-width">
          <div className="example-footer__navbar">navbar links</div>
          <div>
            <RodsLogoImage />
          </div>
        </footer>
      </div>
    </div>
  ),
};
