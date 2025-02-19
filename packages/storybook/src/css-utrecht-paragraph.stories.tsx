/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Paragraph } from '@utrecht/component-library-react/dist/css-module';
import readme from './paragraph.md?raw';

const meta = {
  id: 'css-utrecht-paragraph',
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
  component: Paragraph,
  parameters: {
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Fparagraph',
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
  tags: ['autodocs'],
  title: 'CSS Component/Paragraph',
} satisfies Meta<typeof Paragraph>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Paragraph',
  args: {
    children:
      'Een geveltuin aanleggen is leuk om te doen, de straat knapt ervan op en uw huis blijft in de zomer koeler. Meer groen maakt de stad ook beter bestand tegen klimaatveranderingen en wateroverlast en is goed voor insecten en vogels. Een geveltuin is een strook planten tegen de gevel van een woning. Ze zijn vooral geschikt in straten waar de huizen geen voortuin hebben. Eén enkele klimplant, stokroos of zonnebloem maakt het straatbeeld al gezelliger, maar andere planten kunnen natuurlijk ook. U kiest zelf.',
  },
};
export const LeadParagraph: Story = {
  name: 'Lead paragraph',
  args: {
    ...Default.args,
    lead: true,
  },
};

export const SmallPrintParagraph: Story = {
  name: 'Small print',
  args: {
    ...Default.args,
    small: true,
  },
};
