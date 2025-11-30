import { html, LitElement } from 'lit';
import { customElement, property } from 'lit/decorators.js';
import style from './date-picker-style';
const tag = 'rods-date-picker';

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
}
interface TimeOption {
  date: Date;
  label?: string;
  today?: boolean;
  selected?: boolean;
}

@customElement(tag)
export class DatePickerElement extends LitElement {
  internals_ = this.attachInternals();
  date: Date = new Date();

  static formAssociated = true;
  static override readonly styles = [style];
  dates: DateOption[] = [
    {
      date: new Date(),
      label: '24',
      today: true,
    },
  ];
  times: TimeOption[] = [
    { date: new Date('9:50'), label: '9:50', selected: true },
    { date: new Date('10:20'), label: '10:20' },
    { date: new Date('10:40'), label: '10:40' },
    { date: new Date('10:50'), label: '10:50' },
    { date: new Date('11:00'), label: '11:00' },
    { date: new Date('11:10'), label: '11:10' },
    { date: new Date('11:20'), label: '11:20' },
    { date: new Date('11:30'), label: '11:30' },
    { date: new Date('11:40'), label: '11:40' },
    { date: new Date('13:10'), label: '13:10' },
    { date: new Date('13:20'), label: '13:20' },
    { date: new Date('13:30'), label: '13:30' },
    { date: new Date('13:40'), label: '13:40' },
    { date: new Date('13:50'), label: '13:50' },
    { date: new Date('14:00'), label: '14:00' },
    { date: new Date('14:10'), label: '14:10' },
    { date: new Date('14:20'), label: '14:20' },
    { date: new Date('14:30'), label: '14:30' },
    { date: new Date('14:40'), label: '14:40' },
    { date: new Date('14:50'), label: '14:50' },
    { date: new Date('15:00'), label: '15:00' },
    { date: new Date('15:10'), label: '15:10' },
    { date: new Date('15:20'), label: '15:20' },
    { date: new Date('15:30'), label: '15:30' },
    { date: new Date('15:40'), label: '15:40' },
    { date: new Date('15:50'), label: '15:50' },
    { date: new Date('16:00'), label: '16:00' },
    { date: new Date('16:10'), label: '16:10' },
    { date: new Date('16:20'), label: '16:20' },
    { date: new Date('16:30'), label: '16:30' },
    { date: new Date('16:40'), label: '16:40' },
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
  @property({ reflect: true })
  get value() {
    return this.date.toString();
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
    const dates = this.dates;
    return html` <div>
    <div class="rods-date-panels">
    <div  class="rods-date-panels__panel">
      <p id="date-label">${selectLocale}</p>
      <p id="date-desc">${descriptionLocale}</p>
      <input type="date" id="date" aria-labelledby="date-label" aria-describedby="date-desc" />
      <ul>
      ${dates.map(({ date, today }) => {
        return html`<li role="option">${date}${today ? todayLocale : ''}</li>`;
      })}
        <li role="option">${todayLocale}</li>
      </ul>
      </div>
      <div class="rods-date-panels__panel">
      <p>${selectTimeLocale}</p>
      <p>${timeDescLocale}</p>
      <ul class="rods-time-slots">
      ${this.times.map(({ label, selected }) => {
        return html`<li
          class="rods-time-badge${selected ? ' rods-time-badge--selected' : ''}"
          role="option"
          ${selected ? ' aria-selected="true"' : ''}
        >
          ${selected
            ? /* render the selected item with a <b> element, so it will still have a distinct appearance without CSS */
              html`<b>${label}</b>`
            : label}
        </li>`;
      })}
      </ul>
      <input type="time"/>
      </div>
      <p>${afspraakLocale}</p>
      <button>${confirmLocale}</p>
    </div></div>`;
  }
}
