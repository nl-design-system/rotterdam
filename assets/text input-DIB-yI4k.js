import{j as t}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as i}from"./index-DbGdhrAm.js";import{ap as r,aq as d}from"./index-EPR96kIa.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-Dm_gwR-y.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const p=`<!-- @license CC0-1.0 -->

# Text Input component voor Apache Wicket

Biedt de mogelijkheid om één regel aan tekens in te vullen.

Zie ook: [Form Field Text Input](?path=/docs/apache-wicket-form-field-text-input--docs)


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/rotterdam-nlds-parent-wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/text_input/)

[Broncode van het component](https://github.com/nl-design-system/rotterdam/blob/main/rotterdam-nlds-parent-wicket/rotterdam-nlds-wicket//src/main/java/nl/rotterdam/wicket/docs/text_input/)

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
`;/*@license CC0-1.0*/function o(n){return t.jsxs(t.Fragment,{children:[`
`,`
`,t.jsx(r,{title:"Apache Wicket/Text Input"}),`
`,t.jsx(d,{children:p})]})}function h(n={}){const{wrapper:e}={...i(),...n.components};return e?t.jsx(e,{...n,children:t.jsx(o,{...n})}):o()}export{h as default};
