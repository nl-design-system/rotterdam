/**
 * @license EUPL-1.2
 * Copyright (c) 2023 Rotterdam
 * Copyright (c) 2023 Frameless B.V.
 */

/* eslint-disable-next-line @typescript-eslint/no-unused-vars */
import { Component, h } from '@stencil/core';

@Component({
  tag: 'rods-logo-image',
  styleUrl: 'logo-image.scss',
  shadow: true,
})
export class LogoImage {
  render() {
    return (
      <svg version="1.1" viewBox="0 0 317 58" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path
          fill-rule="evenodd"
          clip-rule="evenodd"
          d="M166.6 23.8C162.9 27.7 157 31.3 149 31.5C139.5 31.8 134.5 31.2 122.8 26.1C125.1 22.9 126 19.7 126.1 16.1C126.3 11.2 124.1 7 119.7 4.3C115 1.4 112.1 0 112.1 0C114.4 1.3 115.9 4.6 116.5 8.9C117.3 14.7 115.8 21.8 109.1 26.2L117.9 41.7C111.3 41 106.8 44.5 106.8 44.5L115.3 51.7C115.3 51.7 122.5 47.1 133.9 49.4L120.1 30.3C130.5 36 146.8 39.5 146.8 39.5C146.8 39.5 140.8 39.6 135.9 38.2C134.4 37.8 133.1 38.2 135.1 39.3C135.6 39.6 141.8 42.7 147.7 43.4C158.3 44.5 162.3 40.4 163.2 39C164.173 37.4709 162.924 37.5843 160.225 37.8292L160.225 37.8292C159.041 37.9367 157.577 38.0695 155.9 38.1C150.4 38.1 144.9 36.4 142.5 35.1C151.7 35 168.6 33.3 169.2 27.8C169.3 26.4 168.3 24.5 166.6 23.8ZM32.2 4.3C29.1 11 33.3 13.4 40.3 13.4C42.9192 13.4 45.5385 12.5192 48.5787 11.4967C57.9582 8.34241 71.3447 3.84057 101.1 19.7C97.8 20.6 93.6 21.6 93.6 21.6C90.4 19.5 86.9 21.4 84.1 23.3C83.4902 23.6946 82.7067 24.3015 81.7899 25.0116C77.5948 28.2609 70.6086 33.6723 64.7 30.8C63.2 30 60.2 28.4 57.8 28.6C56.4563 28.6707 55.4628 29.1415 54.1473 29.7648C53.6026 30.0229 53.0028 30.3072 52.3 30.6C49.9 31.7 49.8 29.9 52.5 28C59.8 23 75.8 15.2 91.6 17.6C70.4 11 63.6 12.1 41.6 21.3C40.8 21.7 39.9 22 39 22.3C40 23.8 43.2 25 47.7 23.7C47.8299 23.6567 47.9821 23.6028 48.1522 23.5426L48.1523 23.5426L48.1527 23.5425L48.1533 23.5423L48.1535 23.5422C49.5552 23.0461 52.1736 22.1194 53.6 23.1C53.6 23.1 47.1 27.3 41.5 27.9C31.4 29 18.2 24.8 14.2 20.4C12.8 18.8 12.8 17.4 14.4 17.8L14.4601 17.8134C15.5465 18.0553 21.5857 19.4 25.8 19.4C28.7 19.4 30.9 19.2 32.7 18.8C13.7 11.7 27.6 4.6 32 3.3C33 3 32.5 4 32.2 4.3ZM207.4 13.2H198.6V16.3H203.8V16.7C203.8 17.6 203.6 18.3 203.2 18.9C202.8 19.5 202.3 19.9 201.7 20.2C201.1 20.5 200.4 20.6 199.8 20.6C198.2 20.6 196.9 20 196 18.9C195.1 17.8 194.6 16.2 194.6 14.2C194.6 12.9 194.9 11.7 195.3 10.8C195.7 9.9 196.4 9.2 197.2 8.7C198 8.2 198.9 8 199.9 8C200.8 8 201.6 8.1 202.4 8.5C203.2 8.9 204 9.4 204.8 10.1L207.1 7.7C206.1 6.7 205 6 203.8 5.5C202.6 5 201.2 4.8 199.7 4.8C197.9 4.8 196.4 5.2 195 6C193.6 6.8 192.5 8 191.8 9.4C191.1 10.9 190.7 12.5 190.7 14.3C190.7 16.1 191.1 17.8 191.7 19.2C192.3 20.7 193.3 21.8 194.5 22.6C195.8 23.4 197.3 23.8 199 23.8C200 23.8 201 23.6 201.9 23.2C202.8 22.8 203.6 22.2 204.2 21.3V23.4H207.4V13.2ZM213.1 17.9H222.6V16.3C222.6 15 222.3 13.8 221.8 12.8C221.3 11.8 220.6 11 219.6 10.5C218.6 10 217.5 9.7 216.2 9.7C214.9 9.7 213.7 10 212.7 10.6C211.7 11.2 210.9 12 210.4 13.1C209.9 14.2 209.6 15.4 209.6 16.8C209.6 18.1 209.9 19.3 210.5 20.4C211.1 21.5 211.9 22.3 212.9 22.9C213.9 23.5 215.1 23.8 216.5 23.8C218.6 23.8 220.5 23.1 222 21.7L220.3 19.4C219.7 19.9 219.1 20.3 218.5 20.5C217.9 20.7 217.3 20.8 216.6 20.8C215.7 20.8 214.9 20.5 214.3 20C213.7 19.5 213.3 18.8 213.1 17.9ZM213.2 15.3C213.4 14.4 213.8 13.7 214.3 13.2C214.8 12.7 215.5 12.4 216.2 12.4C217 12.4 217.7 12.7 218.2 13.2C218.7 13.7 219 14.4 219.1 15.3H213.2ZM243.3 10.9C244.1 11.7 244.5 12.8 244.5 14.1V23.3H240.9V15.2C240.9 14.5 240.7 13.9 240.3 13.5C239.9 13.1 239.4 12.8 238.7 12.8C238 12.8 237.5 13 237.1 13.5C236.7 14 236.5 14.6 236.5 15.3V23.3H232.9V15.2C232.9 14.5 232.7 13.9 232.4 13.5C232 13.1 231.5 12.8 230.8 12.8C230.1 12.8 229.5 13.1 229.1 13.6C228.7 14.1 228.5 14.8 228.5 15.6V23.4H224.9V10.1H228.2V12C228.6 11.3 229.1 10.7 229.8 10.3C230.5 9.90001 231.3 9.7 232.2 9.7C233.1 9.7 233.9 9.90001 234.5 10.3C235.2 10.7 235.7 11.2 236 11.9C236.4 11.2 237 10.7 237.7 10.3C238.4 9.90001 239.2 9.7 240 9.7C241.4 9.7 242.5 10.1 243.3 10.9ZM250.2 17.9H259.7V16.3C259.7 15 259.4 13.8 258.9 12.8C258.4 11.8 257.7 11 256.7 10.5C255.7 10 254.6 9.7 253.3 9.7C252 9.7 250.8 10 249.8 10.6C248.8 11.2 248 12 247.5 13.1C247 14.2 246.7 15.4 246.7 16.8C246.7 18.1 247 19.3 247.6 20.4C248.2 21.5 249 22.3 250 22.9C251 23.5 252.2 23.8 253.6 23.8C255.7 23.8 257.6 23.1 259.1 21.7L257.4 19.4C256.8 19.9 256.2 20.3 255.6 20.5C255 20.7 254.4 20.8 253.7 20.8C252.8 20.8 252 20.5 251.4 20C250.8 19.5 250.4 18.8 250.2 17.9ZM250.2 15.3C250.4 14.4 250.8 13.7 251.3 13.2C251.8 12.7 252.5 12.4 253.2 12.4C254 12.4 254.7 12.7 255.2 13.2C255.7 13.7 256 14.4 256.1 15.3H250.2ZM274.1 17.9H264.6C264.8 18.8 265.2 19.5 265.8 20C266.4 20.5 267.2 20.8 268.1 20.8C268.8 20.8 269.4 20.7 270 20.5C270.6 20.3 271.2 19.9 271.8 19.4L273.5 21.7C272 23.1 270.1 23.8 268 23.8C266.6 23.8 265.4 23.5 264.4 22.9C263.4 22.3 262.6 21.5 262 20.4C261.4 19.3 261.1 18.1 261.1 16.8C261.1 15.4 261.4 14.2 261.9 13.1C262.4 12 263.2 11.2 264.2 10.6C265.2 10 266.4 9.7 267.7 9.7C269 9.7 270.1 10 271.1 10.5C272.1 11 272.8 11.8 273.3 12.8C273.8 13.8 274.1 15 274.1 16.3V17.9ZM265.7 13.2C265.2 13.7 264.8 14.4 264.6 15.3H270.5C270.4 14.4 270.1 13.7 269.6 13.2C269.1 12.7 268.4 12.4 267.6 12.4C266.9 12.4 266.3 12.7 265.7 13.2ZM288.2 14.4C288.2 13 287.8 11.9 287 11C286.2 10.1 285.1 9.70001 283.6 9.60001C282.7 9.60001 281.8 9.90001 281.1 10.3C280.4 10.7 279.8 11.3 279.5 12V10.1H276.2V23.5H279.8V15.9C279.8 14.9 280 14.2 280.5 13.7C281 13.2 281.6 12.9 282.3 12.9C283 12.9 283.6 13.1 284 13.5C284.4 13.9 284.6 14.5 284.6 15.4V23.4H288.2V14.4ZM292 13H289.7V10.2H292V7.10001L295.6 5.10001V10.1H298.3V13H295.6V19.4C295.6 19.8 295.7 20.2 296 20.4C296.2 20.6 296.7 20.7 297.3 20.7C297.8 20.7 298.2 20.7 298.6 20.6V23.4C297.9 23.6 297.1 23.7 296.1 23.7C294.6 23.7 293.6 23.4 293 22.8C292.4 22.2 292.1 21.3 292.1 20.1V13H292ZM302.9 17.9H312.4V16.3C312.4 15 312.1 13.8 311.6 12.8C311.1 11.8 310.4 11 309.4 10.5C308.4 10 307.3 9.7 306 9.7C304.7 9.7 303.5 10 302.5 10.6C301.5 11.2 300.7 12 300.2 13.1C299.7 14.2 299.4 15.4 299.4 16.8C299.4 18.1 299.7 19.3 300.3 20.4C300.9 21.5 301.7 22.3 302.7 22.9C303.7 23.5 304.9 23.8 306.3 23.8C308.4 23.8 310.3 23.1 311.8 21.7L310.1 19.4C309.5 19.9 308.9 20.3 308.3 20.5C307.7 20.7 307.1 20.8 306.4 20.8C305.5 20.8 304.7 20.5 304.1 20C303.5 19.5 303.1 18.8 302.9 17.9ZM303 15.3C303.2 14.4 303.6 13.7 304.1 13.2C304.6 12.7 305.3 12.4 306 12.4C306.8 12.4 307.5 12.7 308 13.2C308.5 13.7 308.8 14.4 308.9 15.3H303ZM206.9 48.7H202.8L198.5 42H195.6V48.7H192V30.4H200.6C201.7 30.4 202.7 30.6 203.5 31.1C204.4 31.6 205.1 32.3 205.6 33.2C206.1 34.1 206.3 35.1 206.3 36.2C206.3 37.6 205.9 38.7 205.2 39.7C204.5 40.7 203.5 41.3 202.3 41.7L206.9 48.7ZM195.6 33.5V38.9H199.9C200.7 38.9 201.4 38.7 201.9 38.2C202.4 37.7 202.7 37.1 202.7 36.2C202.7 35.3 202.4 34.7 201.9 34.2C201.4 33.7 200.7 33.5 199.9 33.5H195.6ZM208.5 45.7C209.1 46.8 209.9 47.6 210.9 48.2C211.9 48.8 213.1 49.1 214.4 49.1C215.7 49.1 216.9 48.8 217.9 48.2C218.9 47.6 219.7 46.8 220.3 45.7C220.9 44.6 221.2 43.4 221.2 42C221.2 40.6 220.9 39.4 220.3 38.3C219.7 37.3 218.9 36.5 217.9 35.9C216.9 35.3 215.7 35 214.4 35C213.1 35 211.9 35.3 210.9 35.9C209.9 36.4 209.1 37.2 208.5 38.3C207.9 39.4 207.6 40.6 207.6 42C207.6 43.4 207.9 44.6 208.5 45.7ZM217.5 42C217.5 43.3 217.2 44.3 216.6 45C216.1 45.7 215.3 46.1 214.4 46.1C213.5 46.1 212.8 45.7 212.2 45C211.6 44.2 211.3 43.3 211.3 42C211.3 40.7 211.6 39.7 212.2 39C212.7 38.3 213.5 37.9 214.4 37.9C215.3 37.9 216 38.3 216.6 39C217.2 39.8 217.5 40.7 217.5 42ZM224.3 38.3H222V35.5H224.3V32.4L227.9 30.4V35.4H230.6V38.2H227.9V44.6C227.9 45 228 45.4 228.3 45.6C228.5 45.8 229 45.9 229.6 45.9C230.1 45.9 230.5 45.9 230.9 45.8V48.6C230.2 48.8 229.4 48.9 228.4 48.9C226.9 48.9 225.9 48.6 225.3 48C224.7 47.4 224.4 46.5 224.4 45.3V38.3H224.3ZM231.9 38.3H234.2H234.3V45.3C234.3 46.5 234.6 47.4 235.2 48C235.8 48.6 236.8 48.9 238.3 48.9C239.3 48.9 240.1 48.8 240.8 48.6V45.8C240.4 45.9 240 45.9 239.5 45.9C238.9 45.9 238.4 45.8 238.2 45.6C237.9 45.4 237.8 45 237.8 44.6V38.2H240.5V35.4H237.8V30.4L234.2 32.4V35.5H231.9V38.3ZM254.6 43.2H245.1C245.3 44.1 245.7 44.8 246.3 45.3C246.9 45.8 247.7 46.1 248.6 46.1C249.3 46.1 249.9 46 250.5 45.8C251.1 45.6 251.7 45.2 252.3 44.7L254 47C252.5 48.4 250.6 49.1 248.5 49.1C247.1 49.1 245.9 48.8 244.9 48.2C243.9 47.6 243.1 46.8 242.5 45.7C241.9 44.6 241.6 43.4 241.6 42.1C241.6 40.7 241.9 39.5 242.4 38.4C242.9 37.3 243.7 36.5 244.7 35.9C245.7 35.3 246.9 35 248.2 35C249.5 35 250.6 35.3 251.6 35.8C252.6 36.3 253.3 37.1 253.8 38.1C254.3 39.1 254.6 40.3 254.6 41.6V43.2ZM246.2 38.5C245.7 39 245.3 39.7 245.1 40.6H251C250.9 39.7 250.6 39 250.1 38.5C249.6 38 248.9 37.7 248.1 37.7C247.4 37.8 246.8 38 246.2 38.5ZM265.3 38.8V35.4C264.9 35.3 264.5 35.3 263.9 35.3C263 35.3 262.2 35.6 261.5 36.1C260.8 36.6 260.4 37.2 260.1 38.1V35.5H256.8V48.7H260.4V43.4C260.4 41.9 260.7 40.7 261.4 39.9C262 39.1 262.9 38.7 264 38.7C264.5 38.7 264.9 38.7 265.3 38.8ZM275.6 29.8H279.2V48.7H275.9V46.8C275.1 48.3 273.7 49.1 271.8 49.1C270.7 49.1 269.7 48.8 268.8 48.2C267.9 47.6 267.2 46.8 266.7 45.7C266.2 44.6 266 43.4 266 42C266 40.6 266.2 39.4 266.7 38.3C267.2 37.2 267.9 36.4 268.8 35.9C269.7 35.4 270.7 35 271.8 35C273.5 35 274.7 35.6 275.6 36.9V29.8ZM274.8 45C275.4 44.3 275.7 43.3 275.7 42C275.7 40.7 275.4 39.8 274.8 39.1C274.2 38.4 273.5 38 272.6 38C271.7 38 270.9 38.4 270.4 39.1C269.8 39.8 269.6 40.8 269.6 42.1C269.6 43.3 269.9 44.3 270.4 45.1C271 45.8 271.7 46.2 272.6 46.2C273.5 46.1 274.3 45.8 274.8 45ZM295.1 45.9H293.4V39.4C293.4 36.5 291.6 35 288 35C286.7 35 285.6 35.2 284.5 35.6C283.4 35.9 282.5 36.4 281.8 37L283.5 39.3C284 38.9 284.7 38.6 285.4 38.3C286.1 38 286.9 37.9 287.6 37.9C288.4 37.9 289.1 38.1 289.4 38.4C289.7 38.8 289.9 39.3 289.9 39.9V40.2L286.9 40.8C285.3 41.1 284 41.6 283 42.3C282.1 43 281.6 44 281.6 45.3C281.6 46.5 282 47.5 282.9 48.2C283.8 48.9 284.9 49.2 286.2 49.2C287.2 49.2 288.1 48.9 288.8 48.5C289.5 48.1 290.1 47.5 290.4 46.8V48.7H295.1V45.9ZM289.8 43.9C289.8 44.7 289.6 45.3 289 45.7C288.4 46.2 287.8 46.4 287.1 46.3C286.5 46.3 286 46.2 285.6 45.9C285.2 45.7 285 45.3 285 44.9C285 44.4 285.2 44 285.6 43.8C286.1 43.6 286.7 43.4 287.6 43.2L289.8 42.7V43.9ZM315.4 36.2C316.2 37 316.6 38.1 316.6 39.4V48.6H313V40.5C313 39.8 312.8 39.2 312.4 38.8C312 38.4 311.5 38.1 310.8 38.1C310.1 38.1 309.6 38.3 309.2 38.8C308.8 39.3 308.6 39.9 308.6 40.6V48.6H305V40.5C305 39.8 304.8 39.2 304.5 38.8C304.1 38.4 303.6 38.1 302.9 38.1C302.2 38.1 301.6 38.4 301.2 38.9C300.8 39.4 300.6 40.1 300.6 40.9V48.7H297V35.5H300.3V37.4C300.7 36.7 301.2 36.1 301.9 35.7C302.6 35.3 303.4 35.1 304.3 35.1C305.2 35.1 306 35.3 306.6 35.7C307.3 36.1 307.8 36.6 308.1 37.3C308.5 36.6 309.1 36.1 309.8 35.7C310.5 35.3 311.3 35.1 312.1 35.1C313.6 35 314.6 35.4 315.4 36.2ZM93.6 31L99.4 29.6L102.7 36.3V54.3C102.7 54.3 98.8 58.1 92.6 56.8L84.1 49.6C89.3 50.9 93.6 47.6 93.6 47.6V31ZM106.4 16.3C107 14.9 107.2 13.1 107 11.4C106.9 10.7 106.7 10 106.5 9.3C105.431 6.67635 102.568 7.26313 101.948 7.39017L101.9 7.4L93.6 9.4C93.6 9.4 88.1 5.4 84.1 3.8C82.1 3 81 2.7 79 2.5C75.6 2.2 72.9 5.4 76.1 5.7C82.8 6.3 93.9 12.1 105.1 18.2C105.361 18.0258 105.547 17.7759 105.788 17.45L105.788 17.45C105.824 17.4017 105.861 17.3517 105.9 17.3C105.971 17.1583 106.042 17.0292 106.108 16.9082L106.108 16.9081C106.229 16.6874 106.335 16.4937 106.4 16.3ZM0.699967 11.4C-1.20003 9.5 1.29997 6.9 4.49997 8.9C6.39997 10 7.39997 11.5 8.49997 14.1C9.11021 15.5917 8.75497 15.3364 7.9642 14.7679C7.58874 14.498 7.11508 14.1576 6.59997 13.9C4.77426 13.0105 3.71556 12.7785 2.94171 12.609C2.06249 12.4163 1.55096 12.3042 0.699967 11.4Z"
          fill="var(--rods-logo-image-color, #00811F)"
        />
      </svg>
    );
  }
}
