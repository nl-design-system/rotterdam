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

  it('renders a button to choose a date', async () => {
    expect(page.getByRole('button', { name: 'Kies een datum' })).toBeInTheDocument();
  });

  // Apparently the accessible name calculation is incomplete in Playwright, it doesn't include all IDREFs of `aria-labelledby`
  it.skip('renders a button to choose a date, and the visible label is part of the accessible name too', async () => {
    expect(page.getByRole('button', { name: 'woensdag 1 januari 2025' })).toBeInTheDocument();
  });

  it('renders a button to choose a time', async () => {
    expect(page.getByRole('button', { name: 'Kies een tijdslot' })).toBeInTheDocument();
  });

  it('renders a button to confirm a date', async () => {
    expect(page.getByRole('button', { name: 'Bevestig uw afspraak' })).toBeInTheDocument();
  });

  describe('date picker button', () => {
    it('opens a dialog when clicked', async () => {
      const dateButton = page.getByRole('button', { name: 'Kies een datum' });
      expect(dateButton).toBeInTheDocument();
      const dialog1 = page.getByRole('dialog');

      expect(dialog1).not.toBeInTheDocument();

      await dateButton.click();

      const dialog = page.getByRole('dialog', { name: 'Kies een datum' });
      expect(dialog).toBeInTheDocument();
    });

    it('the dialog contains a listbox with date options', async () => {
      const dateButton = page.getByRole('button', { name: 'Kies een datum' });
      expect(dateButton).toBeInTheDocument();
      await dateButton.click();

      const dialog = page.getByRole('dialog', { name: 'Kies een datum' });
      expect(dialog).toBeInTheDocument();

      const listbox = await dialog.getByRole('listbox', { name: 'Selecteer een maand' });
      expect(listbox).toBeInTheDocument();

      const option = await dialog.getByRole('option', { name: 'januari 2025' });
      expect(option).toBeInTheDocument();
    });

    describe('date options', () => {
      it('can be clicked to select the option', async () => {
        const dateButton = page.getByRole('button', { name: 'Kies een datum' });
        expect(dateButton).toBeInTheDocument();
        await dateButton.click();

        const dialog = page.getByRole('dialog', { name: 'Kies een datum' });
        expect(dialog).toBeInTheDocument();

        const listbox = await dialog.getByRole('listbox', { name: 'Selecteer een maand' });
        expect(listbox).toBeInTheDocument();

        const option = await dialog.getByRole('option', { name: 'januari 2025' });
        expect(option).toBeInTheDocument();

        expect(option).toHaveAttribute('aria-selected', 'false');

        await option.click();

        expect(option).toHaveAttribute('aria-selected', 'true');
      });

      it('after selecting a date, I can confirm the date', async () => {
        const dateButton = page.getByRole('button', { name: 'Kies een datum' });
        expect(dateButton).toBeInTheDocument();
        await dateButton.click();

        const dialog = page.getByRole('dialog', { name: 'Kies een datum' });
        expect(dialog).toBeInTheDocument();

        const listbox = await dialog.getByRole('listbox', { name: 'Selecteer een maand' });
        expect(listbox).toBeInTheDocument();

        const option = await listbox.getByRole('option', { name: 'januari 2025' });
        expect(option).toBeInTheDocument();

        await option.click();

        const button = await dialog.getByRole('button', { name: 'Bevestig maand' });
        expect(button).toBeInTheDocument();

        await button.click();

        const listboxDay = await dialog.getByRole('listbox', { name: 'Selecteer een dag' });
        expect(listboxDay).toBeInTheDocument();

        // TODO
        // const optionDay = await listboxDay.getByRole('option', { name: 'januari 2025' });
        // expect(option).toBeInTheDocument();

        const confirmDayButton = await dialog.getByRole('button', { name: 'Bevestig dag' });
        expect(confirmDayButton).toBeInTheDocument();

        await confirmDayButton.click();
      });
    });
  });
});
