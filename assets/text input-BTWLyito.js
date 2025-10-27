import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as i}from"./index-DbGdhrAm.js";import{ap as p,aq as r}from"./index-t743zj_r.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-Ca3Vp78R.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const d=`<!-- @license CC0-1.0 -->

# Text Input component voor Apache Wicket

Biedt de mogelijkheid om één regel aan tekens in te vullen.

Zie ook: [Form Field Text Input](?path=/docs/apache-wicket-form-field-text-input--docs)


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/text_input/)

[Broncode van het component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/text_input/)

## Text Input

Voorbeeld standaard textInput.


\`\`\`html
<input wicket:id="textInput" type="text">
\`\`\`

\`\`\`java
RdTextInput<String> component = new RdTextInput<>("textInput", Model.of(""));
\`\`\`

## Text Input Disabled

Voorbeeld.


\`\`\`html
<input wicket:id="textInputDisabled" type="text">
\`\`\`

\`\`\`java
RdTextInput<String> component = new RdTextInput<>("textInputDisabled", Model.of(""));
component.setEnabled(false);
\`\`\`

## Texbox Required

Voorbeeld.


\`\`\`html
<input wicket:id="textInputRequired" type="text">
\`\`\`

\`\`\`java
RdTextInput<String> component = new RdTextInput<>("textInputRequired", Model.of(""));
component.setRequired(true);
\`\`\`
`;/*@license CC0-1.0*/function o(t){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(p,{title:"Apache Wicket/Text Input"}),`
`,n.jsx(r,{children:d})]})}function h(t={}){const{wrapper:e}={...i(),...t.components};return e?n.jsx(e,{...t,children:n.jsx(o,{...t})}):o()}export{h as default};
