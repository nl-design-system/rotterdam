/**
 * @license EUPL-1.2
 * Copyright (c) 2023 Rotterdam
 * Copyright (c) 2023 Frameless B.V.
 */

/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import { Component, h } from '@stencil/core';

@Component({
  tag: 'rods-logo-image-avatar',
  styleUrl: 'logo-image.scss',
  shadow: true,
})
export class LogoImageAvatar {
  render() {
    return (
      <svg version="1.1" viewBox="0 0 50 58" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path
          fill-rule="evenodd"
          clip-rule="evenodd"
          d="M38.6 26.1C40.9 22.9 41.8 19.7 41.9 16.1C42.1 11.2 39.9 7 35.5 4.3C30.8 1.4 28 0 28 0C30.3 1.3 31.8 4.6 32.4 8.9C33.2 14.7 31.7 21.8 25 26.2L33.8 41.7C27.2 41 22.7 44.5 22.7 44.5L31.2 51.7C31.2 51.7 38.4 47.1 49.8 49.4L35.5 29.9C36.8 28.5 37.6 27.5 38.6 26.1ZM9.5 31V47.6C9.5 47.6 5.2 50.9 0 49.6L8.5 56.8C14.7 58.1 18.6 54.3 18.6 54.3V36.3L15.3 29.6L9.5 31ZM17.9344 19.4172C17.6375 19.5063 17.325 19.6 17 19.7C16.9657 19.7086 16.8821 19.7296 16.758 19.7609C15.4346 20.0947 9.5 21.5914 9.5 21.5V9.2L17.8 7.2C18.1 7.1 19.4 6.8 20.6 7.3C20.6472 7.32361 20.7 7.34721 20.7557 7.37214C20.9361 7.45279 21.1472 7.54721 21.3 7.7L21.6 8C21.7 8.1 21.8 8.225 21.9 8.34999C22 8.475 22.1 8.6 22.2 8.7C22.25 8.8 22.275 8.875 22.3 8.95C22.325 9.025 22.35 9.1 22.4 9.2C22.4 9.43739 22.4626 9.61216 22.5383 9.82341C22.5583 9.87913 22.5791 9.93739 22.6 10C22.6 10.1 22.625 10.175 22.65 10.25C22.675 10.325 22.7 10.4 22.7 10.5C22.8 10.7 22.9 11 22.9 11.3C23.1 13 22.9 14.8 22.3 16.2C22 17 21.5 17.6 21 18.1C20.7 18.4 20.4 18.6 20.1 18.7C19.575 18.925 18.825 19.15 17.9344 19.4172Z"
          fill="var(--rods-logo-image-color, #00811F)"
        />
      </svg>
    );
  }
}
