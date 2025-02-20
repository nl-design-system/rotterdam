/* @license CC0-1.0 */

import { ActionSingle } from '@gemeente-denhaag/action';
import { Sidenav, SidenavItem, SidenavLink, SidenavList } from '@gemeente-denhaag/sidenav';
import RodsIconArrowLeft from '@gemeente-rotterdam/web-components-react/dist/RodsIconArrowLeft';
import RodsIconArrowRight from '@gemeente-rotterdam/web-components-react/dist/RodsIconArrowRight';
import RodsIconBox from '@gemeente-rotterdam/web-components-react/dist/RodsIconBox';
import RodsIconChevronRight from '@gemeente-rotterdam/web-components-react/dist/RodsIconChevronRight';
import RodsIconCoins from '@gemeente-rotterdam/web-components-react/dist/RodsIconCoins';
import RodsIconDocument from '@gemeente-rotterdam/web-components-react/dist/RodsIconDocument';
import RodsIconEnvelope from '@gemeente-rotterdam/web-components-react/dist/RodsIconEnvelope';
import RodsIconGlobe from '@gemeente-rotterdam/web-components-react/dist/RodsIconGlobe';
import RodsIconInbox from '@gemeente-rotterdam/web-components-react/dist/RodsIconInbox';
import RodsIconLogOut from '@gemeente-rotterdam/web-components-react/dist/RodsIconLogOut';
import RodsIconMijnLoket from '@gemeente-rotterdam/web-components-react/dist/RodsIconMijnLoket';
import RodsIconMoney2 from '@gemeente-rotterdam/web-components-react/dist/RodsIconMoney2';
import RodsIconOverview from '@gemeente-rotterdam/web-components-react/dist/RodsIconOverview';
import RodsIconParking from '@gemeente-rotterdam/web-components-react/dist/RodsIconParking';
import RodsIconSearch from '@gemeente-rotterdam/web-components-react/dist/RodsIconSearch';
import RodsIconShoppingCart from '@gemeente-rotterdam/web-components-react/dist/RodsIconShoppingCart';
import RodsIconSummary from '@gemeente-rotterdam/web-components-react/dist/RodsIconSummary';
import RodsIconUser from '@gemeente-rotterdam/web-components-react/dist/RodsIconUser';
import RodsLogoImage from '@gemeente-rotterdam/web-components-react/dist/RodsLogoImage';
import { Meta, StoryObj } from '@storybook/react';
import '@gemeente-rotterdam/components-css/grid/index.scss';
import './index.scss';
import {
  BadgeCounter,
  BreadcrumbNav,
  BreadcrumbNavLink,
  BreadcrumbNavSeparator,
  Heading1,
  Heading2,
  Link,
  LinkList,
  NavBar,
  NavList,
  NavListLink,
  PageHeader,
  Paragraph,
  PreserveData,
} from '@utrecht/component-library-react/dist/css-module';

