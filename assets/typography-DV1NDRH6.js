import{j as e}from"./jsx-runtime-BlAj40OV.js";import{useMDXComponents as a}from"./index-BI1Biiay.js";import{aj as x,ak as i,an as o}from"./index-BQb4HP8y.js";import{F as m}from"./FigmaBlock-8n9QHsVZ.js";import"./index-Cs7sjTYM.js";import"./_commonjsHelpers-BosuxZz1.js";import"./iframe-Ca36FxjN.js";import"../sb-preview/runtime.js";import"./index-BU4L-DQy.js";import"./extends-CF3RwP-h.js";import"./index-DSgSp0X8.js";const f=`Bolder Heading is only used once per page as the title.

Due to losing it’s readability when used in smaller sizes the main rule is to use the below type only from 40pt to 64pt. Also, try to avoid the use of this type as much as possible and only for campaign purposes only and never in combination with the regular heading type as seen further down below.
`,g=`## Font size

A broad set of text sizes is defined based the 4/8 pixel grid. This set is especially not created with heading names like H1, H2, H3, etcetera because this set is the starting point for all kind of device sizes. As a designer for example you may use the smaller sizes for mobile designs and larger sizes for larger desktop applications.
`,c="",y=`# Typography

A broad set of text sizes is defined based the 4/8 pixel grid. This set is especially not created with heading names like H1, H2, H3, etcetera because this set is the starting point for all kind of device sizes.

As a designer for example you may use the smaller sizes for mobile designs and larger sizes for larger desktop applications.
`,u=[{fontFamily:"Bolder Heading",textContent:"Bolder Heading",fontWeight:700,lineHeight:1},{fontFamily:"Bolder",textContent:"Bolder Bold",fontWeight:700,lineHeight:1},{fontFamily:"Bolder",textContent:"Bolder Regular",fontWeight:400,lineHeight:1},{fontFamily:"Bolder",textContent:"Bolder Light",fontWeight:300,lineHeight:1},{fontFamily:"Bolder",textContent:"Bolder Italic",fontWeight:400,lineHeight:1,fontStyle:"italic"}];function s(n){const t={div:"div",h2:"h2",h3:"h3",...a(),...n.components};return e.jsxs(e.Fragment,{children:[e.jsx(x,{title:"Rotterdam/Typography"}),`
`,e.jsx(i,{children:y}),`
`,e.jsx(m,{href:"https://www.figma.com/file/ZWSC4gCrOXRUR9UX3aoZ8x/?node-id=415-12183"}),`
`,`
`,e.jsx("div",{children:u.map(({fontFamily:r,fontStyle:l,fontWeight:d,lineHeight:p,textContent:h})=>e.jsx(t.div,{style:{fontFamily:r,fontSize:"64px",fontWeight:d,lineHeight:p,fontStyle:l,marginBlock:"32px"},children:h}))}),`
`,e.jsx(i,{children:g}),`
`,e.jsx(i,{children:c}),`
`,e.jsx(t.h2,{id:"font-families",children:"Font families"}),`
`,e.jsx(t.h3,{id:"bolder-heading",children:"Bolder Heading"}),`
`,e.jsx(i,{children:f}),`
`,e.jsx(o,{fontFamily:"Bolder Heading",fontSizes:["64px","48px","40px"],sampleText:"Heading"}),`
`,e.jsx(t.h3,{id:"bolder",children:"Bolder"}),`
`,e.jsx(o,{fontFamily:"Bolder",fontSizes:["64px","48px","40px","32px","28px","24px","20px","16px","12px"],sampleText:"Heading Bold"}),`
`,e.jsx(t.h3,{id:"bolder-light",children:"Bolder Light"}),`
`,e.jsx(o,{fontFamily:"Bolder",fontWeight:300,fontSizes:["64px","48px","40px","32px","28px","24px","20px","16px","12px"],sampleText:"Heading Bold"})]})}function T(n={}){const{wrapper:t}={...a(),...n.components};return t?e.jsx(t,{...n,children:e.jsx(s,{...n})}):s(n)}export{T as default,u as fonts};