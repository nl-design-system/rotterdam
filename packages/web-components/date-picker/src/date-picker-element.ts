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
  Day,
  getDatesBetween,
  getDaysInMonth,
  getMaxDate,
  getMinDate,
  getNextMonth,
  getPrevMonth,
  isAfterCurrentMonth,
  isBeforeCurrentMonth,
  isSameDate,
  isSameMonth,
  sortDate,
  TimeOption,
} from './date-picker-utils';
import datePickerCSS from './date-picker.css?raw';
import timeBadgeCSS from './time-badge.css?raw';

export const tag = 'rods-date-picker';
interface DatePickerI18n {
  [index: string]: DatePickerI18nText;
}

interface DatePickerI18nText {
  afspraakLocale: string;
  chooseDatumLabelLocale: string;
  chooseLabelFirstDescLocale: string;
  chooseTimeLabelLocale: string;
  confirmDayLocale: string;
  confirmLocale: string;
  confirmMonthLocale: string;
  confirmTimeLocale: string;
  dayInLocale: string;
  daysOfWeek: string[];
  descriptionLocale: string;
  hourSuffixLocal: string;
  months: string[];
  nextLocale: string;
  previousLocale: string;
  selectLocale: string;
  selectMonthLocale: string;
  selectTimeLocale: string;
  timeDescLocale: string;
  todayLocale: string;
}

@customElement(tag)
export class DatePickerElement extends LitElement {
  static formAssociated = true;
  static override readonly styles = [
    unsafeCSS(datePickerCSS),
    unsafeCSS(timeBadgeCSS),
    unsafeCSS(buttonCSS),
    unsafeCSS(drawerCSS),
    unsafeCSS(formFieldCSS),
    unsafeCSS(formLabelCSS),
    unsafeCSS(formFieldDescriptionCSS),
    unsafeCSS(iconCSS),
    unsafeCSS(listboxCSS),
    unsafeCSS(textboxCSS),
  ];

  _internals = this.attachInternals();

  _name: string = '';

  @property({ reflect: true })
  get name() {
    return this._name;
  }

  set name(name: unknown) {
    if (typeof name === 'string') {
      this._name = name;
    }
  }

  /* `Date` object for the current `value` */
  _dateValue: Date | null = null;

  _times: TimeOption[] = [];

  @property({ attribute: 'options' })
  get options() {
    return this._times.map(({ date, label }) => ({
      label,
      value: date.toISOString(),
    }));
  }

