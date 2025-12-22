import { html, LitElement, unsafeCSS } from 'lit';
import { customElement, property } from 'lit/decorators.js';

const tag = 'rods-date-picker';

@customElement(tag)
export class DatePickerElement extends LitElement {
  internals_ = this.attachInternals();

  static readonly formAssociated = true;

  static override readonly styles = [unsafeCSS(':host { color: green }')];

  _name: string = '';
  _value: string = '';

  @property({ reflect: true })
  get name() {
    return this._name;
  }

  set name(name: unknown) {
    if (typeof name === 'string') {
      this._name = name;
    }
  }

  @property({ reflect: true })
  get value() {
    return this._value;
  }

  set value(value: unknown) {
    if (typeof value === 'string') {
      const date = new Date(value);

      if (!Number.isFinite(date.valueOf())) {
        throw new TypeError('Invalid format');
      }

      this._value = value;
    }
  }

  override render() {
    return html`<input
      type="datetime-local"
      value=${this._value}
      @change=${(evt: Event) => {
        this._value = (evt.target as HTMLInputElement).value;
        this.dispatchEvent(new CustomEvent('change'));
      }}
      @input=${(evt: Event) => {
        this._value = (evt.target as HTMLInputElement).value;
        this.dispatchEvent(new CustomEvent('input'));
      }}
    />`;
  }
}
