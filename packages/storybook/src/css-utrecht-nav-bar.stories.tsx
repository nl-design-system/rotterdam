/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react-vite';
import { NavBar, NavList, NavListLink } from '@utrecht/component-library-react/dist/css-module';
import readme from './badge-list.md?raw';

const meta = {
  id: 'css-utrecht-nav-bar',
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
  component: NavBar,
  parameters: {
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Fnav-bar',
    docs: {
      description: {
        component: readme,
      },
    },
  },
  tags: ['autodocs'],
  title: 'CSS Component/Nav bar',
} satisfies Meta<typeof NavBar>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Default',
  args: {
    children: (
      <NavList>
        <NavListLink href="#">Translate</NavListLink>
        <NavListLink href="#">Unilever Nederland Holding B.V.</NavListLink>
        <NavListLink href="#">Uitloggen</NavListLink>
        <NavListLink href="#">Winkelmandje</NavListLink>
      </NavList>
    ),
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=1730-7404',
    },
  },
};
