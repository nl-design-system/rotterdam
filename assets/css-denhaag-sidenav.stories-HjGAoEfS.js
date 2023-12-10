import{j as i}from"./jsx-runtime-vNq4Oc-g.js";import{R as c}from"./index-4g5l5LRQ.js";import{e as S}from"./index-ZVIeQLg0.js";/* empty css              */import{R as k,a as x,b as j,c as y,d as _,e as I,f as b,g as L}from"./components-Z9zf5nx1.js";import"./_commonjsHelpers-4gQjN7DL.js";import"./extends-dGVwEr9R.js";function R(e,a){a===void 0&&(a={});var r=a.insertAt;if(!(!e||typeof document>"u")){var n=document.head||document.getElementsByTagName("head")[0],d=document.createElement("style");d.type="text/css",r==="top"&&n.firstChild?n.insertBefore(d,n.firstChild):n.appendChild(d),d.styleSheet?d.styleSheet.cssText=e:d.appendChild(document.createTextNode(e))}}var w=".denhaag-sidenav{display:var(--denhaag-sidenav-display);flex-direction:var(--denhaag-sidenav-flex-direction);min-width:var(--denhaag-sidenav-min-width);row-gap:var(--denhaag-sidenav-row-gap)}@media (width <= 1023px){.denhaag-sidenav{display:var(--denhaag-sidenav-mobile-display)}}.denhaag-sidenav__list{list-style:none;margin-block-end:0;margin-block-start:0;padding-block-end:0;padding-block-start:0;padding-inline-start:0}.denhaag-sidenav__list--child{margin-inline-start:var(--denhaag-sidenav-list-child-margin-inline-start)}.denhaag-sidenav__item{font-family:var(--denhaag-sidenav-item-font-family,sans-serif);font-size:var(--denhaag-sidenav-item-font-size);font-weight:var(--denhaag-sidenav-item-font-weight,normal);line-height:1.5}.denhaag-sidenav__item,.denhaag-sidenav__link{align-items:center;display:flex;flex-direction:row}.denhaag-sidenav__link{color:var(--denhaag-sidenav-link-color);column-gap:16px;flex-grow:1;padding-block-end:var(--denhaag-sidenav-link-padding-block-end);padding-block-start:var(--denhaag-sidenav-link-padding-block-start);text-decoration:none}.denhaag-sidenav__link--hover,.denhaag-sidenav__link:hover{color:var(--denhaag-sidenav-link-hover-color);cursor:pointer}.denhaag-sidenav__link--focus,.denhaag-sidenav__link:focus-visible{outline:var(--denhaag-focus-border)}.denhaag-sidenav__link--current{color:var(--denhaag-sidenav-link-active-color);font-weight:var(--denhaag-sidenav-link-active-font-weight)}.denhaag-sidenav__link--child{padding-inline-start:var(--denhaag-sidenav-link-child-padding-inline-start)}";R(w);var o=function(){return o=Object.assign||function(a){for(var r,n=1,d=arguments.length;n<d;n++){r=arguments[n];for(var h in r)Object.prototype.hasOwnProperty.call(r,h)&&(a[h]=r[h])}return a},o.apply(this,arguments)};function O(e,a){var r={};for(var n in e)Object.prototype.hasOwnProperty.call(e,n)&&a.indexOf(n)<0&&(r[n]=e[n]);if(e!=null&&typeof Object.getOwnPropertySymbols=="function")for(var d=0,n=Object.getOwnPropertySymbols(e);d<n.length;d++)a.indexOf(n[d])<0&&Object.prototype.propertyIsEnumerable.call(e,n[d])&&(r[n[d]]=e[n[d]]);return r}function p(e){var a,r,n="";if(typeof e=="string"||typeof e=="number")n+=e;else if(typeof e=="object")if(Array.isArray(e))for(a=0;a<e.length;a++)e[a]&&(r=p(e[a]))&&(n&&(n+=" "),n+=r);else for(a in e)e[a]&&(n&&(n+=" "),n+=a);return n}function v(){for(var e,a,r=0,n="";r<arguments.length;)(e=arguments[r++])&&(a=p(e))&&(n&&(n+=" "),n+=a);return n}var C=function(e){var a=v("denhaag-sidenav",e.className);return c.createElement("nav",o({},e,{className:a}),e.children)},t=function(e){var a=v("denhaag-sidenav__item",e.className);return c.createElement("li",o({},e,{className:a}),e.children)},g=function(e){var a=v("denhaag-sidenav__list",e.className);return c.createElement("ul",o({},e,{className:a}),e.children)},s=function(e){var a=e.current,r=O(e,["current"]),n=v("denhaag-sidenav__link",a&&"denhaag-sidenav__link--current",r.className);return c.createElement("a",o({},r,{"aria-current":a||r["aria-current"]?"page":void 0,className:n}),r.children)};const N=`<!-- @license CC0-1.0 -->

# Side navigation
`,U={title:"CSS Component/Side navigation",id:"css-denhaag-sidenav",component:C,argTypes:{defaultValue:{name:"Content",type:{name:"string",required:!0},defaultValue:""}},args:{defaultValue:""},tags:["autodocs"],parameters:{design:{type:"figma",url:"https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=501-18760"},docs:{description:{component:N}}}},l={name:"Side navigation",args:{children:[i.jsxs(g,{children:[i.jsx(t,{children:i.jsxs(s,{current:!0,href:"/#",children:[i.jsx(k,{})," Overzicht"]})}),i.jsx(t,{children:i.jsxs(s,{href:"/#",children:[i.jsx(x,{}),"Mijn berichten",i.jsx(S,{children:"2"})]})}),i.jsx(t,{children:i.jsxs(s,{href:"/#",children:[i.jsx(j,{})," Mijn lopende zaken"]})}),i.jsx(t,{children:i.jsxs(s,{href:"/#",children:[i.jsx(y,{})," Zelf regelen"]})})]}),i.jsxs(g,{children:[i.jsx(t,{children:i.jsxs(s,{href:"/#",children:[i.jsx(_,{})," Belastingen"]})}),i.jsx(t,{children:i.jsxs(s,{href:"/#",children:[i.jsx(I,{})," Werk & Inkomen"]})}),i.jsx(t,{children:i.jsxs(s,{href:"/#",children:[i.jsx(b,{})," Parkeren"]})})]}),i.jsx(g,{children:i.jsx(t,{children:i.jsxs(s,{href:"/#",children:[i.jsx(L,{}),"Mijn gegevens"]})})})]}};var m,f,u;l.parameters={...l.parameters,docs:{...(m=l.parameters)==null?void 0:m.docs,source:{originalSource:`{
  name: 'Side navigation',
  args: {
    children: [<SidenavList>
        <SidenavItem>
          <SidenavLink current href="/#">
            <RodsIconOverview /> Overzicht
          </SidenavLink>
        </SidenavItem>
        <SidenavItem>
          <SidenavLink href="/#">
            <RodsIconInbox />
            Mijn berichten
            <BadgeCounter>2</BadgeCounter>
          </SidenavLink>
        </SidenavItem>
        <SidenavItem>
          <SidenavLink href="/#">
            <RodsIconBox /> Mijn lopende zaken
          </SidenavLink>
        </SidenavItem>
        <SidenavItem>
          <SidenavLink href="/#">
            <RodsIconSummary /> Zelf regelen
          </SidenavLink>
        </SidenavItem>
      </SidenavList>, <SidenavList>
        <SidenavItem>
          <SidenavLink href="/#">
            <RodsIconCoins /> Belastingen
          </SidenavLink>
        </SidenavItem>
        <SidenavItem>
          <SidenavLink href="/#">
            <RodsIconMoney2 /> Werk &amp; Inkomen
          </SidenavLink>
        </SidenavItem>
        <SidenavItem>
          <SidenavLink href="/#">
            <RodsIconParking /> Parkeren
          </SidenavLink>
        </SidenavItem>
      </SidenavList>, <SidenavList>
        <SidenavItem>
          <SidenavLink href="/#">
            <RodsIconUser />
            Mijn gegevens
          </SidenavLink>
        </SidenavItem>
      </SidenavList>]
  }
}`,...(u=(f=l.parameters)==null?void 0:f.docs)==null?void 0:u.source}}};const Z=["Default"];export{l as Default,Z as __namedExportsOrder,U as default};
