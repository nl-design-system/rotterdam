import{j as e}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as i}from"./index-DbGdhrAm.js";import{ap as o,aq as a}from"./index-BE1n2rhj.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-Cz0NGX47.js";import"../sb-preview/runtime.js";import"./index-BoT5fo8s.js";import"./index-CuKMG6aU.js";const d=`<!-- @license CC0-1.0 -->

# Alert component voor Apache Wicket

Belangrijk bericht dat informeert over de huidige activiteit van de gebruiker.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/rotterdam-nlds-parent-wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/alert/)

[Broncode van het component](https://github.com/nl-design-system/rotterdam/blob/main/rotterdam-nlds-parent-wicket/rotterdam-nlds-wicket//src/main/java/nl/rotterdam/wicket/docs/alert/)

## Alert Error

Voorbeeld


\`\`\`html
<div class="extra-class" wicket:id="alertError">Lorem ipsum dolor sit amet</div>
\`\`\`

\`\`\`java
UtrechtAlert component = new UtrechtAlert("alertError", Model.of("Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."), UtrechtAlertType.ERROR);
\`\`\`

## Alert Info

Voorbeeld.


\`\`\`html
<div wicket:id="alertInfo">Lorem ipsum dolor sit amet</div>
\`\`\`

\`\`\`java
UtrechtAlert component = new UtrechtAlert("alertInfo", Model.of("Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."), UtrechtAlertType.INFO);
\`\`\`

## Alert OK

Voorbeeld.


\`\`\`html
<div wicket:id="alertOk">Lorem ipsum dolor sit amet</div>
\`\`\`

\`\`\`java
UtrechtAlert component = new UtrechtAlert("alertOk", Model.of("Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."), UtrechtAlertType.OK);
\`\`\`

## Alert Warning

Voorbeeld.


\`\`\`html
<div wicket:id="alertWarning">Lorem ipsum dolor sit amet</div>
\`\`\`

\`\`\`java
UtrechtAlert component = new UtrechtAlert("alertWarning", Model.of("Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."), UtrechtAlertType.WARNING);
\`\`\`
`;/*@license CC0-1.0*/function r(n){return e.jsxs(e.Fragment,{children:[`
`,`
`,e.jsx(o,{title:"Apache Wicket/Alert"}),`
`,e.jsx(a,{children:d})]})}function k(n={}){const{wrapper:t}={...i(),...n.components};return t?e.jsx(t,{...n,children:e.jsx(r,{...n})}):r()}export{k as default};
