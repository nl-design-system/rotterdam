import{_ as f}from"./typeof-Q9eVcF_1.js";function a(r,t){if(f(r)!=="object"||r===null)return r;var n=r[Symbol.toPrimitive];if(n!==void 0){var e=n.call(r,t||"default");if(f(e)!=="object")return e;throw new TypeError("@@toPrimitive must return a primitive value.")}return(t==="string"?String:Number)(r)}function l(r){var t=a(r,"string");return f(t)==="symbol"?t:String(t)}function s(r,t,n){return t=l(t),t in r?Object.defineProperty(r,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):r[t]=n,r}function c(r,t){if(r==null)return{};var n={},e=Object.keys(r),i,o;for(o=0;o<e.length;o++)i=e[o],!(t.indexOf(i)>=0)&&(n[i]=r[i]);return n}function m(r,t){if(r==null)return{};var n=c(r,t),e,i;if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(r);for(i=0;i<o.length;i++)e=o[i],!(t.indexOf(e)>=0)&&Object.prototype.propertyIsEnumerable.call(r,e)&&(n[e]=r[e])}return n}function u(r){var t,n,e="";if(typeof r=="string"||typeof r=="number")e+=r;else if(typeof r=="object")if(Array.isArray(r))for(t=0;t<r.length;t++)r[t]&&(n=u(r[t]))&&(e&&(e+=" "),e+=n);else for(t in r)r[t]&&(e&&(e+=" "),e+=t);return e}function b(){for(var r,t,n=0,e="";n<arguments.length;)(r=arguments[n++])&&(t=u(r))&&(e&&(e+=" "),e+=t);return e}function g(r){if(r==null)throw new TypeError("Cannot destructure "+r)}export{m as _,s as a,g as b,b as c};
