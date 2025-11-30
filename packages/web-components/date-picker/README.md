# Date Picker

## Instructions

Create a date picker
Create a web component
Use Lit to create the web component
Create a form associated custom element

## Keyboard Support

- The group of time slots is focusable via `Tab` and `Shift+Tab`
- The group of time slots is only one tab stop, so it is easy to bypass the many options.
- The next item in the group can be selected with `ArrowRight` and `ArrowDown`
- The previous item in the group can be selected with `ArrowLeft` and `ArrowUp`
- The first item in the group can be selected with `Home`
- The last item in the group can be selected with `End`
- `PageUp` and `PageDown` are not supported.

## JavaScript API

...

## Localisation

## Accessibility

- We have implemented keyboard support, for [WCAG SC 2.1.1](https://nldesignsystem.nl/wcag/2.1.1/).
- We have tested there is no focus trap, for [WCAG SC 2.1.2](https://nldesignsystem.nl/wcag/2.1.2/).
- We have optimized the rendering so the widget is still understandable without CSS:
  - Render the selected date or time in bold with the HTML `b` element.
  - Render the calendar grid with an HTML `table` element.
- We have optimized the rendering in forced colors mode.
