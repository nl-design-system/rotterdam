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

export const dayOfWeekLocale = (n: Day) => {
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

export const isSameMonth = (a: Date, b: Date) => a.getFullYear() === b.getFullYear() && a.getMonth() === b.getMonth();
export const isSameDate = (a: Date, b: Date) => isSameMonth(a, b) && a.getDate() === b.getDate();

export const numberSort = (a: number, b: number) => (a === b ? 0 : a > b ? 1 : -1);
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

export const getNextMonth = (date: Date): Date => getRelativeMonth(date, 1);

export const getPrevMonth = (date: Date): Date => getRelativeMonth(date, -1);

export const getStartOfMonth = (date: Date) =>
  new Date(date.getFullYear(), date.getMonth(), date.getDate(), 0, 0, 0, 0);
export const getEndOfMonth = (date: Date) =>
  // Return the first moment in the next month, minus one millisecond
  new Date(date.getFullYear(), date.getMonth() + 1, date.getDate(), 0, 0, 0, -1);

export const isBeforeMonth = (month: Date, date: Date): boolean => date.getTime() < getStartOfMonth(month).getTime();
export const isAfterMonth = (month: Date, date: Date): boolean => date.getTime() > getEndOfMonth(month).getTime();

export const getMinDate = (dateA: Date, dateB: Date) => {
  const a = dateA.getTime();
  const b = dateB.getTime();
  return a < b ? dateA : dateB;
};

export const getMaxDate = (dateA: Date, dateB: Date) => {
  const a = dateA.getTime();
  const b = dateB.getTime();
  return a > b ? dateA : dateB;
};
