/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Link, Paragraph } from '@utrecht/component-library-react/dist/css-module';
import readme from './link.md?raw';

const meta = {
  title: 'CSS Component/Link',
  id: 'css-utrecht-link',
  component: Link,
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
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=415-12136',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
} satisfies Meta<typeof Link>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Link',
  args: {
    children: 'Een geveltuin aanleggen',
    href: '#',
  },
};
export const LinkInParagraph: Story = {
  name: 'Link in body text',
  args: {
    children: 'Een geveltuin is een strook planten tegen de gevel van een woning.',
    href: '#',
  },
  decorators: [
    (Story) => (
      <Paragraph>
        Een geveltuin aanleggen is leuk om te doen, de straat knapt ervan op en uw huis blijft in de zomer koeler. Meer
        groen maakt de stad ook beter bestand tegen klimaatveranderingen en wateroverlast en is goed voor insecten en
        vogels. {Story()} Ze zijn vooral geschikt in straten waar de huizen geen voortuin hebben. Eén enkele klimplant,
        stokroos of zonnebloem maakt het straatbeeld al gezelliger, maar andere planten kunnen natuurlijk ook. U kiest
        zelf.
      </Paragraph>
    ),
  ],
};

export const LinkInLeadParagraph: Story = {
  name: 'Link in lead paragraph',
  args: {
    children: 'Een geveltuin aanleggen',
    href: '#',
  },
  decorators: [(Story) => <Paragraph lead>{Story()}</Paragraph>],
};

export const LinkInSmallPrint: Story = {
  name: 'Link in small print',
  args: {
    children: 'Een geveltuin aanleggen',
    href: '#',
  },
  decorators: [(Story) => <Paragraph small>{Story()}</Paragraph>],
};
