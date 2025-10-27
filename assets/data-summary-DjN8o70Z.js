import{j as e}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as m}from"./index-DbGdhrAm.js";import{ap as o,aq as r}from"./index-t743zj_r.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-Ca3Vp78R.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const s=`<!-- @license CC0-1.0 -->

# Data Summary component voor Apache Wicket

Geeft een lijst van items met hun label en hun waarde.

Het Wicket component verbergt zichzelf als de lijst leeg is.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/data_summary/)

[Broncode van het component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/data_summary/)

## Basis voorbeeld

lijstje met burgerservicenummer, voornaam en achternaam.


\`\`\`html
<dl wicket:id="basic">key - value items</dl>
\`\`\`

\`\`\`java
RdDataSummary component = new RdDataSummary("basic", new ListModel<>(List.of(new SummaryItem("BSN", new SummaryItemValue("111111110", false)), new SummaryItem("Voornaam", new SummaryItemValue("Corné", false)), new SummaryItem("Achternaam", new SummaryItemValue("de Vos", false)))));
\`\`\`
`;/*@license CC0-1.0*/function a(n){return e.jsxs(e.Fragment,{children:[`
`,`
`,e.jsx(o,{title:"Apache Wicket/Data Summary"}),`
`,e.jsx(r,{children:s})]})}function j(n={}){const{wrapper:t}={...m(),...n.components};return t?e.jsx(t,{...n,children:e.jsx(a,{...n})}):a()}export{j as default};
