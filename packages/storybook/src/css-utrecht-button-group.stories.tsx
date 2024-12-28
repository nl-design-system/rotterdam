/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import { Button, ButtonGroup, LinkButton } from '@utrecht/component-library-react/dist/css-module';
import readme from './button-group.md?raw';

const meta = {
  id: 'css-utrecht-button-group',
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
  component: ButtonGroup,
  parameters: {
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Fbutton-group',
    design: {
      type: 'figma',
      url: 'https://www.figma.com/design/iWuQsxelJzXVfCge87Og81/RODS-component?node-id=1-56&t=EXoPmctpkctdqa4z-4',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
  tags: ['autodocs'],
  title: 'CSS Component/Button group',
} satisfies Meta<typeof ButtonGroup>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  name: 'Default',
  args: {
    children: (
      <>
        <Button appearance="primary-action-button">Primary</Button>
        <Button appearance="secondary-action-button">Label</Button>
        <Button>Label</Button>
        <LinkButton>Text button</LinkButton>
      </>
    ),
  },
};
