import buttonCSS from '@utrecht/button-css/dist/index.css?raw';
import drawerCSS from '@utrecht/drawer-css/dist/index.css?raw';
import formFieldCSS from '@utrecht/form-field-css/dist/index.css?raw';
import formFieldDescriptionCSS from '@utrecht/form-field-description-css/dist/index.css?raw';
import formLabelCSS from '@utrecht/form-label-css/dist/index.css?raw';
import iconCSS from '@utrecht/icon-css/dist/index.css?raw';
import listboxCSS from '@utrecht/listbox-css/dist/index.css?raw';
import textboxCSS from '@utrecht/textbox-css/dist/index.css?raw';
import clsx from 'clsx';
import { html, LitElement, nothing, unsafeCSS } from 'lit';
import { customElement, property, queryAsync } from 'lit/decorators.js';
import {
  DateOption,
  dayOfWeekLocale,
  getDatesBetween,
  getDaysInMonth,
  isSameDate,
  isSameMonth,
  monthLocale,
  sortDate,
  TimeOption,
} from './date-picker-utils';
import datePickerCSS from './date-picker.css?raw';

export const tag = 'rods-date-picker';

@customElement(tag)
export class DatePickerElement extends LitElement {
  _internals = this.attachInternals();
  date: Date = new Date();

  static formAssociated = true;
  static override readonly styles = [
    unsafeCSS(datePickerCSS),
    unsafeCSS(buttonCSS),
    unsafeCSS(drawerCSS),
    unsafeCSS(formFieldCSS),
    unsafeCSS(formLabelCSS),
    unsafeCSS(formFieldDescriptionCSS),
    unsafeCSS(iconCSS),
    unsafeCSS(listboxCSS),
    unsafeCSS(textboxCSS),
  ];
  dates: DateOption[] = [];

  _times: TimeOption[] = [];

  @property({ attribute: 'times' })
  get times() {
    return this._times.map(({ date, label }) => ({
      date: date.toISOString(),
      label,
    }));
  }

  /**
   * Allow setting a array via the property, or allow setting a JSON array via the attribute.
   * For example:
   *
   *     <rods-date-picker times="[]"></rods-date-picker>
   *
   * Or:
   *
   *     document.querySelector('rods-date-picker').times = [];
   */
  set times(value: { date: string; label?: string }[] | string) {
    const newValue = typeof value === 'string' ? (JSON.parse(value) as { date: string; label: string }[]) : value;

    this._times = newValue.map(({ date, label }) => ({
      date: new Date(date),
      label,
    }));

    this.requestUpdate();
  }

  /**
   * Method that UI elements inside the component can use to pick a new date.
   */
  _selectDate(date: Date) {
    this._visibleDate = date;
    this.requestUpdate();
  }

  @queryAsync('[aria-selected="true"]')
  currentSelected: Promise<HTMLElement | null> = Promise.resolve(null);

  _visibleDate = new Date();
  _visibleTimes: TimeOption[] = [];
  /**
   * Set to `true` to flag that the values in `times` are not complete,
   * and they can be updates based on the `visibleDateChange` event.
   */
  _dynamic = false;
  @property()
  get dynamic() {
    return this._dynamic;
  }

  set dynamic(value: boolean) {
    this._dynamic = value;
  }

  @property({ attribute: 'visible-date' })
  get visibleDate() {
    const removeTime = (isoString: string) => isoString.replace(/[TZ].+$/, '');
    return removeTime(this._visibleDate.toISOString());
  }

  set visibleDate(value: unknown) {
    if (typeof value === 'string' || typeof value === 'number') {
      this._visibleDate = new Date(value);
    }
  }

  @property({ reflect: true })
  get value() {
    const removeTime = (isoString: string) => isoString.replace(/[TZ].+$/, '');
    return removeTime(this.date.toISOString());
  }

  set value(value: unknown) {
    if (typeof value === 'string' || typeof value === 'number') {
      this.date = new Date(value);
    }
  }

