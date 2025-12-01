import buttonCSS from '@utrecht/button-css/dist/index.css?raw';
import formFieldDescriptionCSS from '@utrecht/form-field-description-css/dist/index.css?raw';
import formLabelCSS from '@utrecht/form-label-css/dist/index.css?raw';
import iconCSS from '@utrecht/icon-css/dist/index.css?raw';
import clsx from 'clsx';
import { html, LitElement, nothing, unsafeCSS } from 'lit';
import { customElement, property, queryAsync } from 'lit/decorators.js';
import style from './date-picker-style';
import datePickerCSS from './date-picker.css?raw';

const tag = 'rods-date-picker';

/* date-fns `Day` type */
enum Day {
  SUNDAY = 0,
  MONDAY = 1,
  TUESDAY = 2,
  WEDNESDAY = 3,
  THURSDAY = 4,
  FRIDAY = 5,
  SATURDAY = 6,
}

declare global {
  interface HTMLElementTagNameMap {
    [tag]: DatePickerElement;
  }
}

interface DateOption {
  date: Date;
  label?: string;
  today?: boolean;
  selected?: boolean;
  readOnly?: boolean;
  disabled?: boolean;
  emphasis?: boolean;
  hidden?: boolean;
}
interface TimeOption {
  date: Date;
  label?: string;
  today?: boolean;
  selected?: boolean;
}

/**
 * Give a `Date` for every day in the specified month.
 * Dates are sorted from first to last day.
 */
const getDaysInMonth = (date: Date) => {
  const dates = [];
  const month = date.getMonth();
  const anotherDay = new Date(date);
  for (let i = 1; i < 32; i++) {
    // Start with the first day in the month,
    // then test every next day.
    anotherDay.setDate(i);
    // The number of days in each month vary.
    // Detect when the date is part of the next month,
    // and stop looking.
    if (anotherDay.getMonth() === month) {
      dates.push(new Date(anotherDay));
    } else {
      break;
    }
  }
  return dates;
};

@customElement(tag)
export class DatePickerElement extends LitElement {
  internals_ = this.attachInternals();
  date: Date = new Date();

  static formAssociated = true;
  static override readonly styles = [
    unsafeCSS(datePickerCSS),
    unsafeCSS(buttonCSS),
    unsafeCSS(formLabelCSS),
    unsafeCSS(formFieldDescriptionCSS),
    unsafeCSS(iconCSS),
  ];
  dates: DateOption[] = [
    {
      date: new Date('2025-09-09'),
      label: '9x',
      selected: true,
      today: true,
    },
  ];

