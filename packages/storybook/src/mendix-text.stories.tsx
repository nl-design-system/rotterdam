/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Button } from '@utrecht/component-library-react/dist/css-module';
import '@gemeente-rotterdam/mendix-css/dist/mendix-nl-design-system-rotterdam-theme.css';

const meta = {
  id: 'mendix-text',
  args: {
    children: '',
  },
  argTypes: {
    children: {
      name: 'Content',
      defaultValue: '',
      description: 'Button text',
      type: {
        name: 'string',
        required: true,
      },
    },
  },
  component: Button,
  parameters: {},
  tags: ['autodocs'],
  title: 'Mendix Component/Text',
} satisfies Meta<typeof Button>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Heading1: Story = {
  name: 'Heading 1',
  args: {
    children: 'Label',
  },
  render: () => <h1 className="mx-text mx-name-text3">Heading 1</h1>,
};

export const Heading2: Story = {
  name: 'Heading 2',
  args: {
    children: 'Label',
  },
  render: () => <h2 className="mx-text mx-name-text4">Heading 2</h2>,
};

export const Heading3: Story = {
  name: 'Heading 3',
  args: {
    children: 'Label',
  },
  render: () => <h3 className="mx-text mx-name-text5">Heading 3</h3>,
};

export const Heading4: Story = {
  name: 'Heading 4',
  args: {
    children: 'Label',
  },
  render: () => <h4 className="mx-text mx-name-text6">Heading 4</h4>,
};

export const Heading5: Story = {
  name: 'Heading 5',
  args: {
    children: 'Label',
  },
  render: () => <h5 className="mx-text mx-name-text7">Heading 5 </h5>,
};

export const Heading6: Story = {
  name: 'Heading 6',
  args: {
    children: 'Label',
  },
  render: () => <h6 className="mx-text mx-name-text8">Heading 6</h6>,
};

export const Paragraph: Story = {
  name: 'Paragraph',
  args: {
    children: 'Label',
  },
  render: () => (
    <p className="mx-text mx-name-text9">
      Paragraph. Onbekenden hebben de voorzijde van het stadhuis beklad. De ingang aan de voorzijde is daarom afgezet,
      zodat de gevel kan worden schoongemaakt. De politie onderzoekt de zaak.
    </p>
  ),
};

export const Text: Story = {
  name: 'Text',
  args: {
    children: 'Label',
  },
  render: () => (
    <span className="mx-text mx-name-text10">
      Text. Onbekenden hebben de voorzijde van het stadhuis beklad. De ingang aan de voorzijde is daarom afgezet, zodat
      de gevel kan worden schoongemaakt. De politie onderzoekt de zaak.
    </span>
  ),
};