  override render() {
    const selectLocale = 'Selecteer een datum:';
    const descriptionLocale = 'U kunt alleen beschikbare dagen selecteren.';
    const todayLocale = 'Vandaag';
    const selectTimeLocale = 'Selecteer een tijdslot voor ';
    const timeDescLocale = 'Beschikbare tijdsloten:';
    const afspraakLocale = 'Uw afspraak:';
    const confirmLocale = 'Bevestig uw afspraak';
    const previousLocale = 'Vorige maand';
    const chooseDatumLabelLocale = 'Kies een datum:';
    const chooseTimeLabelLocale = 'Kies een tijdslot:';
    const chooseLabelFirstDescLocale = 'Kies eerst een datum.';
    const selectMonthLocale = 'Selecteer een maand';
    const dayInLocale = 'Selecteer een dag in';
    const confirmMonthLocale = 'Bevestig maand';
    const confirmDayLocale = 'Bevestig dag';
    const confirmTimeLocale = 'Bevestig tijdslot';
    const nextLocale = 'Volgende maand';
    const hourSuffixLocal = 'uur';
    // const dates = this.dates;
    const currentIndex = this._times.findIndex((el) => el.selected);
    const activeDescendant = `option-${currentIndex}`;
    const today = new Date();

    const times = this._times.filter((a) => isSameDate(a.date, this._visibleDate));

    const sortedTimes = [...this._times].sort((a: DateOption, b: DateOption): number => sortDate(a.date, b.date));
    const firstTime = this._dynamic ? null : sortedTimes[0];
    const lastTime = this._dynamic ? null : sortedTimes.at(-1);

    // TODO: Handle when there are no time slots
    // const minDate = new Date(firstTime);
    // const maxDate = new Date(lastTime);
    const dates: DateOption[] = getDaysInMonth(this._visibleDate).map((date) => {
      const timeSlots = this._times.filter((a) => isSameDate(date, a.date));
      return {
        date,
        disabled: timeSlots.length === 0,
        label: date.getDate().toString(),
        selected: isSameDate(date, this._visibleDate),
        today: isSameDate(today, date),
      };
    });

    // Determine which day is the first in the grid, when the grid starts on Monday
    const firstDate = dates[0].date;
    const firstDay = firstDate.getDay();
    const remainder = firstDay % 7;
    const firstGridDay = new Date(firstDate);
    firstGridDay.setDate(firstDate.getDate() - remainder + 1); // add 1 to start on monday

    const beforeDates: DateOption[] = getDatesBetween(firstGridDay, firstDate).map((date) => ({
      date,
      disabled: true,
      hidden: true,
      label: date.getDate().toString(),
      readOnly: true,
    }));

    const htmlCells = [...beforeDates, ...dates].map(
      ({ date, disabled, emphasis, hidden, label, readOnly, selected, today }) => {
        return html`<td
          role="gridcell"
          aria-current=${today ? 'date' : nothing}
          aria-selected=${selected ? 'true' : nothing}
          aria-readonly=${readOnly ? 'true' : nothing}
        >
          <button
            type="button"
            tabindex="-1"
            class=${clsx(
              'utrecht-button',
              { 'placeholder-cell': hidden },
              {
                'utrecht-button--pressed': selected,
              },
              {
                'utrecht-button--disabled': readOnly,
              },
              'utrecht-calendar__table-days-item-day',
              { 'utrecht-calendar__table-days-item-day--readonly': readOnly },
              { 'utrecht-calendar__table-days-item-day--current': today },
              { 'utrecht-calendar__table-days-item-day--emphasis': emphasis },
              { 'utrecht-calendar__table-days-item-day--selected': selected },
            )}
            ?disabled=${disabled}
            aria-pressed=${selected ? 'true' : nothing}
            value=${date.toISOString()}
            @click=${() => this._selectDate(date)}
          >
            ${label}${today ? html`<span class="today-marker">${todayLocale}</span>` : nothing}
          </button>
        </td>`;
      },
    );

    // Create a 7xN grid out of the cells
    const dateHTML = new Array(Math.ceil(htmlCells.length / 7)).fill(null).map(
      (_, index) =>
        html`<tr>
          ${htmlCells.slice(index * 7, index * 7 + 7)}
        </tr>`,
    );

    const lang = 'nl';
    const formattedSelectedDate = new Intl.DateTimeFormat(lang, { dateStyle: 'full' }).format(this._visibleDate);
    const formattedSelectedTime = new Intl.DateTimeFormat(lang, { timeStyle: 'short' }).format(this._visibleDate);
    const formattedSelectedDateTime = new Intl.DateTimeFormat(lang, { dateStyle: 'full', timeStyle: 'short' }).format(
      this.date,
    );

    const getStartOfMonth = (date: Date) => new Date(date.getFullYear(), date.getMonth(), date.getDate(), 0, 0, 0, 0);
    const getEndOfMonth = (date: Date) =>
      // Return the first moment in the next month, minus one millisecond
      new Date(date.getFullYear(), date.getMonth() + 1, date.getDate(), 0, 0, 0, -1);

    const isBeforeMonth = (month: Date, date: Date): boolean => date.getTime() < getStartOfMonth(month).getTime();
    const isAfterMonth = (month: Date, date: Date): boolean => date.getTime() > getEndOfMonth(month).getTime();

    const min = this.getAttribute('min');
    const max = this.getAttribute('max');
    const minDate = min ? new Date(min) : null;
    const maxDate = max ? new Date(max) : null;

    const getMinDate = (dateA: Date, dateB: Date) => {
      const a = dateA.getTime();
      const b = dateB.getTime();
      return a < b ? dateA : dateB;
    };

    const getMaxDate = (dateA: Date, dateB: Date) => {
      const a = dateA.getTime();
      const b = dateB.getTime();
      return a > b ? dateA : dateB;
    };
    this._visibleTimes = sortedTimes;

    const monthOptions: { label: string; selected?: boolean; date: Date }[] = [
      { date: new Date('2025-01-01'), label: monthLocale(0) },
      { date: new Date('2025-02-01'), label: monthLocale(1) },
      { date: new Date('2025-03-01'), label: monthLocale(2) },
      { date: new Date('2025-04-01'), label: monthLocale(3) },
      { date: new Date('2025-05-01'), label: monthLocale(4) },
      { date: new Date('2025-06-01'), label: monthLocale(5) },
      { date: new Date('2025-07-01'), label: monthLocale(6) },
      { date: new Date('2025-08-01'), label: monthLocale(7) },
      { date: new Date('2025-09-01'), label: monthLocale(8) },
      { date: new Date('2025-10-01'), label: monthLocale(9) },
      { date: new Date('2025-11-01'), label: monthLocale(10) },
      { date: new Date('2025-12-01'), label: monthLocale(11) },
      { date: new Date('2026-01-01'), label: monthLocale(0) },
    ];

    const mobileMonthOptions = monthOptions.map((option, index, options) => {
      let updated = option;
      if (index === 0 || (index >= 1 && option.date.getFullYear() !== options[index - 1].date.getFullYear())) {
        updated = {
          ...option,
          label: option.label + ` ${option.date.getFullYear()}`,
        };
      }
      updated = {
        ...updated,
        selected: isSameMonth(this._visibleDate, option.date),
      };

      return updated;
    });

    const mobileDayOptions = dates
      .filter(({ disabled }) => !disabled)
      .map((option) => {
        return {
          ...option,
          label: new Intl.DateTimeFormat(lang, { dateStyle: 'full' })
            .format(option.date)
            .replace(String(option.date.getFullYear()), '')
            .replace(/januari|februari|maart|april|mei|juni|juli|augustus|september|oktober|november|december/g, ''),
        };
      });

    const mobileTimeOptions = times;
    const minBrowsableDate = minDate && firstTime ? getMaxDate(minDate, firstTime.date) : minDate || firstTime?.date;
    const maxBrowsableDate = maxDate && lastTime ? getMinDate(maxDate, lastTime.date) : maxDate || lastTime?.date;
    const hasPrevMonth = minBrowsableDate ? isBeforeMonth(this._visibleDate, minBrowsableDate) : true;
    const hasNextMonth = maxBrowsableDate ? isAfterMonth(this._visibleDate, maxBrowsableDate) : true;
    const showTimePlaceholder =
      times.length === 0; /* TODO: Replace with logic to only show when no date has been selected */
    const output = html`<div class="rods-date-picker">
      <div class="rods-date-picker__small">
        <div class="utrecht-form-field">
          <div class="utrecht-form-field__label">
            <label for="date" class="utrecht-form-label" id="mobile-date-label-text">${chooseDatumLabelLocale}</label>
          </div>
          <div class="utrecht-form-field__input">
            <button
              id="date"
              class="utrecht-textbox"
              type="button"
              @click=${() => this.showDateModal()}
              todo-aria-labelledby="mobile-date-label-text mobile-date-button-text"
              aria-labelledby="mobile-date-label-text"
            >
              <span class="utrecht-icon">
                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path
                    d="M11 14C10.4477 14 10 14.4477 10 15C10 15.5523 10.4477 16 11 16V18C11 18.5523 11.4477 19 12 19C12.5523 19 13 18.5523 13 18V15C13 14.4477 12.5523 14 12 14H11Z"
                    fill="#00811F"
                  />
                  <path
                    fill-rule="evenodd"
                    clip-rule="evenodd"
                    d="M16 2C16.5523 2 17 2.44772 17 3V4H18C18.7956 4 19.5587 4.31607 20.1213 4.87868C20.6839 5.44129 21 6.20435 21 7V19C21 19.7957 20.6839 20.5587 20.1213 21.1213C19.5587 21.6839 18.7957 22 18 22H6C5.20435 22 4.44129 21.6839 3.87868 21.1213C3.31607 20.5587 3 19.7957 3 19V7C3 6.20435 3.31607 5.44129 3.87868 4.87868C4.44129 4.31607 5.20435 4 6 4H7V3C7 2.44772 7.44772 2 8 2C8.55228 2 9 2.44772 9 3V4H15V3C15 2.44772 15.4477 2 16 2ZM19 7V10H5V7C5 6.73478 5.10536 6.48043 5.29289 6.29289C5.48043 6.10536 5.73478 6 6 6H7V7C7 7.55228 7.44772 8 8 8C8.55228 8 9 7.55228 9 7V6H15V7C15 7.55228 15.4477 8 16 8C16.5523 8 17 7.55228 17 7V6H18C18.2652 6 18.5196 6.10536 18.7071 6.29289C18.8946 6.48043 19 6.73478 19 7ZM19 12H5V19C5 19.2652 5.10536 19.5196 5.29289 19.7071C5.48043 19.8946 5.73478 20 6 20H18C18.2652 20 18.5196 19.8946 18.7071 19.7071C18.8946 19.5196 19 19.2652 19 19V12Z"
                    fill="#00811F"
                  />
                </svg>
              </span>
              <span class="utrecht-textbox__value" id="mobile-date-button-text">${formattedSelectedDate}</span>
            </button>
          </div>
        </div>
        <dialog
          class="utrecht-drawer utrecht-drawer--block-end"
          id="date-drawer"
          aria-labelledby="mobile-date-label-text"
        >
          <form method="dialog">
            <div class="utrecht-drawer__rods-step" id="date-drawer-step-1" data-step="1">
              <div class="utrecht-drawer__rods-header">
                <h2 class="utrecht-drawer__rods-heading" id="mobile-date-listbox-label">
                  <strong>1/2</strong> ${selectMonthLocale}
                </h2>
              </div>
              <div class="utrecht-drawer__rods-body">
                <div
                  class="utrecht-listbox utrecht-listbox--html-div rods-scroll-shadows"
                  role="listbox"
                  tabindex="0"
                  aria-labelledby="mobile-date-listbox-label"
                >
                  <ul class="utrecht-listbox__list" role="none">
                    ${mobileMonthOptions.map(
                      ({ date, label, selected }) =>
                        html`<li
                          class=${`utrecht-listbox__option utrecht-listbox__option--html-li ${selected ? 'utrecht-listbox__option--selected' : ''}`}
                          aria-selected=${selected ? 'true' : 'false'}
                          role="option"
                          @click=${() => this.showMonth(date)}
                        >
                          ${label}
                        </li>`,
                    )}
                  </ul>
                </div>
              </div>
              <div class="utrecht-drawer__rods-footer">
                <div class="utrecht-action-group">
                  <button
                    type="button"
                    class="utrecht-button utrecht-button--primary-action"
                    @click=${() => this.nextModalStep('#date-drawer')}
                  >
                    ${confirmMonthLocale}
                  </button>
                </div>
              </div>
            </div>
            <div class="utrecht-drawer__rods-step" id="date-drawer-step-2" hidden data-step="2">
              <div class="utrecht-drawer__rods-header">
                <h2 class="utrecht-drawer__rods-heading" id="mobile-day-listbox-label">
                  <strong>2/2</strong> ${dayInLocale} ${monthLocale(this._visibleDate.getMonth())}
                </h2>
              </div>
              <div class="utrecht-drawer__rods-body">
                <div
                  class="utrecht-listbox utrecht-listbox--html-div rods-scroll-shadows"
                  role="listbox"
                  tabindex="0"
                  aria-labelledby="mobile-day-listbox-label"
                >
                  <ul class="utrecht-listbox__list" role="none">
                    ${mobileDayOptions.map(
                      ({ date, label, selected }) =>
                        html`<li
                          class=${`utrecht-listbox__option utrecht-listbox__option--html-li ${selected ? 'utrecht-listbox__option--selected' : ''}`}
                          aria-selected=${selected ? 'true' : 'false'}
                          role="option"
                          @click=${() => this._selectDate(date)}
                        >
                          ${label}
                        </li>`,
                    )}
                  </ul>
                </div>
              </div>
              <div class="utrecht-drawer__rods-footer">
                <div class="utrecht-action-group">
                  <button
                    type="button"
                    class="utrecht-button utrecht-button--primary-action"
                    formmethod="dialog"
                    @click=${() => this.closeDateModal()}
                  >
                    ${confirmDayLocale}
                  </button>
                </div>
              </div>
            </div>
          </form>
        </dialog>
        <dialog class="utrecht-drawer utrecht-drawer--block-end" id="time-drawer">
          <form method="dialog">
            <div class="utrecht-drawer__rods-header">
              <h2 class="utrecht-drawer__rods-heading">${selectTimeLocale} ${formattedSelectedDate}</h2>
            </div>
            <div class="utrecht-drawer__rods-body">
              <div class="utrecht-listbox utrecht-listbox--html-div rods-scroll-shadows" role="listbox" tabindex="0">
                <ul class="utrecht-listbox__list" role="none">
                  ${mobileTimeOptions.map(
                    ({ date, label, selected }) =>
                      html`<li
                        class=${`utrecht-listbox__option utrecht-listbox__option--html-li ${selected ? 'utrecht-listbox__option--selected' : ''}`}
                        aria-selected=${selected ? 'true' : 'false'}
                        role="option"
                        @click=${() => this.selectTime(date)}
                      >
                        ${label}
                      </li>`,
                  )}
                </ul>
              </div>
            </div>
            <div class="utrecht-drawer__rods-footer">
              <div class="utrecht-action-group">
                <button
                  type="button"
                  class="utrecht-button utrecht-button--primary-action"
                  formmethod="dialog"
                  @click=${() => this.closeTimeModal()}
                >
                  ${confirmTimeLocale}
                </button>
              </div>
            </div>
          </form>
        </dialog>
        <div class="utrecht-form-field">
          <div class="utrecht-form-field__label">
            <label for="date" class="utrecht-form-label" id="mobile-time-label-text">${chooseTimeLabelLocale}</label>
          </div>
          <div class="utrecht-form-field__description">
            <div class="utrecht-form-field-description">${chooseLabelFirstDescLocale}</div>
          </div>
          <div class="utrecht-form-field__input">
            <button
              id="time"
              class="utrecht-textbox"
              type="button"
              @click=${() => this.showTimeModal()}
              xaria-labelledby="mobile-time-label-text"
              aria-labelledby="mobile-time-label-text mobile-time-button-text"
            >
              <span class="utrecht-icon">
                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path
                    fill-rule="evenodd"
                    clip-rule="evenodd"
                    d="M12 4C7.58172 4 4 7.58172 4 12C4 16.4183 7.58172 20 12 20C16.4183 20 20 16.4183 20 12C20 7.58172 16.4183 4 12 4ZM2 12C2 6.47715 6.47715 2 12 2C17.5228 2 22 6.47715 22 12C22 17.5228 17.5228 22 12 22C6.47715 22 2 17.5228 2 12ZM12 6C12.5523 6 13 6.44772 13 7V11.5858L15.7071 14.2929C16.0976 14.6834 16.0976 15.3166 15.7071 15.7071C15.3166 16.0976 14.6834 16.0976 14.2929 15.7071L11.2929 12.7071C11.1054 12.5196 11 12.2652 11 12V7C11 6.44772 11.4477 6 12 6Z"
                    fill="#00811F"
                  />
                </svg>
              </span>
              <span class="utrecht-textbox__value" id="mobile-time-button-text"
                >${formattedSelectedTime} ${hourSuffixLocal}</span
              >
            </button>
          </div>
        </div>
        <div class="rods-date-picker__mobile-summary">
          <p>
            ${afspraakLocale}<br />
            <span>op <strong>${formattedSelectedDate}</strong></span>
            <br /><span>om <strong>${formattedSelectedTime} ${hourSuffixLocal}</strong></span>
          </p>
          <p><button type="button" class="utrecht-button utrecht-button--secondary-action">${confirmLocale}</button></p>
        </div>
      </div>
      <div class="rods-date-panels rods-date-picker__large">
        <div class="rods-date-panels__panel">
          <div class="rods-date-panels__panel-header">
            <p id="date-label" class="utrecht-form-label">${selectLocale}</p>
            <p id="date-desc" class="utrecht-form-field-description">${descriptionLocale}</p>
          </div>
          <div class="rods-date-panels__panel-body">
            <div class="rods-button-navigation">
              <div class="rods-button-navigation__current" id="current-month-label">
                ${monthLocale(this._visibleDate.getMonth())} ${this._visibleDate.getFullYear()}
              </div>
              <button
                aria-labelledby="prev-month-label"
                rel="prev"
                type="button"
                disabled=${hasPrevMonth ? nothing : 'true'}
                tabindex=${hasPrevMonth ? nothing : '0'}
                class=${clsx('utrecht-button', { 'utrecht-button--disabled': !hasPrevMonth })}
                @click=${() => {
                  if (hasPrevMonth) this.showPreviousMonth();
                }}
              >
                <span class="utrecht-icon"
                  ><svg
                    width="1em"
                    height="1em"
                    viewBox="0 0 32 32"
                    fill="currentColor"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <path
                      fill-rule="evenodd"
                      clip-rule="evenodd"
                      d="M11.8285 16L22.4351 5.3941L21.0208 3.97998L9.00003 16L21.0208 28.02L22.4351 26.6059L11.8285 16Z"
                    /></svg></span
                ><span id="prev-month-label" class="utrecht-button__label">${previousLocale}</span>
              </button>
              <button
                aria-labelledby="next-month-label"
                rel="next"
                type="button"
                disabled=${hasNextMonth ? nothing : 'true'}
                class=${clsx('utrecht-button', { 'utrecht-button--disabled': !hasNextMonth })}
                @click=${() => {
                  if (hasNextMonth) this.showNextMonth();
                }}
              >
                <span id="next-month-label" class="utrecht-button__label">${nextLocale}</span>
                <span class="utrecht-icon"
                  ><svg
                    width="1em"
                    height="1em"
                    viewBox="0 0 32 32"
                    fill="currentColor"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <path
                      fill-rule="evenodd"
                      clip-rule="evenodd"
                      d="M20.6066 16L10 5.3934L11.4142 3.97919L23.435 16L11.4142 28.0208L10 26.6066L20.6066 16Z"
                    /></svg
                ></span>
              </button>
            </div>

            <table role="grid" aria-labelledby="current-month-label" tabindex="0" @keydown=${this.handleKeyDownDate}>
              <thead class="utrecht-calendar__table-weeks-container">
                <tr class="utrecht-calendar__table-weeks-container-content">
                  <th>${dayOfWeekLocale(1)}</th>
                  <th>${dayOfWeekLocale(2)}</th>
                  <th>${dayOfWeekLocale(3)}</th>
                  <th>${dayOfWeekLocale(4)}</th>
                  <th>${dayOfWeekLocale(5)}</th>
                  <th>${dayOfWeekLocale(6)}</th>
                  <th>${dayOfWeekLocale(0)}</th>
                </tr>
              </thead>
              <tbody class="utrecht-calendar__table-days-container">
                ${dateHTML}
              </tbody>
            </table>
          </div>
        </div>
        <div class="rods-date-panels__panel">
          <div class="rods-date-panels__panel-header">
            <p id="time-label" class="utrecht-form-label">${selectTimeLocale}</p>
            <p id="time-desc" class="utrecht-form-field-description">
              ${timeDescLocale} <strong>${formattedSelectedDate}</strong>
            </p>
          </div>
          <div class="rods-date-panels__panel-body">
            <div
              class="rods-time-slots"
              tabindex="0"
              @keydown=${this.handleKeyDown}
              role="listbox"
              aria-labelledby="time-label"
              aria-describedby="time-desc"
              aria-activedescendant=${activeDescendant}
            >
              <ul class="rods-time-slots__list" role="list">
                ${times.map(({ date, label, selected }, index, list) => {
                  return html`<li
                    id="option-${index}"
                    class="rods-time-badge${selected ? ' rods-time-badge--selected' : ''}"
                    role="option"
                    @click2=${this.handleClickTime}
                    @click=${() => this.selectTime(date)}
                    aria-selected=${selected ? 'true' : nothing}
                    aria-posinset=${index + 1}
                    aria-setsize=${list.length}
                  >
                    ${selected
                      ? /* render the selected item with a <b> element, so it will still have a distinct appearance without CSS */
                        html`<b>${label}</b>`
                      : label}
                  </li>`;
                })}
              </ul>
              ${showTimePlaceholder
                ? html`<div class="rods-time-placeholder"><slot name="time-placeholder"></slot></div>`
                : nothing}
            </div>
          </div>
        </div>
        <div class="rods-date-panels__footer">
          <p>${afspraakLocale} <strong>${formattedSelectedDateTime}</strong></p>
          <p><button type="button" class="utrecht-button utrecht-button--secondary-action">${confirmLocale}</button></p>
        </div>
      </div>
    </div>`;

    return output;
  }