  times: TimeOption[] = [
    { date: new Date('2025-09-09T09:50'), label: '9:50', selected: true },
    { date: new Date('2025-09-09T10:20'), label: '10:20' },
    // { date: new Date('2025-09-09T10:40'), label: '10:40' },
    // { date: new Date('2025-09-09T10:50'), label: '10:50' },
    // { date: new Date('2025-09-09T11:00'), label: '11:00' },
    // { date: new Date('2025-09-09T11:10'), label: '11:10' },
    // { date: new Date('2025-09-09T11:20'), label: '11:20' },
    // { date: new Date('2025-09-09T11:30'), label: '11:30' },
    // { date: new Date('2025-09-09T11:40'), label: '11:40' },
    // { date: new Date('2025-09-09T13:10'), label: '13:10' },
    // { date: new Date('2025-09-09T13:20'), label: '13:20' },
    // { date: new Date('2025-09-09T13:30'), label: '13:30' },
    // { date: new Date('2025-09-09T13:40'), label: '13:40' },
    // { date: new Date('2025-09-09T13:50'), label: '13:50' },
    // { date: new Date('2025-09-09T14:00'), label: '14:00' },
    // { date: new Date('2025-09-09T14:10'), label: '14:10' },
    // { date: new Date('2025-09-09T14:20'), label: '14:20' },
    // { date: new Date('2025-09-09T14:30'), label: '14:30' },
    // { date: new Date('2025-09-09T14:40'), label: '14:40' },
    // { date: new Date('2025-09-09T14:50'), label: '14:50' },
    // { date: new Date('2025-09-09T15:00'), label: '15:00' },
    // { date: new Date('2025-09-09T15:10'), label: '15:10' },
    // { date: new Date('2025-09-09T15:20'), label: '15:20' },
    // { date: new Date('2025-09-09T15:30'), label: '15:30' },
    // { date: new Date('2025-09-09T15:40'), label: '15:40' },
    // { date: new Date('2025-09-09T15:50'), label: '15:50' },
    // { date: new Date('2025-09-09T16:00'), label: '16:00' },
    // { date: new Date('2025-09-09T16:10'), label: '16:10' },
    // { date: new Date('2025-09-09T16:20'), label: '16:20' },
    // { date: new Date('2025-09-09T16:30'), label: '16:30' },
    // { date: new Date('2025-09-09T16:40'), label: '16:40' },
    // { date: new Date('2025-09-10T09:50'), label: '9:10' },
    // { date: new Date('2025-09-11T09:50'), label: '9:11' },
    // { date: new Date('2025-09-12T09:50'), label: '9:12' },
    // { date: new Date('2025-09-13T09:50'), label: '9:13' },
    // { date: new Date('2025-09-14T09:50'), label: '9:14' },
    // { date: new Date('2025-09-15T09:50'), label: '9:15' },
    // { date: new Date('2025-09-16T09:50'), label: '9:16' },
    // { date: new Date('2025-09-17T09:50'), label: '9:17' },
    // { date: new Date('2025-09-18T09:50'), label: '9:18' },
    // { date: new Date('2025-09-22T09:50'), label: '9:22' },
    // { date: new Date('2025-09-23T09:50'), label: '9:23' },
    // { date: new Date('2025-09-24T09:50'), label: '9:24' },
    // { date: new Date('2025-09-25T09:50'), label: '9:25' },
    // { date: new Date('2025-09-26T09:50'), label: '9:26' },
    // { date: new Date('2025-09-27T09:50'), label: '9:27' },
    // { date: new Date('2025-09-28T09:50'), label: '9:28' },
    // { date: new Date('2025-09-29T09:50'), label: '9:29' },
    // { date: new Date('2025-09-30T09:50'), label: '9:30' },
    { date: new Date('2025-12-30T09:50'), label: '9:50' },
    { date: new Date('2025-12-30T09:50'), label: '9:50' },
    { date: new Date('2025-12-30T09:50'), label: '9:50' },
  ];

  static valueAsString(value: unknown) {
    switch (typeof value) {
      case 'string':
        return value;
      case 'object':
        return JSON.stringify(value, null, 2);
      case 'number':
      default:
        return `${value}`;
    }
  }

  selectDate(date: Date) {
    this._visibleDate = date;
    console.log(date.toISOString());
    this.requestUpdate();
  }

  @queryAsync('[aria-selected="true"]')
  currentSelected: Promise<HTMLElement>;

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
    const selectTimeLocale = 'Selecteer een tijdslot:';
    const timeDescLocale = 'Beschikbare tijdsloten:';
    const afspraakLocale = 'Uw afspraak:';
    const confirmLocale = 'Bevestig uw afspraak';
    const previousLocale = 'Vorige maand';
    const nextLocale = 'Volgende maand';
    // const dates = this.dates;
    const currentIndex = this.times.findIndex((el) => el.selected);
    const activeDescendant = `option-${currentIndex}`;
    const today = new Date();

    const dayOfWeekLocale = (n: Day) => {
      const labels = ['zo', 'ma', 'di', 'wo', 'do', 'vr', 'za'];
      return labels[n];
    };
    const monthLocale = (n: number) => {
      const labels = [
        'januari',
        'februari',
        'maart',
        'april',
        'mei',
        'juni',
        'juli',
        'augustus',
        'september',
        'oktober',
        'november',
        'december',
      ];
      return labels[n];
    };

    const isSameMonth = (a: Date, b: Date) => a.getFullYear() === b.getFullYear() && a.getMonth() === b.getMonth();
    const isSameDate = (a: Date, b: Date) => isSameMonth(a, b) && a.getDate() === b.getDate();

    const times = this.times.filter((a) => isSameDate(a.date, this._visibleDate));

    const numberSort = (a: number, b: number) => (a === b ? 0 : a > b ? 1 : -1);
    const sortDate = (a: Date, b: Date) => numberSort(a.getTime(), b.getTime());

    const sortedTimes = [...this.times].sort((a: DateOption, b: DateOption): number => sortDate(a.date, b.date));
    const firstTime = this._dynamic ? null : sortedTimes[0];
    const lastTime = this._dynamic ? null : sortedTimes.at(-1);

