import { describe, expect, it } from 'vitest';
import './date-picker-utils';
import {
  getDaysInMonth,
  getEndOfMonth,
  getMaxDate,
  getMinDate,
  getNextMonth,
  getPrevMonth,
  getStartOfMonth,
  isAfterCurrentMonth,
  isBeforeCurrentMonth,
} from './date-picker-utils';

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

describe.only('isBeforeCurrentMonth', () => {
  it('works', () => {
    expect(isBeforeCurrentMonth(new Date('2026-01-01Z'), new Date('2026-01-01Z'))).toBe(false);
    expect(isBeforeCurrentMonth(new Date('2026-01-01Z'), new Date('2025-12-31T23:59:59.999Z'))).toBe(true);
  });
});

describe.only('isAfterCurrentMonth', () => {
  it('works', () => {
    expect(isAfterCurrentMonth(new Date('2026-01-01Z'), new Date('2026-01-01Z'))).toBe(false);
    expect(isAfterCurrentMonth(new Date('2025-12-31T23:59:59.999Z'), new Date('2026-01-01Z'))).toBe(true);
  });
});

// describe('getStartOfMonth', () => {
//   it('returns a date in the same month', () => {
//     expect(getStartOfMonth(new Date('2026-01-01Z')).toISOString()).toBe('2026-01-01T00:00:00.000Z');
//     expect(getStartOfMonth(new Date('2026-03-31Z')).toISOString()).toBe('2026-03-01T01:00:00.000Z'); // FIXME 01:00?
//     expect(getStartOfMonth(new Date('2026-03-31T23:59:59Z')).toISOString()).toBe('2026-03-01T01:00:00.000Z'); // FIXME 01:00?
//   });
// });

// describe.only('getEndOfMonth', () => {
//   it('returns a date in the same month', () => {
//     // expect(getEndOfMonth(new Date('2026-01-01Z')).toISOString()).toBe('2026-01-01T00:00:00.000Z');
//     // expect(getEndOfMonth(new Date('2026-03-31Z')).toISOString()).toBe('2026-03-01T01:00:00.000Z'); // FIXME 01:00?
//     expect(getEndOfMonth(new Date('2026-03-31T23:59:59Z')).toISOString()).toBe('2026-03-31T23:59:59.999Z'); // FIXME 01:00?
//   });
// });

describe('getPrevMonth', () => {
  it('returns a date in the previous month', () => {
    expect(getPrevMonth(new Date('2026-01-01Z')).toISOString()).toBe('2025-12-01T00:00:00.000Z');
    expect(getPrevMonth(new Date('2026-03-31Z')).toISOString()).toBe('2025-02-01T00:00:00.000Z');
    expect(getPrevMonth(new Date('2026-03-31T23:59:59Z')).toISOString()).toBe('2025-02-01T00:00:00.000Z');
  });
});

// describe('getNextMonth', () => {
//   it('returns a date in the next month', () => {
//     expect(getNextMonth(new Date('2026-01-01Z')).toISOString()).toBe('2026-02-01T00:00:00.000Z');
//   });
// });

describe('getMinDate', () => {
  const a = new Date('2025-12-31Z');
  const b = new Date('2026-01-01Z');
  const c = new Date('2025-12-31Z');

  it('returns min value', () => {
    expect(getMinDate(a, b)).toBe(a);
    expect(getMinDate(b, a)).toBe(a);
  });

  it('returns first value when the are same', () => {
    expect(getMinDate(a, c)).toBe(a);
  });
});

describe('getMaxDate', () => {
  const a = new Date('2025-12-31');
  const b = new Date('2026-01-01');
  const c = new Date('2025-12-31');

  it('returns max value', () => {
    expect(getMaxDate(a, b)).toBe(b);
    expect(getMaxDate(b, a)).toBe(b);
  });

  it('returns first value when the are same', () => {
    expect(getMaxDate(a, c)).toBe(a);
  });
});
