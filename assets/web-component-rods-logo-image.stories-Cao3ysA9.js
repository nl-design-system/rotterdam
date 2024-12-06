import{j as r}from"./jsx-runtime-BlAj40OV.js";import{r as I,x as y,y as S,z as v}from"./components-CWXRJZMj.js";import"./index-Cs7sjTYM.js";import"./_commonjsHelpers-BosuxZz1.js";const R=`For use in avatars & favicons the element that represents ‘water’ in the mark is removed. This leaves the distinct ‘R’.
`,w=`The base logo is formed by the mark and the word mark, executed in landscape mode. If there’s enough space use the base logotype.
`,k=`For smaller displays you could use only the mark of Gemeente Rotterdam. Be sure to use the base logo in the footer on the web page or somewhere within the app (splash screen for example).
`,q=`If there isn’t enough space to use the base logo you’re allowed to use the ‘Square logo’.
`,B=`<!-- @license CC0-1.0 -->

# Logo image
`,A={title:"Web Component/Logo image",id:"web-component-rods-logo-image",component:I,argTypes:{},args:{},tags:["autodocs"],parameters:{docs:{description:{component:B}}}},e={name:"Base logo",parameters:{design:{type:"figma",url:"https://www.figma.com/design/RiVsTfcbmnKSU2BGqQBI9n/RODS-fundament?node-id=1-1385"},docs:{description:{story:w}}}},o={name:"Square logo",parameters:{docs:{description:{story:q}}},render:()=>r.jsx(y,{})},a={name:"Mark",parameters:{docs:{description:{story:k}}},render:()=>r.jsx(S,{})},s={name:"Avatars & favicons",parameters:{docs:{description:{story:R}}},render:()=>r.jsx(v,{})};var n,t,m;e.parameters={...e.parameters,docs:{...(n=e.parameters)==null?void 0:n.docs,source:{originalSource:`{
  name: 'Base logo',
  parameters: {
    design: {
      type: 'figma',
      url: 'https://www.figma.com/design/RiVsTfcbmnKSU2BGqQBI9n/RODS-fundament?node-id=1-1385'
    },
    docs: {
      description: {
        story: logoImageBaseDocs
      }
    }
  }
}`,...(m=(t=e.parameters)==null?void 0:t.docs)==null?void 0:m.source}}};var c,d,i;o.parameters={...o.parameters,docs:{...(c=o.parameters)==null?void 0:c.docs,source:{originalSource:`{
  name: 'Square logo',
  parameters: {
    docs: {
      description: {
        story: logoImageSquareDocs
      }
    }
  },
  render: () => <RodsLogoImageSquare />
}`,...(i=(d=o.parameters)==null?void 0:d.docs)==null?void 0:i.source}}};var g,p,u;a.parameters={...a.parameters,docs:{...(g=a.parameters)==null?void 0:g.docs,source:{originalSource:`{
  name: 'Mark',
  parameters: {
    docs: {
      description: {
        story: logoImageMarkDocs
      }
    }
  },
  render: () => <RodsLogoImageMark />
}`,...(u=(p=a.parameters)==null?void 0:p.docs)==null?void 0:u.source}}};var l,h,f;s.parameters={...s.parameters,docs:{...(l=s.parameters)==null?void 0:l.docs,source:{originalSource:`{
  name: 'Avatars & favicons',
  parameters: {
    docs: {
      description: {
        story: logoImageAvatarDocs
      }
    }
  },
  render: () => <RodsLogoImageAvatar />
}`,...(f=(h=s.parameters)==null?void 0:h.docs)==null?void 0:f.source}}};const M=["Base","Square","Mark","Avatar"];export{s as Avatar,e as Base,a as Mark,o as Square,M as __namedExportsOrder,A as default};
