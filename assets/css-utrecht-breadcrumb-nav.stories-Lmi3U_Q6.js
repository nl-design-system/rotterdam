import{j as e}from"./jsx-runtime-vNq4Oc-g.js";import{b as m,c as a,d as n}from"./index-SXvxh14N.js";import{l as t}from"./components-FKruSZ7i.js";import"./index-4g5l5LRQ.js";import"./_commonjsHelpers-4gQjN7DL.js";import"./objectDestructuringEmpty-GZ-hTwpl.js";import"./extends-dGVwEr9R.js";const s=`<!-- @license CC0-1.0 -->

# Breadcrumb navigation
`,b={title:"CSS Component/Breadcrumb navigation",id:"css-utrecht-breadcrumb-nav",component:m,argTypes:{children:{name:"Content",type:{name:"string",required:!0},defaultValue:""}},args:{children:""},tags:["autodocs"],parameters:{design:{type:"figma",url:"https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=501-18760"},docs:{description:{component:s}}}},r={name:"Breadcrumb navigation",args:{children:[e.jsx(a,{href:"/",rel:"home",index:0,children:"Home"}),e.jsx(n,{children:e.jsx(t,{})}),e.jsx(a,{href:"/a/",index:1,children:"Parkeren in Rotterdam"}),e.jsx(n,{children:e.jsx(t,{})}),e.jsx(a,{href:"/a/b/",rel:"up",index:2,disabled:!0,current:!0,children:"Product aanvragen"})]},parameters:{design:{type:"figma",url:"https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=507-20062&mode=design&t=yvzUSkFQYQmWSHsQ-4"}}};var i,o,d;r.parameters={...r.parameters,docs:{...(i=r.parameters)==null?void 0:i.docs,source:{originalSource:`{
  name: 'Breadcrumb navigation',
  args: {
    children: [<BreadcrumbNavLink href="/" rel="home" index={0}>
        Home
      </BreadcrumbNavLink>, <BreadcrumbNavSeparator>
        <RodsIconChevronRight />
      </BreadcrumbNavSeparator>, <BreadcrumbNavLink href="/a/" index={1}>
        Parkeren in Rotterdam
      </BreadcrumbNavLink>,
    // TODO: Use icon when iconset is available
    <BreadcrumbNavSeparator>
        <RodsIconChevronRight />
      </BreadcrumbNavSeparator>, <BreadcrumbNavLink href="/a/b/" rel="up" index={2} disabled current>
        Product aanvragen
      </BreadcrumbNavLink>]
  },
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/Gemeente-Rotterdam-Design-System?type=design&node-id=507-20062&mode=design&t=yvzUSkFQYQmWSHsQ-4'
    }
  }
}`,...(d=(o=r.parameters)==null?void 0:o.docs)==null?void 0:d.source}}};const f=["Default"];export{r as Default,f as __namedExportsOrder,b as default};
