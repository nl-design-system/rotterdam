# Date Picker

## Usage

Include the following snippet in your page to load the component. Change `@gemeente-rotterdam/date-picker-element` to wherever you have downloaded the code, for example somewhere in `node_modules/`.

```html
<script type="module" src="@gemeente-rotterdam/date-picker-element/dist/index.js"></script>
```

Render the date picker where you want it, using:

```html
<rods-date-picker></rods-date-picker>
```

The `rods-date-picker` element works like an `input` element:

- you can set the `name` and `value` attributes to associate it with a form
- it has `change`, `input`, `focus`, `blur` events
- it has a `value` property

```html
<form>
  <rods-date-picker name="timeslot" value="2025-01-01T09:42">
    <button type="submit" slot="submit-button">Verzenden</button>
  </rods-date-picker>
</form>
```

You must specify the available options with the `options` attribute or `options` property:

```html
<rods-date-picker
  name="timeslot"
  value="2025-01-01T09:42"
  options='[{ "value": "2025-01-01T09:42" }]'
></rods-date-picker>
```
