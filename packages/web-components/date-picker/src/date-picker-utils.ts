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
