import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as r}from"./index-DbGdhrAm.js";import{ap as c,aq as d}from"./index-EPR96kIa.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-Dm_gwR-y.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const a=`<!-- @license CC0-1.0 -->

# Code Block component voor Apache Wicket

Toont één of meerdere regels computercode en behoudt de opmaak van deze code.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/rotterdam-nlds-parent-wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/code_block/)

[Broncode van het component](https://github.com/nl-design-system/rotterdam/blob/main/rotterdam-nlds-parent-wicket/rotterdam-nlds-wicket//src/main/java/nl/rotterdam/wicket/docs/code_block/)

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
`;/*@license CC0-1.0*/function o(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(c,{title:"Apache Wicket/Code Block"}),`
`,n.jsx(d,{children:a})]})}function w(e={}){const{wrapper:t}={...r(),...e.components};return t?n.jsx(t,{...e,children:n.jsx(o,{...e})}):o()}export{w as default};
