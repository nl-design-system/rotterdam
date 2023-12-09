import{j as r}from"./jsx-runtime-Q5kDp4vx.js";import{B as o,a,b as n}from"./index-E3oroMGG.js";import"./index-DogsOklH.js";import"./extends-dGVwEr9R.js";const c=`<!-- @license CC0-1.0 -->

# Breadcrumb navigation
`,p={title:"CSS Component/Breadcrumb navigation",id:"css-utrecht-breadcrumb-nav",component:o,argTypes:{children:{name:"Content",type:{name:"string",required:!0},defaultValue:""}},args:{children:""},tags:["autodocs"],parameters:{design:{type:"figma",url:"https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=501-18760"},docs:{description:{component:c}}}},e={name:"Breadcrumb navigation",args:{children:[r.jsx(a,{href:"/",rel:"home",index:0,children:"Home"}),r.jsx(n,{children:"›"}),r.jsx(a,{href:"/a/",index:1,children:"Parkeren in Rotterdam"}),r.jsx(n,{children:"›"}),r.jsx(a,{href:"/a/b/",rel:"up",index:2,disabled:!0,current:!0,children:"Product aanvragen"})]}};var t,d,i;e.parameters={...e.parameters,docs:{...(t=e.parameters)==null?void 0:t.docs,source:{originalSource:`{
  name: 'Breadcrumb navigation',
  args: {
    children: [<BreadcrumbNavLink href="/" rel="home" index={0}>
        Home
      </BreadcrumbNavLink>, <BreadcrumbNavSeparator>›</BreadcrumbNavSeparator>, <BreadcrumbNavLink href="/a/" index={1}>
        Parkeren in Rotterdam
      </BreadcrumbNavLink>,
    // TODO: Use icon when iconset is available
    <BreadcrumbNavSeparator>›</BreadcrumbNavSeparator>, <BreadcrumbNavLink href="/a/b/" rel="up" index={2} disabled current>
        Product aanvragen
      </BreadcrumbNavLink>]
  }
}`,...(i=(d=e.parameters)==null?void 0:d.docs)==null?void 0:i.source}}};const b=["Default"];export{e as Default,b as __namedExportsOrder,p as default};
