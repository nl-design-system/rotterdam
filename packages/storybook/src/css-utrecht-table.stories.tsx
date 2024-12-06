/* @license CC0-1.0 */

import { RodsIconEdit } from '@gemeente-rotterdam/web-components-react';
import type { Meta, StoryObj } from '@storybook/react';
import {
  ButtonLink,
  IBANData,
  PreserveData,
  StatusBadge,
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableFooter,
  TableHeader,
  TableHeaderCell,
  TableRow,
} from '@utrecht/component-library-react';
import readme from './table.md?raw';
import '@gemeente-rotterdam/components-css/table/index.scss';

const meta = {
  title: 'CSS Component/Table',
  id: 'css-table',
  component: Table,
  argTypes: {},
  args: {},
  tags: ['autodocs'],
  parameters: {
    bugs: 'https://github.com/nl-design-system/rotterdam/labels/component%2Ftable',
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
          <TableHeaderCell className="rods-table__header-cell" scope="col">
            Column A
          </TableHeaderCell>
          <TableHeaderCell className="rods-table__header-cell" scope="col">
            Column B
          </TableHeaderCell>
          <TableHeaderCell className="rods-table__header-cell" scope="col">
            Column C
          </TableHeaderCell>
          <TableHeaderCell className="rods-table__header-cell" scope="col">
            Column d
          </TableHeaderCell>
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
      <TableFooter className="rods-table-footer">
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
      url: 'https://www.figma.com/design/iWuQsxelJzXVfCge87Og81/RODS-component?node-id=22-6351&t=5SS9SJ1KhfLkhqSu-4',
    },
  },
};

export const Hover: Story = {
  args: {
    className: 'utrecht-table--row-hover',
    children: [
      <TableHeader>
        <TableRow>
          <TableHeaderCell className="rods-table__header-cell" scope="col">
            Column A
          </TableHeaderCell>
          <TableHeaderCell className="rods-table__header-cell" scope="col">
            Column B
          </TableHeaderCell>
          <TableHeaderCell className="rods-table__header-cell" scope="col">
            Column C
          </TableHeaderCell>
          <TableHeaderCell className="rods-table__header-cell" scope="col">
            Column d
          </TableHeaderCell>
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
      <TableFooter className="rods-table-footer">
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

export const EditLink: Story = {
  args: {
    className: 'utrecht-table--row-hover',
    children: [
      <TableCaption>Lopende automatische incasso’s</TableCaption>,
      <TableHeader>
        <TableRow>
          <TableHeaderCell className="rods-table__header-cell" scope="col">
            Gebruikt voor
          </TableHeaderCell>
          <TableHeaderCell className="rods-table__header-cell" scope="col">
            IBAN rekeningnummer
          </TableHeaderCell>
          <TableHeaderCell className="rods-table__header-cell" scope="col">
            Machtigingskenmerk
          </TableHeaderCell>
          <TableHeaderCell className="rods-table__header-cell" scope="col">
            Actief sinds
          </TableHeaderCell>
          <TableHeaderCell className="rods-table__header-cell" scope="col"></TableHeaderCell>
        </TableRow>
      </TableHeader>,
      <TableBody>
        <TableRow>
          <TableCell>Gemeentelijke heffingen</TableCell>
          <TableCell>
            <IBANData value="NL95RABO0370654363" />
          </TableCell>
          <TableCell>
            <PreserveData>RDAM-122347-001-11</PreserveData>
          </TableCell>
          <TableCell>06-10-2023</TableCell>
          <TableCell>
            <ButtonLink appearance="subtle-button">
              <RodsIconEdit />
              Wijzigen
            </ButtonLink>
          </TableCell>
        </TableRow>
        <TableRow>
          <TableCell>Marktgelden</TableCell>
          <TableCell>
            <IBANData value="NL95RABO0370654363" />
          </TableCell>
          <TableCell>
            <PreserveData>RDAM-982347-234-102</PreserveData>
          </TableCell>
          <TableCell>06-10-2023</TableCell>
          <TableCell>
            <ButtonLink appearance="subtle-button">
              <RodsIconEdit />
              Wijzigen
            </ButtonLink>
          </TableCell>
        </TableRow>
      </TableBody>,
    ],
  },
  name: 'Rows with edit link',
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ByWn4DjjJ6y4Wl1FXugQ3H/Belastingportaal-RPA?type=design&node-id=1709-30506&mode=design&t=n0a2MlRfL9OdT1RA-4',
    },
  },
};

export const Badges: Story = {
  args: {
    children: [
      <TableCaption>Opbouw van het bedrag</TableCaption>,
      <TableHeader>
        <TableRow>
          <TableHeaderCell className="rods-table__header-cell" scope="col">
            Datum
          </TableHeaderCell>
          <TableHeaderCell className="rods-table__header-cell" scope="col">
            Omschrijving
          </TableHeaderCell>
          <TableHeaderCell numericColumn className="rods-table__header-cell" scope="col">
            Bedrag
          </TableHeaderCell>
          <TableHeaderCell className="rods-table__header-cell" scope="col"></TableHeaderCell>
        </TableRow>
      </TableHeader>,
      <TableBody>
        <TableRow>
          <TableCell>31 januari 2023</TableCell>
          <TableCell>Vordering</TableCell>
          <TableCell numericColumn>€ 1.200</TableCell>
          <TableCell></TableCell>
        </TableRow>
        <TableRow>
          <TableCell>25 maart 2023</TableCell>
          <TableCell>Ontvangst</TableCell>
          <TableCell numericColumn>-€ 100</TableCell>
          <TableCell>
            <StatusBadge status="ok" className="utrecht-status-badge--rods-green-blue">
              betaald
            </StatusBadge>
          </TableCell>
        </TableRow>
        <TableRow>
          <TableCell>25 april 2023</TableCell>
          <TableCell>Ontvangst</TableCell>
          <TableCell numericColumn>-€ 100</TableCell>
          <TableCell>
            <StatusBadge status="ok" className="utrecht-status-badge--rods-green-blue">
              betaald
            </StatusBadge>
          </TableCell>
        </TableRow>
      </TableBody>,
      <TableFooter>
        <TableRow>
          <TableHeaderCell scope="row" colSpan={2}>
            Dit moet u betalen:
          </TableHeaderCell>
          <TableCell numericColumn>€ 1.000</TableCell>
          <TableCell>
            <StatusBadge status="fixme" className="utrecht-status-badge--rods-light-blue">
              nog te betalen
            </StatusBadge>
          </TableCell>
        </TableRow>
      </TableFooter>,
    ],
  },
  name: 'Rows with badges',
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ByWn4DjjJ6y4Wl1FXugQ3H/Belastingportaal-RPA?type=design&node-id=2687-18454&mode=design&t=n0a2MlRfL9OdT1RA-4',
    },
  },
};
