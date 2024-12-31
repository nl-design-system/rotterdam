/* @license CC0-1.0 */

import type { Decorator, Meta, StoryObj } from '@storybook/react';
import { Link, Paragraph } from '@utrecht/component-library-react/dist/css-module';
import readme from './link.md?raw';

const ParagraphContentDecorator: Decorator = (Story) => (
  <Paragraph>
    Een geveltuin aanleggen is leuk om te doen, de straat knapt ervan op en uw huis blijft in de zomer koeler. Meer
    groen maakt de stad ook beter bestand tegen klimaatveranderingen en wateroverlast en is goed voor insecten en
    vogels. {Story()} Ze zijn vooral geschikt in straten waar de huizen geen voortuin hebben. Eén enkele klimplant,
    stokroos of zonnebloem maakt het straatbeeld al gezelliger, maar andere planten kunnen natuurlijk ook. U kiest zelf.
  </Paragraph>
);

const LeadParagraphDecorator: Decorator = (Story) => <Paragraph appearance="lead">{Story()}</Paragraph>;

const SmallParagraphDecorator: Decorator = (Story) => <Paragraph appearance="small">{Story()}</Paragraph>;

const meta = {
  id: 'css-utrecht-link',
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
  component: Link,
  parameters: {
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Flink',
    design: {
      type: 'figma',
      url: 'https://www.figma.com/design/RiVsTfcbmnKSU2BGqQBI9n/RODS-fundament?node-id=1-2931&t=y0jresab3mn2Swvw-4',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
  tags: ['autodocs'],
  title: 'CSS Component/Link',
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
  decorators: [ParagraphContentDecorator],
};

export const LinkInLeadParagraph: Story = {
  name: 'Link in lead paragraph',
  args: {
    children: 'Een geveltuin aanleggen',
    href: '#',
  },
  decorators: [LeadParagraphDecorator],
};

export const LinkInSmallPrint: Story = {
  name: 'Link in small print',
  args: {
    children: 'Een geveltuin aanleggen',
    href: '#',
  },
  decorators: [SmallParagraphDecorator],
};
