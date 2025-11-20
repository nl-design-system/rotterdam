import type { ThemeVars } from 'storybook/theming';
import { create } from 'storybook/theming/create';

const rodsColorBaseWhite = '#ffffff'; // Base/White
const rodsColorBaseGreen = '#00811F'; // Base/Green
const rodsColorBaseMagenta = '#C93675'; // Base/Magenta
const rodsColorGrayTint01 = '#EFF4F6'; // Gray/Tint 01
const rodsColorGrayTint03 = '#DBE7EA'; // Gray/Tint 03
const rodsColorGrayTint08 = '#7C8B90'; // Gray/Tint 08
const rodsColorGrayTint11 = '#404B4F'; // Gray/Tint 11
const rodsColorNotificationNeutralIconColor = '#00689E';

export const theme: ThemeVars = create({
  appBg: rodsColorGrayTint01,
  appBorderRadius: 0,
  barBg: rodsColorGrayTint03,
  barSelectedColor: rodsColorNotificationNeutralIconColor,
  barTextColor: rodsColorGrayTint11,
  base: 'light',
  brandImage: 'logo.svg',
  brandTitle: 'Gemeente Rotterdam',
  brandUrl: 'https://www.rotterdam.nl/',
  colorPrimary: rodsColorBaseMagenta,
  colorSecondary: rodsColorBaseGreen,
  fontBase: '"Arial", sans-serif',
  fontCode: 'monospace',
  inputBg: rodsColorBaseWhite,
  inputBorder: rodsColorGrayTint08,
  inputBorderRadius: 0,
  inputTextColor: rodsColorGrayTint11,
  textColor: rodsColorGrayTint11,
  textInverseColor: rodsColorBaseWhite,
});
