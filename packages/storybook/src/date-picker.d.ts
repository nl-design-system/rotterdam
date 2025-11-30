/** TODO: Ideally the `@gemeente-rotterdam/date-picker-element` package publishes an `index.d.ts` file with this info */
interface DatePickerProps {
  lang?: string;
  options?: { value: string; label?: string }[] | string;
  value?: string;
  children?: ReactNode;
}

interface HTMLElementTagNameMap {
  'rods-date-picker': DatePickerProps;
}

declare namespace JSX {
  interface IntrinsicElements {
    ['rods-date-picker']: DatePickerProps;
  }
}
