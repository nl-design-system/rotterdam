/* @license CC0-1.0 */

import { Meta, StoryObj } from '@storybook/react';
import '@gemeente-rotterdam/components-css/grid/index.scss';

const meta = {
  title: 'Template/Mijn Loket',
  id: 'template-mijn-loket',
} satisfies Meta;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  render: (args) => (
    <div {...args} style={{ containerType: 'inline-size' }}>
      <div className={'rods-grid'}>
        <div className={'rods-grid__full-width'} style={{ backgroundColor: 'cadetblue' }}>
          <h1>rods-grid</h1>
          <p>Full width segment.</p>
        </div>
        <div className={'rods-grid__one-third'} style={{ backgroundColor: 'lightsalmon' }}>
          <h2>One third</h2>
        </div>
        <div className={'rods-grid__two-third'} style={{ backgroundColor: 'olive' }}>
          <h2>Two third</h2>
        </div>
        <div className={'rods-grid__two-third'} style={{ backgroundColor: 'lightcoral' }}>
          <h2>Two third</h2>
        </div>
        <div className={'rods-grid__one-third'} style={{ backgroundColor: 'blanchedalmond' }}>
          <h2>One third</h2>
        </div>
        <div className={'rods-grid__half-width'} style={{ backgroundColor: 'cornflowerblue' }}>
          <h2>Half width</h2>
        </div>
        <div className={'rods-grid__half-width'} style={{ backgroundColor: 'olive' }}>
          <h2>Half width</h2>
        </div>
      </div>
    </div>
  ),
};
