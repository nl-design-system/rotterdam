import{j as e}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as r}from"./index-DbGdhrAm.js";import{ap as d,aq as i}from"./index-BE1n2rhj.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-Cz0NGX47.js";import"../sb-preview/runtime.js";import"./index-BoT5fo8s.js";import"./index-CuKMG6aU.js";const m=`<!-- @license CC0-1.0 -->

# Form Field Checkbox component voor Apache Wicket

Formulierveld om te kiezen tussen "wel" of "niet".


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/rotterdam-nlds-parent-wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/form_field_checkbox/)

[Broncode van het component](https://github.com/nl-design-system/rotterdam/blob/main/rotterdam-nlds-parent-wicket/rotterdam-nlds-wicket//src/main/java/nl/rotterdam/wicket/docs/form_field_checkbox/)

## Form Field Checkbox

Voorbeeld.


\`\`\`html
<div wicket:id="nlFormFieldCheckbox"></div>
\`\`\`

\`\`\`java
RdFormFieldCheckbox component = new RdFormFieldCheckbox("nlFormFieldCheckbox", Model.of(false), Model.of("Ik ga akkoord met de algemene voorwaarden"), Model.of());
\`\`\`

## Form Field Checkbox Invalid

Voorbeeld.


\`\`\`html
<div wicket:id="nlFormFieldCheckboxInvalid"></div>
\`\`\`

\`\`\`java
RdFormFieldCheckbox component = new RdFormFieldCheckbox("nlFormFieldCheckboxInvalid", Model.of(false), Model.of("Ik ga akkoord met de algemene voorwaarden"), Model.of("U kunt ons echt vertrouwen!"));
component.getControl().error("U moet akkoord gaan met de algemene voorwaarden, anders kunt u niet verder.");
\`\`\`
`;/*@license CC0-1.0*/function t(o){return e.jsxs(e.Fragment,{children:[`
`,`
`,e.jsx(d,{title:"Apache Wicket/Form Field Checkbox"}),`
`,e.jsx(i,{children:m})]})}function x(o={}){const{wrapper:n}={...r(),...o.components};return n?e.jsx(n,{...o,children:e.jsx(t,{...o})}):t()}export{x as default};
