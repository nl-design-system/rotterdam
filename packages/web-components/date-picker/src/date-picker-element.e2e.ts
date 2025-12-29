import { beforeEach, describe, expect, it } from 'vitest';
import { page } from 'vitest/browser';
import './date-picker-element';

describe(`<rods-date-picker>`, () => {
  beforeEach(() => {
    document.body.innerHTML = `<rods-date-picker data-testid="custom-element"></rods-date-picker>`;
  });

  it('renders a custom element', async () => {
    expect(page.getByTestId('custom-element')).toBeInTheDocument();
  });

  it('renders a button to view previous month', async () => {
    expect(page.getByRole('button', { name: 'Vorige maand' })).toBeInTheDocument();
  });

  it('renders a button to view next month', async () => {
    expect(page.getByRole('button', { name: 'Volgende maand' })).toBeInTheDocument();
  });
});

describe(`<rods-date-picker value="1970-01-01>`, () => {
  beforeEach(() => {
    document.body.innerHTML = `<rods-date-picker data-testid="custom-element" value="1970-01-01"></rods-date-picker>`;
  });

  // it('renders a button for each day of the month', async () => {
  // Every month has day 1 - 28, so this tests should work any day of the month
  Array(28)
    .fill(0)
    .map((_, i) => i + 1)
    .map(async (dayOfMonth) => {
      it(`renders a button for each day of the month: ${dayOfMonth}`, async () => {
        expect(page.getByRole('button', { name: String(dayOfMonth), exact: true })).toBeInTheDocument();
      });
    });
  // });

  it('displays the currently visible month', () => {
    expect(page.getByText('december 2025', { exact: true })).toBeInTheDocument();
  });

  describe('previous month button', () => {
    it('renders a button to view previous month', async () => {
      expect(page.getByRole('button', { name: 'Vorige maand' })).toBeInTheDocument();
    });

    it('can be clicked to show day options for previous month', async () => {
      const button = page.getByRole('button', { name: 'Vorige maand', exact: true });
      expect(button).toBeInTheDocument();
      expect(page.getByText('december 2025', { exact: true })).toBeInTheDocument();

      await button.click();

      const monthText = page.getByText('november 2025', { exact: true });

      expect(monthText).toBeInTheDocument();
    });
  });

  describe('next month button', () => {
    it('renders a button to view next month', async () => {
      expect(page.getByRole('button', { name: 'Volgende maand' })).toBeInTheDocument();
    });
    it('can be clicked to show day options for next month', async () => {
      const button = page.getByRole('button', { name: 'Volgende maand', exact: true });
      expect(button).toBeInTheDocument();
      expect(page.getByText('december 2025', { exact: true })).toBeInTheDocument();

      await button.click();

      const monthText = page.getByText('januari 2025', { exact: true });

      expect(monthText).toBeInTheDocument();
    });
    it('can be clicked 12 times to go to the next year', async () => {
      const button = page.getByRole('button', { name: 'Volgende maand', exact: true });
      expect(button).toBeInTheDocument();
      expect(page.getByText('december 2025', { exact: true })).toBeInTheDocument();

      const initialMonthText = page.getByRole('grid', { name: 'december 2025', exact: true });

      expect(initialMonthText).toBeInTheDocument();

      for (let i = 12; i > 1; i--) {
        await button.click();
      }

      const monthText = page.getByRole('grid', { name: 'december 2026', exact: true });

      expect(monthText).toBeInTheDocument();
    });
  });

  describe('day of month month button', async () => {
    beforeEach(() => {
      document.body.innerHTML = `<rods-date-picker data-testid="custom-element" times='[{ "date": "2025-12-31T09:00", "label": "ochtend" }]'"></rods-date-picker>`;
    });
    it.only('can be activated to show timeslots for that day', async () => {
      const button = page.getByRole('button', { name: '31', exact: true });
      expect(button).toBeInTheDocument();
      expect(button).not.toBeDisabled();

      await button.click();

      const text = page.getByText('Beschikbare tijdsloten: woensdag 31 december 2025');
      expect(text).toBeInTheDocument();

      const listbox = page.getByRole('listbox', { name: 'Selecteer een tijdslot voor' });
      expect(listbox).toBeInTheDocument();

      const option = page.getByRole('option', { name: 'ochtend' });
      expect(option).toBeInTheDocument();
      expect(option).toHaveAttribute('aria-selected', 'false');

      await option.click();

      expect(option).toHaveAttribute('aria-selected', 'true');
    });
  });
});
