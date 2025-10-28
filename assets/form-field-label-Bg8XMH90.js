import{j as e}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as r}from"./index-DbGdhrAm.js";import{ap as a,aq as l}from"./index-B1xFO8Qs.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-Gq4qGOUE.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const i=`<!-- @license CC0-1.0 -->

# Form Field Label component voor Apache Wicket

Toont een tekstlabel dat informeert over de in te vullen informatie.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/form_field_label/)

[Broncode van het component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/form_field_label/)

## Form Field Label

* Plaats het label voor het invoerveld, behalve voor checkbox options en radio options.
* Plaats de checkbox of radio button in de form label.
* Koppel de label met de form control met "for" en "id".


\`\`\`html
<label wicket:id="formFieldLabel"></label>
\`\`\`

\`\`\`java
UtrechtFormLabel component = new UtrechtFormLabel("formFieldLabel", Model.of("Voornaam"));
\`\`\`

## Form Field Label for Checkbox

\`\`\`html
<label wicket:id="formFieldLabelCheckbox"></label>
\`\`\`

\`\`\`java
UtrechtFormLabel component = new UtrechtFormLabel("formFieldLabelCheckbox", Model.of("Optie 1"), UtrechtFormLabelBehavior.INSTANCE_CHECKBOX);
\`\`\`

## Form Field Label for Radio

\`\`\`html
<label wicket:id="formFieldLabelRadio"></label>
\`\`\`

\`\`\`java
UtrechtFormLabel component = new UtrechtFormLabel("formFieldLabelRadio", Model.of("Optie 1"), UtrechtFormLabelBehavior.INSTANCE_RADIO);
\`\`\`
`;/*@license CC0-1.0*/function t(o){return e.jsxs(e.Fragment,{children:[`
`,`
`,e.jsx(a,{title:"Apache Wicket/Form Field Label"}),`
`,e.jsx(l,{children:i})]})}function L(o={}){const{wrapper:n}={...r(),...o.components};return n?e.jsx(n,{...o,children:e.jsx(t,{...o})}):t()}export{L as default};
