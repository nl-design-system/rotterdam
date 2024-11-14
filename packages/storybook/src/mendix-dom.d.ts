/* eslint-disable no-unused-vars */
import { AriaAttributes, DOMAttributes, HTMLAttributes } from 'react';

declare module 'react' {
  interface HTMLAttributes<T> extends AriaAttributes, DOMAttributes<T> {
    // extends React's HTMLAttributes
    mask?: string;
    widgetid?: string;
  }
}
