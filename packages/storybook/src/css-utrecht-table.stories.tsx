/* @license CC0-1.0 */

import type { Meta, StoryObj } from '@storybook/react';
import {
  Table,
  TableBody,
  TableCell,
  TableFooter,
  TableHeader,
  TableHeaderCell,
  TableRow,
} from '@utrecht/component-library-react';
import readme from './table.md?raw';

const meta = {
  title: 'CSS Component/Table',
  id: 'css-table',
  component: Table,
  argTypes: {},
  args: {},
  tags: ['autodocs'],
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=507-19314',
    },
    docs: {
      description: {
        component: readme,
      },
    },
  },
} satisfies Meta<typeof Table>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    children: [
      <TableHeader>
        <TableRow>
          <TableHeaderCell scope="col">Column A</TableHeaderCell>
          <TableHeaderCell scope="col">Column B</TableHeaderCell>
          <TableHeaderCell scope="col">Column C</TableHeaderCell>
          <TableHeaderCell scope="col">Column d</TableHeaderCell>
        </TableRow>
      </TableHeader>,
      <TableBody>
        <TableRow>
          <TableCell>Data</TableCell>
          <TableCell>Data</TableCell>
          <TableCell>Data</TableCell>
          <TableCell>Data</TableCell>
        </TableRow>
      </TableBody>,
      <TableFooter>
        <TableRow>
          <TableCell>Footer data</TableCell>
          <TableCell>Footer data</TableCell>
          <TableCell>Footer data</TableCell>
          <TableCell>Footer data</TableCell>
        </TableRow>
      </TableFooter>,
    ],
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=507-19314',
    },
  },
};
