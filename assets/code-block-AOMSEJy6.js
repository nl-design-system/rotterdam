import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as c}from"./index-DbGdhrAm.js";import{ap as r,aq as d}from"./index-t743zj_r.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-Ca3Vp78R.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const m=`<!-- @license CC0-1.0 -->

# Code Block component voor Apache Wicket

Toont één of meerdere regels computercode en behoudt de opmaak van deze code.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/code_block/)

[Broncode van het component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/code_block/)

## Code Block

Voorbeeld.


\`\`\`html
<pre wicket:id="codeBlock"></pre>
\`\`\`

\`\`\`java
UtrechtCodeBlock component = new UtrechtCodeBlock("codeBlock", Model.of("""
    <!DOCTYPE html>
    <html lang="nl" dir="ltr">
      <head>
        <title>NL Design System</title>
        <meta charset="utf-8"/>
      </head>
      <body>
        <h1>NL Design System</h1>
      </body>
    </html>
    """));
\`\`\`
`;/*@license CC0-1.0*/function t(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(r,{title:"Apache Wicket/Code Block"}),`
`,n.jsx(d,{children:m})]})}function w(e={}){const{wrapper:o}={...c(),...e.components};return o?n.jsx(o,{...e,children:n.jsx(t,{...e})}):t()}export{w as default};