const meta = {
  id: 'template-mijn-loket',
  decorators: [(Story) => <div style={{ minInlineSize: '1280px' }}>{Story()}</div>],
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/hQPGq7PNYv3RvBdzSeqKf2/?node-id=810-3078',
    },
    layout: 'fullscreen',
  },
  title: 'Template/Mijn Loket',
} satisfies Meta;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  render: (args) => (
    <div {...args} className="example-page" style={{ containerType: 'inline-size' }}>
      <PageHeader>
        <div className="example-page-header__top-bar">
          <Link href="#" className="utrecht-link--backlink utrecht-link--with-icon">
            <RodsIconArrowLeft />
            Rotterdam.nl
          </Link>
          <NavBar>
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
          </NavBar>
        </div>
        <div className="example-page-header__content">
          <Link boxContent href="#" aria-label="homepage">
            <RodsLogoImage className="example-page-header__logo" aria-label="logo gemeente Rotterdam" role="img" />
          </Link>
          <div className="utrecht-nav-bar utrecht-nav-bar--button-menu">
            <NavList>
              <NavListLink href="#">
                <RodsIconSearch />
                Zoeken
              </NavListLink>
              <NavListLink href="#" aria-current="page">
                <RodsIconMijnLoket />
                Mijn Loket
              </NavListLink>
            </NavList>
          </div>
        </div>
      </PageHeader>
      <div className="rods-grid">
        <div className="rods-grid__one-fourth"></div>
        <div className="rods-grid__two-third">
          <BreadcrumbNav label="Kruimelpad">
            <BreadcrumbNavLink href="/" rel="home" index={0}>
              Home
            </BreadcrumbNavLink>
            <BreadcrumbNavSeparator>
              <RodsIconChevronRight />
            </BreadcrumbNavSeparator>
            <BreadcrumbNavLink href="/a/" index={1}>
              Parkeren in Rotterdam
            </BreadcrumbNavLink>
            <BreadcrumbNavSeparator>
              <RodsIconChevronRight />
            </BreadcrumbNavSeparator>
            <BreadcrumbNavLink href="/a/b/" rel="up" index={2} disabled current>
              Product aanvragen
            </BreadcrumbNavLink>
          </BreadcrumbNav>
        </div>
        <div className={'rods-grid__one-fourth rods-grid--margin-block-start'}>
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
                  <BadgeCounter className="utrecht-badge-counter--rods-light-blue">2</BadgeCounter>
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
        <div className={'rods-grid__two-third rods-grid--margin-block-start'}>
          <section className="example-section">
            <Heading1>
              Hallo mevrouw <PreserveData>Van Bergenhenegouwen</PreserveData>
            </Heading1>
            <Paragraph>
              Via Mijn Loket kunt u veel zelf regelen met de gemeente. Bijvoorbeeld een afspraak maken om uw paspoort te
              verlengen, of een subsidie aanvraag indienen. U kunt ook zien welke dingen u nog moet regelen of die wij
              van u vragen. Bijvoorbeeld het betalen van gemeentelijke belastingen. Zie hiervoor ‘Wat ik moet regelen’.
            </Paragraph>
          </section>
          <section className="example-section">
            <Heading2>Wat moet ik regelen</Heading2>
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
                locale="nl-NL"
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
                locale="nl-NL"
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
                locale="nl-NL"
                now="2023-03-00T19:47:36.593Z"
                relativeDate
              >
                <strong>Uw parkeervergunning loopt af</strong>
              </ActionSingle>
            </div>
          </section>
          <section className="example-section">
            <Heading2>Zelf regelen</Heading2>
            <div className="example-card-group">
              <div className="example-card">
                <div className="example-card__icon">
                  <RodsIconDocument />
                </div>
                <Paragraph className="example-card__title">Pasport vernieuwen of aanvragen</Paragraph>
                <LinkList
                  icon={() => <RodsIconArrowRight />}
                  links={[
                    { children: 'Direct regelen', href: '#' },
                    { children: 'Meer informatie op Rotterdam.nl', href: '#' },
                  ]}
                />
              </div>
              <div className="example-card">
                <div className="example-card__icon">
                  <RodsIconParking />
                </div>
                <Paragraph className="example-card__title">Parkeervergunning aanvragen of beheren</Paragraph>
                <LinkList
                  icon={() => <RodsIconArrowRight />}
                  links={[
                    { children: 'Direct regelen', href: '#' },
                    { children: 'Meer informatie op Rotterdam.nl', href: '#' },
                  ]}
                />
              </div>
              <div className="example-card">
                <div className="example-card__icon">
                  <RodsIconEnvelope />
                </div>
                <Paragraph className="example-card__title">Belastingzaken</Paragraph>
                <LinkList
                  icon={() => <RodsIconArrowRight />}
                  links={[
                    { children: 'Direct regelen', href: '#' },
                    { children: 'Meer informatie op Rotterdam.nl', href: '#' },
                  ]}
                />
              </div>
              <div className="example-card">
                <div className="example-card__icon">
                  <RodsIconEnvelope />
                </div>
                <Paragraph className="example-card__title">Belastingzaken</Paragraph>
                <LinkList
                  icon={() => <RodsIconArrowRight />}
                  links={[
                    { children: 'Direct regelen', href: '#' },
                    { children: 'Meer informatie op Rotterdam.nl', href: '#' },
                  ]}
                />
              </div>
            </div>
          </section>
        </div>
        <footer className="example-footer rods-grid__full-width">
          <div className="example-footer__nav-bar">
            <NavBar>
              <NavList>
                <NavListLink href="#">© Gemeente Rotterdam 2023</NavListLink>
                <NavListLink href="#">Vacatures</NavListLink>
                <NavListLink href="#">Corona</NavListLink>
                <NavListLink href="#">Cookies</NavListLink>
                <NavListLink href="#">Proclaimer</NavListLink>
                <NavListLink href="#">Privacy</NavListLink>
                <NavListLink href="#">Toegankelijkheid</NavListLink>
              </NavList>
            </NavBar>
          </div>
          <div>
            <RodsLogoImage />
          </div>
        </footer>
      </div>
    </div>
  ),
};
