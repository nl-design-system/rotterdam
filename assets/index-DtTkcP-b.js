import{R as d}from"./index-uCp2LrAq.js";var l=".denhaag-sidenav{display:var(--denhaag-sidenav-display);flex-direction:var(--denhaag-sidenav-flex-direction);min-width:var(--denhaag-sidenav-min-width);row-gap:var(--denhaag-sidenav-row-gap)}@media (width <= 1023px){.denhaag-sidenav{display:var(--denhaag-sidenav-mobile-display)}}.denhaag-sidenav__list{list-style:none;margin-block-end:0;margin-block-start:0;padding-block-end:0;padding-block-start:0;padding-inline-start:0}.denhaag-sidenav__item{font-family:var(--denhaag-sidenav-item-font-family,sans-serif);font-size:var(--denhaag-sidenav-item-font-size);font-weight:var(--denhaag-sidenav-item-font-weight,normal);line-height:1.5}.denhaag-sidenav__item,.denhaag-sidenav__link{align-items:center;display:flex;flex-direction:row}.denhaag-sidenav__link{color:var(--denhaag-sidenav-link-color);column-gap:16px;flex-grow:1;padding-block-end:var(--denhaag-sidenav-link-padding-block-end);padding-block-start:var(--denhaag-sidenav-link-padding-block-start);text-decoration:none}.denhaag-sidenav__link--hover,.denhaag-sidenav__link:hover{color:var(--denhaag-sidenav-link-hover-color);cursor:pointer}.denhaag-sidenav__link--focus,.denhaag-sidenav__link:focus-visible{outline:var(--denhaag-focus-border)}.denhaag-sidenav__link--current{color:var(--denhaag-sidenav-link-active-color);font-weight:var(--denhaag-sidenav-link-active-font-weight)}";if(typeof document<"u"){const e=document.head||document.getElementsByTagName("head")[0],a=document.createElement("style");a.type="text/css",a.nonce=window.NONCE,e.appendChild(a),a.styleSheet?a.styleSheet.cssText=l:a.appendChild(document.createTextNode(l))}var i=function(){return i=Object.assign||function(a){for(var r,n=1,t=arguments.length;n<t;n++){r=arguments[n];for(var o in r)Object.prototype.hasOwnProperty.call(r,o)&&(a[o]=r[o])}return a},i.apply(this,arguments)};function v(e,a){var r={};for(var n in e)Object.prototype.hasOwnProperty.call(e,n)&&a.indexOf(n)<0&&(r[n]=e[n]);if(e!=null&&typeof Object.getOwnPropertySymbols=="function")for(var t=0,n=Object.getOwnPropertySymbols(e);t<n.length;t++)a.indexOf(n[t])<0&&Object.prototype.propertyIsEnumerable.call(e,n[t])&&(r[n[t]]=e[n[t]]);return r}function c(e){var a,r,n="";if(typeof e=="string"||typeof e=="number")n+=e;else if(typeof e=="object")if(Array.isArray(e)){var t=e.length;for(a=0;a<t;a++)e[a]&&(r=c(e[a]))&&(n&&(n+=" "),n+=r)}else for(r in e)e[r]&&(n&&(n+=" "),n+=r);return n}function s(){for(var e,a,r=0,n="",t=arguments.length;r<t;r++)(e=arguments[r])&&(a=c(e))&&(n&&(n+=" "),n+=a);return n}var h=function(e){var a=s("denhaag-sidenav",e.className);return d.createElement("nav",i({},e,{className:a}),e.children)},f=function(e){var a=s("denhaag-sidenav__item",e.className);return d.createElement("li",i({},e,{className:a}),e.children)},u=function(e){var a=s("denhaag-sidenav__list",e.className);return d.createElement("ul",i({},e,{className:a}),e.children)},m=function(e){var a=e.current,r=v(e,["current"]),n=s("denhaag-sidenav__link",a&&"denhaag-sidenav__link--current",r.className);return d.createElement("a",i({},r,{"aria-current":a||r["aria-current"]?"page":void 0,className:n}),r.children)};export{h as S,u as a,f as b,m as c};
