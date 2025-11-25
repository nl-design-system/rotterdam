/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { RodsIconChevronRight } from '@gemeente-rotterdam/web-components-react';
import {
  BreadcrumbNav,
  BreadcrumbNavLink,
  BreadcrumbNavSeparator,
} from '@utrecht/component-library-react/dist/css-module';
import readme from './breadcrumb-nav.md?raw';

const meta = {
  id: 'css-utrecht-breadcrumb-nav',
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
  component: BreadcrumbNav,
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
  tags: ['autodocs'],
  title: 'CSS Component/Breadcrumb navigation',
} satisfies Meta<typeof BreadcrumbNav>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Breadcrumb navigation',
  args: {
    children: (
      <>
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
      </>
    ),
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/design/iWuQsxelJzXVfCge87Og81/RODS-component?node-id=1-7188&t=5SS9SJ1KhfLkhqSu-4',
    },
  },
};
