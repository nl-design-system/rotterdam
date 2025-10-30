import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as r}from"./index-DbGdhrAm.js";import{ap as i,aq as a}from"./index-EPR96kIa.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-Dm_gwR-y.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const c=`<!-- @license CC0-1.0 -->

# Action Group component voor Apache Wicket

Groepeert één of meer gerelateerde acties en verzorgt de lay-out van de content.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/rotterdam-nlds-parent-wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/action_group/)

[Broncode van het component](https://github.com/nl-design-system/rotterdam/blob/main/rotterdam-nlds-parent-wicket/rotterdam-nlds-wicket//src/main/java/nl/rotterdam/wicket/docs/action_group/)

## Button Group

Voorbeeld Action Group met één button.


\`\`\`html
<div wicket:id="actionGroup">
 <button wicket:id="button">voorbeeld knop</button>
</div>
\`\`\`

\`\`\`java
RdActionGroup component = new RdActionGroup("actionGroup");
component.add(new RdButton("button") {

    @Override
    public void onSubmit() {
        super.onSubmit();
        System.out.println("ActionGroupExamplesPanel.onSubmit called");
    }
});
\`\`\`
`;/*@license CC0-1.0*/function e(t){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(i,{title:"Apache Wicket/Action Group"}),`
`,n.jsx(a,{children:c})]})}function w(t={}){const{wrapper:o}={...r(),...t.components};return o?n.jsx(o,{...t,children:n.jsx(e,{...t})}):e()}export{w as default};