    // TODO: Handle when there are no time slots
    // const minDate = new Date(firstTime);
    // const maxDate = new Date(lastTime);
    const dates: DateOption[] = getDaysInMonth(this._visibleDate).map((date) => {
      const timeSlots = this.times.filter((a) => isSameDate(date, a.date));
      return {
        date,
        disabled: timeSlots.length === 0,
        label: date.getDate().toString(),
        selected: isSameDate(date, this._visibleDate),
        today: isSameDate(today, date),
      };
    });
    console.log(dates);

    // Determine which day is the first in the grid, when the grid starts on Monday
    const firstDate = dates[0].date;
    const firstDay = firstDate.getDay();
    const remainder = firstDay % 7;
    const firstGridDay = new Date(firstDate);
    firstGridDay.setDate(firstDate.getDate() - remainder + 1); // add 1 to start on monday

    const getDatesBetween = (from: Date, to: Date) => {
      if (from.getTime() > to.getTime()) {
        return [];
        // prevent infinite loop
        // throw new TypeError();
      }
      const fromDate = from.getDate();
      const dates = [];
      const currentDate = new Date(from);
      for (let day = 1; day; day++) {
        currentDate.setDate(fromDate + day);
        if (currentDate.getTime() >= to.getTime()) {
          break;
        }
        dates.push(new Date(currentDate));
      }
      return dates;
    };

    const beforeDates: DateOption[] = getDatesBetween(firstGridDay, firstDate).map((date) => ({
      date,
      disabled: true,
      hidden: true,
      label: date.getDate(),
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
            @click=${() => this.selectDate(date)}
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

    const minBrowsableDate = minDate && firstTime ? getMaxDate(minDate, firstTime.date) : minDate || firstTime?.date;
    const maxBrowsableDate = maxDate && lastTime ? getMinDate(maxDate, lastTime.date) : maxDate || lastTime?.date;
    const hasPrevMonth = minBrowsableDate ? isBeforeMonth(this._visibleDate, minBrowsableDate) : true;
    const hasNextMonth = maxBrowsableDate ? isAfterMonth(this._visibleDate, maxBrowsableDate) : true;
    const showTimePlaceholder =
      times.length === 0; /* TODO: Replace with logic to only show when no date has been selected */
    const output = html`<div>
      <div class="rods-date-panels">
        <div class="rods-date-panels__panel">
          <div class="rods-date-panels__panel-header">
            <p id="date-label" class="utrecht-form-label">${selectLocale}</p>
            <p id="date-desc" class="utrecht-form-field-description">${descriptionLocale}</p>
          </div>
          <div class="rods-date-panels__panel-body">
            <div class="rods-button-navigation">
              <div class="rods-button-navigation__current">
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

            <table role="grid" aria-labelledby="date-label" tabindex="0" @keydown=${this.handleKeyDownDate}>
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
                ${times.map(({ label, selected }, index, list) => {
                  return html`<li
                    id="option-${index}"
                    class="rods-time-badge${selected ? ' rods-time-badge--selected' : ''}"
                    role="option"
                    @click=${this.handleClickTime}
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
    this.selectIndex(this.times.length - 1);
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
    const currentIndex = this.times.findIndex((el) => el.selected);
    const next = Math.max(Math.min(currentIndex === -1 ? 0 : currentIndex + 1, this.times.length - 1), 0);
    this.selectIndex(next);
  }
  selectPrev() {
    // Select the next item, or the first item when none was selected.
    const currentIndex = this.times.findIndex((el) => el.selected);
    const prev = Math.max(Math.min(currentIndex === -1 ? 0 : currentIndex - 1, this.times.length - 1), 0);
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
    const next = Math.max(Math.min(index, this.times.length - 1), 0);
    this.times = this.times.map((option, index) => ({
      ...option,
      selected: index === next,
    }));
    const date = this.times[next];
    if (date) {
      console.log('selected', date.date.toISOString());
      this.date = new Date(date.date.getTime());
      this.updateValue(this.date.toISOString());
    }
    console.log(this.times);
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
    this.selectIndex(this.times.length - 1);
  }
  handleClickTime(evt: MouseEvent) {
    const index = Number.parseInt(evt.target?.getAttribute('aria-posinset'), 10);
    if (Number.isFinite(index)) {
      this.selectIndex(index - 1);
    }
  }
}
