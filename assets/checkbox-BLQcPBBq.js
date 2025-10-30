import{j as e}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as c}from"./index-DbGdhrAm.js";import{ap as r,aq as i}from"./index-EPR96kIa.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-Dm_gwR-y.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const a=`<!-- @license CC0-1.0 -->

# Checkbox component voor Apache Wicket

Invoerveld voor het kiezen van een optie uit een groep van opties, of om te kiezen tussen "wel" of "niet".

Zie ook: [Form Field Checkbox](?path=/docs/apache-wicket-form-field-checkbox--docs)


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/rotterdam-nlds-parent-wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/checkbox/)

[Broncode van het component](https://github.com/nl-design-system/rotterdam/blob/main/rotterdam-nlds-parent-wicket/rotterdam-nlds-wicket//src/main/java/nl/rotterdam/wicket/docs/checkbox/)

## Checkbox

Voorbeeld standaard checkbox.


\`\`\`html
<input wicket:id="checkbox" type="checkbox">
\`\`\`

\`\`\`java
RdCheckbox component = new RdCheckbox("checkbox", Model.of(false));
\`\`\`

## Checkbox Invalid

Voorbeeld checkbox die door gebruiker verzonden is, maar niet is ingevuld.


\`\`\`html
<input wicket:id="checkboxInvalid" type="checkbox">
\`\`\`

\`\`\`java
RdCheckbox component = new RdCheckbox("checkboxInvalid", Model.of(false));
component.error("Melding, wordt bij standalone Checkbox niet getoond, wel is het veld rood");
\`\`\`
`;/*@license CC0-1.0*/function t(n){return e.jsxs(e.Fragment,{children:[`
`,`
`,e.jsx(r,{title:"Apache Wicket/Checkbox"}),`
`,e.jsx(i,{children:a})]})}function v(n={}){const{wrapper:o}={...c(),...n.components};return o?e.jsx(o,{...n,children:e.jsx(t,{...n})}):t()}export{v as default};