  showPreviousMonth() {
    const prev = new Date(this._visibleDate);
    prev.setMonth(prev.getMonth() - 1);
    this._visibleDate = prev;
    this.dispatchEvent(new CustomEvent('visibleDateChange')); // TODO: think of better name
    this.requestUpdate();
  }

  showNextMonth() {
    const next = new Date(this._visibleDate);
    next.setMonth(next.getMonth() + 1);
    this._visibleDate = next;
    this.dispatchEvent(new CustomEvent('visibleDateChange'));
    this.requestUpdate();
  }

  showMonth(date: Date) {
    this._visibleDate = date;
    console.log(date);
    this.dispatchEvent(new CustomEvent('visibleDateChange'));
    this.requestUpdate();
  }

  handleKeyDownDate(evt: KeyboardEvent) {
    if (evt.key === 'ArrowUp' || evt.key === 'ArrowLeft') {
      // Do not scroll
      evt.preventDefault();
      this.selectPrevDate();
    } else if (evt.key === 'ArrowRight' || evt.key === 'ArrowDown') {
      // Do not scroll
      evt.preventDefault();
      this.selectNextDate();
    } else if (evt.key === 'Home') {
      // Do not scroll
      evt.preventDefault();
      this.selectFirstDate();
    } else if (evt.key === 'End') {
      // Do not scroll
      evt.preventDefault();
      this.selectLastDate();
    } else if (evt.key === 'PageUp') {
      evt.preventDefault();
      this.selectPrevMonth();
    } else if (evt.key === 'PageDown') {
      evt.preventDefault();
      this.selectNextMonth();
    }
  }