  /**
   * Allow setting a array via the property, or allow setting a JSON array via the attribute.
   * For example:
   *
   *     <rods-date-picker options="[]"></rods-date-picker>
   *
   * Or:
   *
   *     document.querySelector('rods-date-picker').options = [];
   */
  set options(value: { value: string; label?: string }[] | string) {
    const newValue = typeof value === 'string' ? (JSON.parse(value) as { value: string; label: string }[]) : value;

    this._times = newValue.map(({ label, value }) => {
      const dateObj = new Date(value);
      return {
        date: dateObj,
        label: label,
      };
    });
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

  /**
   * When browsing through months and days, this `Date` represents the date the user currently chooses to view.
   * It can be configured via `_selectDate()`
   */
  _visibleDate = new Date();

  _dynamic = false;

  /**
   * Set to `true` to flag that the values in `times` are not complete,
   * and they can be updates based on the `visibleDateChange` event.
   */
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

  /**
   * This is the `value` for the form associated element.
   */
  @property({ reflect: true })
  get value() {
    return this._dateValue ? this._dateValue.toISOString() : '';
  }

  set value(value: unknown) {
    if (typeof value === 'string' || typeof value === 'number') {
      const newDate = new Date(value);

      if (Number.isFinite(newDate.getTime())) {
        this._dateValue = new Date(value);
      } else {
        this._dateValue = null;
      }
    }
  }

  _i18n: DatePickerI18n = {
    en: {
      afspraakLocale: 'Your appointment:',
      chooseDatumLabelLocale: 'Choose a date:',
      chooseLabelFirstDescLocale: 'Choose a date first.',
      chooseTimeLabelLocale: 'Choose a time slot:',
      confirmDayLocale: 'Confirm day',
      confirmLocale: 'Confirm your appointment',
      confirmMonthLocale: 'Confirm month',
      confirmTimeLocale: 'Confirm time slot',
      dayInLocale: 'Pick a day in ',
      daysOfWeek: ['sun', 'mon', 'tue', 'wed', 'thu', 'fri', 'sat'],
      descriptionLocale: 'You can only select dates with available slots.',
      hourSuffixLocal: "o'clock",
      months: [
        'January',
        'February',
        'March',
        'April',
        'May',
        'June',
        'July',
        'August',
        'September',
        'October',
        'November',
        'December',
      ],
      nextLocale: 'Previous month',
      previousLocale: 'Next month',
      selectLocale: 'Select a date:',
      selectMonthLocale: 'Select a month',
      selectTimeLocale: 'Select a time slot for ',
      timeDescLocale: 'Available time slots:',
      todayLocale: 'Today',
    },
    nl: {
      afspraakLocale: 'Uw afspraak:',
      chooseDatumLabelLocale: 'Kies een datum:',
      chooseLabelFirstDescLocale: 'Kies eerst een datum.',
      chooseTimeLabelLocale: 'Kies een tijdslot:',
      confirmDayLocale: 'Bevestig dag',
      confirmLocale: 'Bevestig uw afspraak',
      confirmMonthLocale: 'Bevestig maand',
      confirmTimeLocale: 'Bevestig tijdslot',
      dayInLocale: 'Selecteer een dag in',
      daysOfWeek: ['zo', 'ma', 'di', 'wo', 'do', 'vr', 'za'],
      descriptionLocale: 'U kunt alleen beschikbare dagen selecteren.',
      hourSuffixLocal: 'uur',
      months: [
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
      ],
      nextLocale: 'Volgende maand',
      previousLocale: 'Vorige maand',
      selectLocale: 'Selecteer een datum:',
      selectMonthLocale: 'Selecteer een maand',
      selectTimeLocale: 'Selecteer een tijdslot voor ',
      timeDescLocale: 'Beschikbare tijdsloten:',
      todayLocale: 'Vandaag',
    },
  };

  _lang: string = 'nl';

  /**
   * The language of the UI
   */
  @property({ reflect: true })
  override get lang() {
    return this._lang;
  }

  override set lang(value: string) {
    this._lang = value;
    this.requestUpdate();
  }

  /**
   * Configuration object to specify text in multiple languages
   */
  @property({ reflect: true })
  get i18n() {
    return this._i18n;
  }

  set i18n(value: DatePickerI18n) {
    this._i18n = value;
    this.requestUpdate();
  }

  override render() {
    const lang = this._lang;
    const {
      afspraakLocale,
      chooseDatumLabelLocale,
      chooseLabelFirstDescLocale,
      chooseTimeLabelLocale,
      confirmDayLocale,
      confirmLocale,
      confirmMonthLocale,
      confirmTimeLocale,
      dayInLocale,
      daysOfWeek,
      descriptionLocale,
      hourSuffixLocal,
      months,
      nextLocale,
      previousLocale,
      selectLocale,
      selectMonthLocale,
      selectTimeLocale,
      timeDescLocale,
      todayLocale,
    } = this.i18n[lang];
    const formatMonth = (date: Date) => `${monthLocale(date.getMonth())} ${date.getFullYear()}`;

    const dayOfWeekLocale = (n: Day): string => {
      const labels = daysOfWeek;
      return labels[n];
    };

    const monthLocale = (n: number) => {
      const labels = months;
      return labels[n];
    };

    const formattedSelectedDate = this._dateValue
      ? new Intl.DateTimeFormat(lang, { dateStyle: 'full' }).format(this._dateValue)
      : '';
    let formattedSelectedTime = this._dateValue
      ? new Intl.DateTimeFormat(lang, { timeStyle: 'short' }).format(this._dateValue)
      : '';

    if (hourSuffixLocal) {
      formattedSelectedTime = formattedSelectedTime
        ? `${formattedSelectedTime} ${hourSuffixLocal}`
        : formattedSelectedTime;
    }

    const formattedSelectedDateTime = this._dateValue
      ? new Intl.DateTimeFormat(lang, { dateStyle: 'full', timeStyle: 'short' }).format(this._dateValue)
      : '';

    const currentIndex = this._times.findIndex((el) => el.selected);
    const activeDescendant = `option-${currentIndex}`;
    const today = new Date();
    const times = this._times.filter((a) => isSameDate(a.date, this._visibleDate));
    const sortedTimes = [...this._times].sort((a: DateOption, b: DateOption): number => sortDate(a.date, b.date));
    const firstTime = this._dynamic ? null : sortedTimes[0];
    const lastTime = this._dynamic ? null : sortedTimes.at(-1);

    // TODO: Handle when there are no time slots
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

    const min = this.getAttribute('min');
    const max = this.getAttribute('max');
    const minDate = min ? new Date(min) : null;
    const maxDate = max ? new Date(max) : null;
    const formattedCurrentMonth = formatMonth(this._visibleDate);
    const formattedPrevMonth = formatMonth(getPrevMonth(this._visibleDate));
    const formattedNextMonth = formatMonth(getNextMonth(this._visibleDate));
    const mobileTimeOptions = times;
    const minBrowsableDate = minDate && firstTime ? getMaxDate(minDate, firstTime.date) : minDate || firstTime?.date;
    const maxBrowsableDate = maxDate && lastTime ? getMinDate(maxDate, lastTime.date) : maxDate || lastTime?.date;
    const hasPrevMonth = minBrowsableDate ? isBeforeCurrentMonth(this._visibleDate, minBrowsableDate) : true;
    const hasNextMonth = maxBrowsableDate ? isAfterCurrentMonth(this._visibleDate, maxBrowsableDate) : true;
    /* TODO: Replace with logic to only show when no date has been selected */
    const showTimePlaceholder = times.length === 0;

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

    const htmlCells = [...beforeDates, ...dates].map((date) => this._renderGridCell({ ...date, todayLocale }));

    // Create a 7xN grid out of the cells
    const dateHTML = new Array(Math.ceil(htmlCells.length / 7)).fill(null).map(
      (_, index) =>
        html`<tr>
          ${htmlCells.slice(index * 7, index * 7 + 7)}
        </tr>`,
    );

    const output = html`<div class="rods-date-picker">
      <div class="rods-date-picker__mobile">
        <div class="utrecht-form-field">
          <div class="utrecht-form-field__label">
            <label for="mobile-date-button" class="utrecht-form-label" id="mobile-date-label"
              >${chooseDatumLabelLocale}</label
            >
          </div>
          <div class="utrecht-form-field__input">
            <button
              id="mobile-date-button"
              class="utrecht-textbox"
              type="button"
              @click=${() => this.showDateModal()}
              todo-aria-labelledby="mobile-date-label mobile-date-button-label"
              aria-labelledby="mobile-date-label"
            >
              <span class="utrecht-icon">
                <slot name="icon-date"></slot>
                <!-- TODO: When icon-date slot is used, do not show the default icon -->
                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path
                    d="M11 14C10.4477 14 10 14.4477 10 15C10 15.5523 10.4477 16 11 16V18C11 18.5523 11.4477 19 12 19C12.5523 19 13 18.5523 13 18V15C13 14.4477 12.5523 14 12 14H11Z"
                    fill="currentColor"
                  />
                  <path
                    fill-rule="evenodd"
                    clip-rule="evenodd"
                    d="M16 2C16.5523 2 17 2.44772 17 3V4H18C18.7956 4 19.5587 4.31607 20.1213 4.87868C20.6839 5.44129 21 6.20435 21 7V19C21 19.7957 20.6839 20.5587 20.1213 21.1213C19.5587 21.6839 18.7957 22 18 22H6C5.20435 22 4.44129 21.6839 3.87868 21.1213C3.31607 20.5587 3 19.7957 3 19V7C3 6.20435 3.31607 5.44129 3.87868 4.87868C4.44129 4.31607 5.20435 4 6 4H7V3C7 2.44772 7.44772 2 8 2C8.55228 2 9 2.44772 9 3V4H15V3C15 2.44772 15.4477 2 16 2ZM19 7V10H5V7C5 6.73478 5.10536 6.48043 5.29289 6.29289C5.48043 6.10536 5.73478 6 6 6H7V7C7 7.55228 7.44772 8 8 8C8.55228 8 9 7.55228 9 7V6H15V7C15 7.55228 15.4477 8 16 8C16.5523 8 17 7.55228 17 7V6H18C18.2652 6 18.5196 6.10536 18.7071 6.29289C18.8946 6.48043 19 6.73478 19 7ZM19 12H5V19C5 19.2652 5.10536 19.5196 5.29289 19.7071C5.48043 19.8946 5.73478 20 6 20H18C18.2652 20 18.5196 19.8946 18.7071 19.7071C18.8946 19.5196 19 19.2652 19 19V12Z"
                    fill="currentColor"
                  />
                </svg>
              </span>
              <span class="utrecht-textbox__value" id="mobile-date-button-label">${formattedSelectedDate}</span>
            </button>
          </div>
        </div>
        <dialog class="utrecht-drawer utrecht-drawer--block-end" id="date-drawer" aria-labelledby="mobile-date-label">
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
            <label for="mobile-time-button" class="utrecht-form-label" id="mobile-time-label-text"
              >${chooseTimeLabelLocale}</label
            >
          </div>
          <div class="utrecht-form-field__description">
            <div class="utrecht-form-field-description">${chooseLabelFirstDescLocale}</div>
          </div>
          <div class="utrecht-form-field__input">
            <button
              id="mobile-time-button"
              class="utrecht-textbox"
              type="button"
              @click=${() => this.showTimeModal()}
              xaria-labelledby="mobile-time-label-text"
              aria-labelledby="mobile-time-label-text mobile-time-button-text"
            >
              <span class="utrecht-icon">
                <slot name="icon-time"></slot>
                <!-- TODO: When icon-time slot is used, do not show the default icon -->
                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path
                    fill-rule="evenodd"
                    clip-rule="evenodd"
                    d="M12 4C7.58172 4 4 7.58172 4 12C4 16.4183 7.58172 20 12 20C16.4183 20 20 16.4183 20 12C20 7.58172 16.4183 4 12 4ZM2 12C2 6.47715 6.47715 2 12 2C17.5228 2 22 6.47715 22 12C22 17.5228 17.5228 22 12 22C6.47715 22 2 17.5228 2 12ZM12 6C12.5523 6 13 6.44772 13 7V11.5858L15.7071 14.2929C16.0976 14.6834 16.0976 15.3166 15.7071 15.7071C15.3166 16.0976 14.6834 16.0976 14.2929 15.7071L11.2929 12.7071C11.1054 12.5196 11 12.2652 11 12V7C11 6.44772 11.4477 6 12 6Z"
                    fill="currentColor"
                  />
                </svg>
              </span>
              <span class="utrecht-textbox__value" id="mobile-time-button-text">${formattedSelectedTime}</span>
            </button>
          </div>
        </div>
        <div class="rods-date-picker__mobile-summary">
          <p>
            ${afspraakLocale}<br />
            <span>op <strong>${formattedSelectedDate}</strong></span>
            <br /><span>om <strong>${formattedSelectedTime}</strong></span>
          </p>
          <p>
            <button type="button" class="utrecht-button utrecht-button--secondary-action">${confirmLocale}</button>
          </p>
        </div>
      </div>
      <div class="rods-date-panels rods-date-picker__desktop">
        <div class="rods-date-panels__panel rods-date-panels__panel--date">
          <div class="rods-date-panels__panel-header">
            <p id="date-label" class="utrecht-form-label">${selectLocale}</p>
            <p id="date-desc" class="utrecht-form-field-description">${descriptionLocale}</p>
          </div>
          <div class="rods-date-panels__panel-body">
            <div class="rods-date-picker__grid-navigation">
              <div class="rods-date-picker__grid-caption" id="current-month-label">${formattedCurrentMonth}</div>
              <button
                aria-labelledby="prev-month-label"
                aria-describedby="prev-month-description"
                rel="prev"
                type="button"
                aria-disabled=${hasPrevMonth ? nothing : 'true'}
                tabindex=${hasPrevMonth ? nothing : '0'}
                class=${clsx('utrecht-button', 'utrecht-button--rods-icon-only', {
                  'utrecht-button--disabled': !hasPrevMonth,
                })}
                @click=${() => {
                  if (hasPrevMonth) {
                    this.showPreviousMonth();
                  }
                }}
              >
                <span class="utrecht-icon">
                  <slot name="icon-prev"></slot>
                  <!-- TODO: When icon-prev slot is used, do not show the default icon -->
                  <svg
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
                <span class="utrecht-button__label" id="prev-month-description">${formattedPrevMonth}</span>
              </button>
              <button
                aria-labelledby="next-month-label"
                aria-describedby="next-month-description"
                rel="next"
                type="button"
                aria-disabled=${hasNextMonth ? nothing : 'true'}
                class=${clsx('utrecht-button', 'utrecht-button--rods-icon-only', {
                  'utrecht-button--disabled': !hasNextMonth,
                })}
                @click=${() => {
                  if (hasNextMonth) {
                    this.showNextMonth();
                  }
                }}
              >
                <span id="next-month-label" class="utrecht-button__label">${nextLocale}</span>
                <span class="utrecht-icon">
                  <!-- TODO: When icon-next slot is used, do not show the default icon -->
                  <slot name="icon-next"></slot
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
                <span class="utrecht-button__label" id="next-month-description">${formattedNextMonth}</span>
              </button>
            </div>

            <table
              class="utrecht-calendar__table"
              role="grid"
              aria-labelledby="current-month-label"
              tabindex="0"
              @keydown=${this.handleKeyDownDate}
            >
              <thead class="utrecht-calendar__table-weeks-container">
                <tr class="utrecht-calendar__table-weeks-container-content">
                  <th class="rods-date-picker__grid-column-header">${dayOfWeekLocale(1)}</th>
                  <th class="rods-date-picker__grid-column-header">${dayOfWeekLocale(2)}</th>
                  <th class="rods-date-picker__grid-column-header">${dayOfWeekLocale(3)}</th>
                  <th class="rods-date-picker__grid-column-header">${dayOfWeekLocale(4)}</th>
                  <th class="rods-date-picker__grid-column-header">${dayOfWeekLocale(5)}</th>
                  <th class="rods-date-picker__grid-column-header">${dayOfWeekLocale(6)}</th>
                  <th class="rods-date-picker__grid-column-header">${dayOfWeekLocale(0)}</th>
                </tr>
              </thead>
              <tbody class="utrecht-calendar__table-days-container">
                ${dateHTML}
              </tbody>
            </table>
          </div>
        </div>
        <div class="rods-date-panels__panel rods-date-panels__panel--time">
          <div class="rods-date-panels__panel-header">
            <p id="time-label" class="utrecht-form-label">${selectTimeLocale}</p>
            <p id="time-desc" class="utrecht-form-field-description">
              ${timeDescLocale} <strong>${formattedSelectedDate}</strong>
            </p>
          </div>
          <div class="rods-date-panels__panel-body">
            <div
              class="rods-time-badge-listbox"
              tabindex="0"
              @keydown=${this.handleKeyDown}
              role="listbox"
              aria-labelledby="time-label"
              aria-describedby="time-desc"
              aria-activedescendant=${activeDescendant}
            >
              <ul class="rods-time-badge-list" role="list">
                ${times.map(({ date, label, selected }, index, list) => {
                  const labelText = label || new Intl.DateTimeFormat(this._lang, { timeStyle: 'short' }).format(date);
                  return html`<li
                    id="option-${index}"
                    class="rods-time-badge${selected ? ' rods-time-badge--selected' : ''}"
                    role="option"
                    @click=${() => this.selectTime(date)}
                    aria-selected=${selected ? 'true' : 'false'}
                    aria-posinset=${index + 1}
                    aria-setsize=${list.length}
                  >
                    ${selected
                      ? /* render the selected item with a <b> element, so it will still have a distinct appearance without CSS */
                        html`<b>${labelText}</b>`
                      : labelText}
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
          <p>
            <slot name="submit-button"></slot>
          </p>
        </div>
      </div>
    </div>`;

    return output;
  }

  _renderGridCell = ({
    date,
    disabled,
    emphasis,
    hidden,
    label,
    readOnly,
    selected,
    today,
    todayLocale,
  }: DateOption & { todayLocale: string }) => {
    return html`<td
      class="utrecht-calendar__table-cell"
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
          'rods-date-picker__grid-button',
          { 'rods-date-picker__grid-button--placeholder': hidden },
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
        ${label}${today ? html`<span class="rods-date-picker__grid-button-description">${todayLocale}</span>` : nothing}
      </button>
    </td>`;
  };

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
    const next = Math.max(Math.min(index, this._times.length - 1), 0);
    this._times = this._times.map((option, index) => ({
      ...option,
      selected: index === next,
    }));
    const date = this._times[next];
    if (date) {
      this._dateValue = new Date(date.date.getTime());
      this.updateValue(this._dateValue.toISOString());
    }

    this.requestUpdate();
    this.scrollOptionIntoView();
  }
  /**
   * Changes to the date go through this method.
   * @param index
   */
  selectTime(date: Date) {
    const selectedTime = this._times.find((option) => option.date === date);

    if (selectedTime) {
      this.updateValue(selectedTime.date.toISOString());
    }

    this._times = this._times.map((option) => ({
      ...option,
      selected: option.date === date,
    }));

    this.requestUpdate();
    this.scrollOptionIntoView();
  }
  updateValue(isoString: string) {
    this._dateValue = new Date(isoString);
    this.dispatchEvent(new CustomEvent('change'));
    this.dispatchEvent(new CustomEvent('input'));
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
    this.showModalStep(rootSelector, 2);
  }
  showModalStep(rootSelector: string, step: number) {
    const isTruthy = <T>(arg: T | null | undefined): arg is T => !!arg;
    const root = this.shadowRoot?.querySelector<HTMLDialogElement>(rootSelector);
    const visibleStep = root?.querySelector<HTMLDialogElement>(`[data-step="${step}"]`);
    const otherSteps = Array.from(root?.querySelectorAll<HTMLElement>('[data-step]') || [])
      .filter((step) => step !== visibleStep)
      .filter(isTruthy);

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
