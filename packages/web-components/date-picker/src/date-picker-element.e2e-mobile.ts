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

describe('<rods-date-picker> mobile date drawer (#599)', () => {
  const options = [
    { value: '2026-12-07T09:00' },
    { value: '2026-12-07T10:00' },
    { value: '2026-12-14T09:00' },
    { value: '2026-12-21T09:00' },
    { value: '2026-12-28T09:00' },
  ];

  beforeEach(() => {
    // "now" is in November, but the only available times are in December
    document.body.innerHTML = `<rods-date-picker lang="nl" now="2026-11-16T10:00" options='${JSON.stringify(options)}'></rods-date-picker>`;
  });

  const openDateDrawer = async () => {
    await page.getByRole('button', { name: 'Kies een datum' }).click();
    return page.getByRole('dialog', { name: 'Kies een datum' });
  };

  it('preselects the first month with available times', async () => {
    const dialog = await openDateDrawer();
    const month = dialog.getByRole('listbox', { name: 'Selecteer een maand' }).getByRole('option', {
      name: 'december 2026',
    });

    await expect.element(month).toHaveAttribute('aria-selected', 'true');
  });

  it('shows the days of the chosen month, with the chosen month in the heading', async () => {
    const dialog = await openDateDrawer();
    await dialog.getByRole('button', { name: 'Bevestig maand' }).click();

    await expect.element(dialog.getByRole('heading', { name: '2/2 Selecteer een dag in december' })).toBeVisible();

    const days = dialog.getByRole('listbox', { name: /Selecteer een dag/ }).getByRole('option');
    await expect.element(days.first()).toBeVisible();
    expect(days.elements().map((el) => el.textContent?.trim())).toEqual([
      'maandag 7',
      'maandag 14',
      'maandag 21',
      'maandag 28',
    ]);
  });

  it('marks only the chosen day as selected', async () => {
    const dialog = await openDateDrawer();
    await dialog.getByRole('button', { name: 'Bevestig maand' }).click();

    const dayListbox = dialog.getByRole('listbox', { name: /Selecteer een dag/ });
    const selectedDays = () =>
      dayListbox
        .getByRole('option')
        .elements()
        .filter((el) => el.getAttribute('aria-selected') === 'true')
        .map((el) => el.textContent?.trim());

    // The first available day is preselected
    await expect.poll(selectedDays).toEqual(['maandag 7']);

    await dayListbox.getByRole('option', { name: /maandag 14/ }).click();

    await expect.poll(selectedDays).toEqual(['maandag 14']);
  });

  it('can confirm a day in a month that is not the current month', async () => {
    const dialog = await openDateDrawer();
    await dialog.getByRole('button', { name: 'Bevestig maand' }).click();
    await dialog
      .getByRole('listbox', { name: /Selecteer een dag/ })
      .getByRole('option', { name: /maandag 21/ })
      .click();
    await dialog.getByRole('button', { name: 'Bevestig dag' }).click();

    await expect
      .element(page.getByRole('button', { name: 'Kies een datum' }))
      .toHaveTextContent('maandag 21 december 2026');
  });
});
