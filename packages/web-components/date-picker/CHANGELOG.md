# @gemeente-rotterdam/date-picker-element

## 0.1.0

### Minor Changes

- dcecfe6: The date picker drawers are now cancelable with the `Escape` key.
- dcecfe6: The date picker drawer now pre-select the first option.
- dcecfe6: Date picker now automatically detects the language of the document.

### Patch Changes

- 36880cf: Date Picker now has an initial form associated value, for form submits.
- dcecfe6: Automatically display the calendar for the current value.
- 3ef8928: Display option label instead of time when available.
- dcecfe6: Date picker button to open the drawer with time options is now disabled, until the user selects a date.
- dcecfe6: Date picker now doesn't dispatch `change` and `input` events until the drawer is submitted.
- dcecfe6: Improve date picker performance when there are many options.

## 0.0.3

### Patch Changes

- df27a0e: Fix date picker to disable submit button and hide summary of selected value, when no date has been selected.
- df27a0e: Show actually selected date in mobile date picker, instead of initially visible date.'
- 61cfc47: Only show dates within the range of options, in the mobile date picker drawer for month selection.

## 0.0.2

### Patch Changes

- 03c6f39: Alpha release of the new date picker design.

## 0.0.1

### Patch Changes

- eafc8fc: Test release.
