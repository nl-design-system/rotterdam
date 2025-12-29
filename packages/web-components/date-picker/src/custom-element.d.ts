import type { DatePickerElement } from './date-picker-element';

// Ensure the type
declare global {
  interface HTMLElementTagNameMap {
    ['rods-date-picker']: DatePickerElement;
  }
}
