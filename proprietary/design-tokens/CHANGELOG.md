# @gemeente-rotterdam/design-tokens

## 1.1.1

### Patch Changes

- 198566a: Logo mag groter worden dan de minimale afmeting: `--utrecht-logo-max-inline-size` is nu `320px` en `--utrecht-logo-max-block-size` is nu `64px` (voorheen gelijk aan de minimale afmeting van 220 × 48px).
- 198566a: Ruimte rond koppen, spotlight-secties en fieldsets hersteld, met dezelfde waarden als de standaardinstellingen van Utrecht:
  
  - `--utrecht-heading-2-margin-block-start` is nu `1.5rem` en `--utrecht-heading-2-margin-block-end` is nu `0.3rem` (was `0px`).
  - `--utrecht-heading-3-margin-block-start` is nu `1rem` en `--utrecht-heading-3-margin-block-end` is nu `0.2rem` (was `0px`).
  - `--utrecht-spotlight-section-margin-block-start` is nu `24px` (was `0px`).
  - `--utrecht-form-fieldset-margin-block-start` is nu `4px` (was `40px`).
- b9b20e6: Doubly ensure packages are published with provenance

## 1.1.0

### Minor Changes

- 03c6f39: Design tokens for the Rotterdam Date Picker.

## 1.0.1

### Patch Changes

- 792b3f7: Upgraded style-dictionary to v5 and @tokens-studio/sd-transform to v2

  Some syntax was fixed to support these versions but no values were added or changed.

## 1.0.0

### Minor Changes

- ec4c203: Add design tokens for Utrecht Page Layout components:
  - `utrecht.body.*`
  - `utrecht.root.*`
  - `utrecht.page-header.*`
  - `utrecht.page-body.*`
  - `utrecht.page-footer.*`
