/* @license CC0-1.0 */

import { RodsIconChevronRight } from '@gemeente-rotterdam/web-components-react';
import type { Meta, StoryObj } from '@storybook/react';
import {
  BreadcrumbNav,
  BreadcrumbNavLink,
  BreadcrumbNavSeparator,
} from '@utrecht/component-library-react/dist/css-module';
import readme from './breadcrumb-nav.md?raw';

const meta = {
  title: 'CSS Component/Breadcrumb navigation',
  id: 'css-utrecht-breadcrumb-nav',
  component: BreadcrumbNav,
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
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Fbreadcrumb-nav',
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
} satisfies Meta<typeof BreadcrumbNav>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Breadcrumb navigation',
  args: {
    children: [
      <BreadcrumbNavLink href="/" rel="home" index={0}>
        Home
      </BreadcrumbNavLink>,
      <BreadcrumbNavSeparator>
        <RodsIconChevronRight />
      </BreadcrumbNavSeparator>,
      <BreadcrumbNavLink href="/a/" index={1}>
        Parkeren in Rotterdam
      </BreadcrumbNavLink>,
      <BreadcrumbNavSeparator>
        <RodsIconChevronRight />
      </BreadcrumbNavSeparator>,
      <BreadcrumbNavLink href="/a/b/" rel="up" index={2} disabled current>
        Product aanvragen
      </BreadcrumbNavLink>,
    ],
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=507-20062&mode=design&t=yvzUSkFQYQmWSHsQ-4',
    },
  },
};
