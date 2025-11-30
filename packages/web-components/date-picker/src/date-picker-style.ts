import { css } from 'lit';

export default css`
  div {
    background: silver;
  }
  .rods-time-slots {
    margin-block-end: 0; /* reset <ul> */
    margin-block-start: 0; /* reset <ul> */
    margin-inline-end: 0; /* reset <ul> */
    margin-inline-start: 0; /* reset <ul> */
    padding-inline-start: 0; /* reset <ul> */

    display: flex;
    column-gap: var(--rods-time-slots-column-gap, 1ch);
    row-gap: var(--rods-time-slots-row-gap, 1em);
    flex-wrap: wrap;
    --rods-time-badge-min-inline-size: 100px;
  }
  .rods-time-badge__slot {
    min-inline-size: 4em;
    border-color: var(--rods-time-badge-color, silver);
    border-style: solid;
    border-width: 1px;
  }
  .rods-time-badge {
    text-align: center;

    /* code taken from nl-data-badge */
    /* npm: @nl-design-system-candidate/data-badge-css@1.0.3 */
    background-color: var(--rods-time-badge-background-color);
    border-color: var(--rods-time-badge-border-color, currentColor);
    border-radius: var(--rods-time-badge-border-radius, 0);
    border-style: solid;
    border-width: var(--rods-time-badge-border-width, 1px);
    box-sizing: border-box;
    color: var(--rods-time-badge-color);
    display: inline-block;
    font-family: var(--rods-time-badge-font-family);
    font-size: var(--rods-time-badge-font-size);
    font-weight: var(--rods-time-badge-font-weight);
    line-height: var(--rods-time-badge-line-height);
    /* max-block-size: max-content; */
    /* max-inline-size: max-content; */
    min-block-size: var(--rods-time-badge-min-block-size);
    min-inline-size: var(--rods-time-badge-min-inline-size);
    padding-block: var(--rods-time-badge-padding-block);
    padding-inline: var(--rods-time-badge-padding-inline);
    text-decoration: none; /* no inheritance */
  }
  .rods-time-badge--selected {
    background-color: var(--rods-time-badge-selected-background-color, var(--rods-time-badge-background-color));
    border-color: var(--rods-time-badge-selected-border-color, var(--rods-time-badge-border-color, currentColor));
    color: var(--rods-time-badge-selected-color, var(--rods-time-badge-color));
  }
  .rods-time-badge--selected b {
    display: contents;
  }
`;
