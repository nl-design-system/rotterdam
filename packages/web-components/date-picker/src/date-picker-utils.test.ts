import { describe, expect, it } from 'vitest';
import './date-picker-utils';
import { getDaysInMonth } from './date-picker-utils';

describe('getDaysInMonth', () => {
  it('returns a array of Date objects', () => {
    const date = new Date();

    const days = getDaysInMonth(date);
    expect(days).toBeInstanceOf(Array);

    days.forEach((day) => {
      expect(day).toBeInstanceOf(Date);
    });
  });

  it('returns a new Date object', () => {
    const date = new Date();

    const days = getDaysInMonth(date);
    expect(days).not.toContain(date);
  });

  it('returns between 28 and 31 days, for each day in the year', () => {
    const MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;

    Array(365)
      .fill(0)
      .map((_, n) => n * MILLISECONDS_IN_DAY)
      .map((n) => new Date(n))
      .map((date) => getDaysInMonth(date))
      .forEach((days) => {
        expect(days.length).toBeGreaterThanOrEqual(28);
        expect(days.length).toBeLessThanOrEqual(31);
      });
  });

  it('returns only days in the same month', () => {
    const MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;

    Array(365)
      .fill(0)
      .map((_, n) => n * MILLISECONDS_IN_DAY)
      .map((n) => new Date(n))
      .map((date): [Date, Date[]] => [date, getDaysInMonth(date)])
      .forEach(([date, days]: [Date, Date[]]) => {
        days.forEach((day) => {
          expect(day.getFullYear()).toBe(date.getFullYear());
          expect(day.getMonth()).toBe(date.getMonth());
        });
      });
  });

  it.skip('returns days in sorted order', () => {
    const MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;

    Array(365)
      .fill(0)
      .map((_, n) => n * MILLISECONDS_IN_DAY)
      .map((n) => new Date(n))
      .map((date) => getDaysInMonth(date))
      .forEach((days) => {
        // console.log(days);
        days.reduce((previous, current) => {
          console.log(previous, current);
          if (!(current.getDay() > previous.getDay())) {
            console.log(days.join('\n'));
            console.log(current, previous);
          }
          expect(current.getDay()).toBeGreaterThan(previous.getDay());
          return current;
        });
      });
  });

  it('returns unique values (depends on sorting)', () => {
    const MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;

    Array(365)
      .fill(0)
      .map((_, n) => n * MILLISECONDS_IN_DAY)
      .map((n) => new Date(n))
      .map((date) => getDaysInMonth(date))
      .forEach((days) => {
        // console.log(days);
        days.reduce((previous, current) => {
          // console.log(previous, current);
          expect(current.getDay()).not.toBe(previous.getDay());
          return current;
        });
      });
  });
});