  selectPrevMonth() {
    console.log('TODO: select previous month');
  }
  selectNextMonth() {
    console.log('TODO: select next month');
  }
  selectNextDate() {
    console.log('TODO: select next date');
  }
  selectPrevDate() {
    console.log('TODO: select previous date');
  }
  selectFirstDate() {
    console.log('TODO: select first month');
  }
  scrollOptionIntoViewDate() {
    // Scroll the current item into view
    (async () => {
      await this.updateComplete;
      this.shadowRoot?.querySelector('table [aria-selected="true"]')?.scrollIntoView({
        behavior: 'smooth',
        block: 'nearest',
        inline: 'nearest',
      });
    })();
  }
  selectLastDate() {
    this.selectIndex(this._times.length - 1);
  }
  handleKeyDown(evt: KeyboardEvent) {
    if (evt.key === 'ArrowUp' || evt.key === 'ArrowLeft') {
      // Do not scroll
      evt.preventDefault();
      this.selectPrev();
    } else if (evt.key === 'ArrowRight' || evt.key === 'ArrowDown') {
      // Do not scroll
      evt.preventDefault();
      this.selectNext();
    } else if (evt.key === 'Home') {
      // Do not scroll
      evt.preventDefault();
      this.selectFirst();
    } else if (evt.key === 'End') {
      // Do not scroll
      evt.preventDefault();
      this.selectLast();
    }
  }
  selectNext() {
    // Select the next item, or the first item when none was selected.
    const currentIndex = this._times.findIndex((el) => el.selected);
    const next = Math.max(Math.min(currentIndex === -1 ? 0 : currentIndex + 1, this._times.length - 1), 0);
    this.selectIndex(next);
  }
  selectPrev() {
    // Select the next item, or the first item when none was selected.
    const currentIndex = this._times.findIndex((el) => el.selected);
    const prev = Math.max(Math.min(currentIndex === -1 ? 0 : currentIndex - 1, this._times.length - 1), 0);
    this.selectIndex(prev);
  }
  selectFirst() {
    this.selectIndex(0);
  }
  /**
   * Changes to the date go through this method.
   * @param index
   */
  selectIndex(index: number) {
    console.log('select', index);
    const next = Math.max(Math.min(index, this._times.length - 1), 0);
    this._times = this._times.map((option, index) => ({
      ...option,
      selected: index === next,
    }));
    const date = this._times[next];
    if (date) {
      console.log('selected', date.date.toISOString());
      this.date = new Date(date.date.getTime());
      this.updateValue(this.date.toISOString());
    }

    this.requestUpdate();
    this.scrollOptionIntoView();
  }
  /**
   * Changes to the date go through this method.
   * @param index
   */
  selectTime(date: Date) {
    this._times = this._times.map((option) => ({
      ...option,
      selected: option.date === date,
    }));
    this.requestUpdate();
    this.scrollOptionIntoView();
  }
  updateValue(isoString: string) {
    this.date = new Date(isoString);
    this.dispatchEvent(new CustomEvent('change'));
  }
  scrollOptionIntoView() {
    // Scroll the current item into view
    (async () => {
      await this.updateComplete;
      this.shadowRoot?.querySelector('[aria-selected="true"]')?.scrollIntoView({
        behavior: 'smooth',
        block: 'nearest',
        inline: 'nearest',
      });
    })();
  }
  selectLast() {
    this.selectIndex(this._times.length - 1);
  }
  handleClickTime(evt: MouseEvent) {
    const target = evt.target;
    if (target instanceof HTMLElement) {
      const index = Number.parseInt(target.getAttribute('aria-posinset') || '', 10);
      if (Number.isFinite(index)) {
        this.selectIndex(index - 1);
      }
    }
  }
  showTimeModal() {
    this.shadowRoot?.querySelector<HTMLDialogElement>('#time-drawer')?.showModal();
  }
  showDateModal() {
    this.showModalStep('#date-drawer', 1);
    this.shadowRoot?.querySelector<HTMLDialogElement>('#date-drawer')?.showModal();
  }
  nextModalStep(rootSelector: string) {
    this.showModalStep(rootSelector, 2); // FIXME
  }
  showModalStep(rootSelector: string, step: number) {
    const isTruthy = <T>(arg: T | null | undefined): arg is T => !!arg;
    const root = this.shadowRoot?.querySelector<HTMLDialogElement>(rootSelector);
    const visibleStep = root?.querySelector<HTMLDialogElement>(`[data-step="${step}"]`);
    const otherSteps = Array.from(root?.querySelectorAll<HTMLElement>('[data-step]') || [])
      .filter((step) => step !== visibleStep)
      .filter(isTruthy);
    console.log(root, visibleStep, otherSteps, `[data-step="${step}"]`);
    const visibleSteps = [visibleStep].filter(isTruthy);
    otherSteps.forEach((el) => {
      el.hidden = true;
    });
    visibleSteps.forEach((el) => {
      el.hidden = false;
    });
  }
  closeDateModal() {
    this.shadowRoot?.querySelector<HTMLDialogElement>('#date-drawer')?.close();
  }
  closeTimeModal() {
    this.shadowRoot?.querySelector<HTMLDialogElement>('#time-drawer')?.close();
  }
}
