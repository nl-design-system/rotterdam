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
    const currentIndex = this.times.findIndex((el) => el.selected);
    const activeDescendant = `option-${currentIndex}`;
    const output = html` <div>
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
      <p id="time-label">${selectTimeLocale}</p>
      <p id="time-desc">${timeDescLocale}</p>
      <div class="rods-time-slots" tabindex="0" @keydown=${this.handleKeyDown} role="listbox" aria-labelledby="time-label" aria-describedby="time-desc" aria-activedescendant=${activeDescendant}>
      <ul class="rods-time-slots__list" role="list">
      ${this.times.map(({ label, selected }, index) => {
        return html`<li
          data-index="${index}"
          id="option-${index}"
          class="rods-time-badge${selected ? ' rods-time-badge--selected' : ''}"
          role="option"
          @click=${this.handleClick}
          ${selected ? ' aria-selected="true"' : ''}
        >
          ${selected
            ? /* render the selected item with a <b> element, so it will still have a distinct appearance without CSS */
              html`<b>${label}</b>`
            : label}
        </li>`;
      })}
      </ul>
      </div>
      <input type="time"/>
      </div>
      <p>${afspraakLocale}</p>
      <button>${confirmLocale}</p>
    </div></div>`;

    console.log(output);
    return output;
  }
  handleKeyDown(evt) {
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
  selectIndex(index) {
    console.log('select', index);
    const next = Math.max(Math.min(index, this.times.length - 1), 0);
    this.times = this.times.map((option, index) => ({
      ...option,
      selected: index === next,
    }));
    this.requestUpdate();
  }
  selectLast() {
    this.selectIndex(this.times.length - 1);
  }
  handleClick(evt) {
    console.log('click');
  }
}
