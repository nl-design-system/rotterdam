import type { DatePickerElement } from './date-picker-element';

declare global {
  interface HTMLElementTagNameMap {
    [tag]: DatePickerElement;
  }
}
