import { endOfMonth } from 'date-fns/endOfMonth';
import { startOfMonth } from 'date-fns/startOfMonth';
/* date-fns `Day` type */
export enum Day {
  SUNDAY = 0,
  MONDAY = 1,
  TUESDAY = 2,
  WEDNESDAY = 3,
  THURSDAY = 4,
  FRIDAY = 5,
  SATURDAY = 6,
}

/**
 * State of the dates can be displayed.
 * It could be used to store dates that need to be selectable, because have time slots associated with them.
 * It could also be used store all visible dates in a UI component, wether they have a date ssociated with them, or not.
 */
export interface DateOption {
  date: Date;
  label?: string;
  today?: boolean;
  selected?: boolean;
  readOnly?: boolean;
  disabled?: boolean;
  emphasis?: boolean;
  hidden?: boolean;
}

/**
 * State of a time slot that can be displayed.
 */
export interface TimeOption {
  date: Date;
  label?: string;
  today?: boolean;
  selected?: boolean;
}

/**
 * Give a `Date` for every day in the specified month.
 * Dates are sorted from first to last day.
 */
export const getDaysInMonth = (date: Date) => {
  const dates = [];
  const month = date.getMonth();
  const anotherDay = new Date(date);
  for (let i = 1; i < 32; i++) {
    // Start with the first day in the month,
    // then test every next day.
    anotherDay.setDate(i);
    // The number of days in each month vary.
    // Detect when the date is part of the next month,
    // and stop looking.
    if (anotherDay.getMonth() === month) {
      dates.push(new Date(anotherDay));
    } else {
      break;
    }
  }
  return dates;
};

export const dayOfWeekLocale = (n: Day): string => {
  const labels = ['zo', 'ma', 'di', 'wo', 'do', 'vr', 'za'];
  return labels[n];
};

export const monthLocale = (n: number) => {
  const labels = [
    'januari',
    'februari',
    'maart',
    'april',
    'mei',
    'juni',
    'juli',
    'augustus',
    'september',
    'oktober',
    'november',
    'december',
  ];
  return labels[n];
};

/**
 * Check if two dates fall into the same month of the same year.
 */
export const isSameMonth = (a: Date, b: Date) => a.getFullYear() === b.getFullYear() && a.getMonth() === b.getMonth();

/**
 * Check if two dates fall into the same day of the same month of the same year.
 */
export const isSameDate = (a: Date, b: Date) => isSameMonth(a, b) && a.getDate() === b.getDate();

/**
 * Comparison function for `Array.prototype.sort`.
 * Example usage:
 *
 *     arr = [6, 4, 3, 9];
 *     arr.sort();
 *
 * `arr` is now `[3, 4, 6, 9]`
 */
export const numberSort = (a: number, b: number) => (a === b ? 0 : a > b ? 1 : -1);

/**
 * Comparison function for `Array.prototype.sort`.
 * Example usage:
 *
 *     arr = [new Date("2026-01-01"), new Date("2024-01-01"), new Date("2023-01-01"), new Date("2029-01-01")];
 *     arr.sort();
 *
 * `arr` is now `[new Date("2023-01-01"), new Date("2024-01-01"), new Date("2026-01-01"), new Date("2029-01-01")];`
 */
export const sortDate = (a: Date, b: Date) => numberSort(a.getTime(), b.getTime());

export const getDatesBetween = (from: Date, to: Date) => {
  if (from.getTime() > to.getTime()) {
    return [];
    // prevent infinite loop
    // throw new TypeError();
  }
  const fromDate = from.getDate();
  const dates = [];
  const currentDate = new Date(from);
  for (let day = 1; day; day++) {
    currentDate.setDate(fromDate + day);
    if (currentDate.getTime() >= to.getTime()) {
      break;
    }
    dates.push(new Date(currentDate));
  }
  return dates;
};

export const getRelativeMonth = (date: Date, offset: number): Date => {
  const next = new Date(date.getTime());
  next.setMonth(next.getMonth() + offset);
  return next;
};

/**
 * Get the first millisecond of the month.
 */
// export const getStartOfMonth = (date: Date) => {
//   // return new Date(date.getFullYear(), date.getMonth(), 1, 0, -date.getTimezoneOffset(), 0, 0);
//   return new Date(date.toISOString().replace(/^(\d+-\d+-)(.+)/, '$101T00:00:00.000Z'));
// };
export const getStartOfMonth = startOfMonth;

// export const getEndOfMonth = endOfMonth;
export const getEndOfMonth = endOfMonth;
// /**
//  * Get the last millisecond of the month.
//  */
// export const getEndOfMonth = (date: Date): Date => {
//   console.log(date.toISOString().replace(/^(\d+-\d+-\d+)(.+)/, '$1T23:59:59.999Z'));
//   console.log(
//     date.toISOString(),
//     date.toISOString().replace(/^(\d+-\d+-\d+)(.+)/, '$1T23:59:59.999Z'),
//     new Date(date.toISOString().replace(/^(\d+-\d+-\d+)(.+)/, '$1T23:59:59:59.999Z')),
//   );
//   // Return the first moment in the next month, minus one millisecond
//   // return new Date(date.getFullYear(), date.getMonth() + 1, 1, 0, -date.getTimezoneOffset(), 0, -1);
//   return new Date(date.toISOString().replace(/^(\d+-\d+-\d+)(.+)/, '$1T23:59:59:59.999Z'));
// };

/**
 * Get a date that falls in the month following the current month.
 */
export const getNextMonth = (date: Date): Date => getRelativeMonth(getStartOfMonth(date), 1);

/**
 * Get a date that falls in the month before the current month.
 */
export const getPrevMonth = (date: Date): Date => getRelativeMonth(getStartOfMonth(date), -1);

/**
 * Returns `true` when specified `date` is not in the same month, and the date precedes the current date.
 */
export const isBeforeCurrentMonth = (month: Date, date: Date): boolean =>
  date.getTime() < getStartOfMonth(month).getTime();

/**
 * Returns `true` when specified `date` is not in the same month, and the date follows the current date.
 */
export const isAfterCurrentMonth = (currentMonth: Date, date: Date): boolean =>
  date.getTime() > getEndOfMonth(currentMonth).getTime();

/**
 * Get the first date of the two.
 */
export const getMinDate = (dateA: Date, dateB: Date) => {
  const a = dateA.getTime();
  const b = dateB.getTime();
  return a === b ? dateA : a < b ? dateA : dateB;
};

/**
 * Get the latest date of the two.
 */
export const getMaxDate = (dateA: Date, dateB: Date) => {
  const a = dateA.getTime();
  const b = dateB.getTime();
  return a === b ? dateA : a > b ? dateA : dateB;
};
