import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as r}from"./index-DbGdhrAm.js";import{ap as i,aq as c}from"./index-t743zj_r.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-Ca3Vp78R.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const a=`<!-- @license CC0-1.0 -->

# Action Group component voor Apache Wicket

Groepeert één of meer gerelateerde acties en verzorgt de lay-out van de content.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/action_group/)

[Broncode van het component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/action_group/)

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
`,n.jsx(c,{children:a})]})}function w(t={}){const{wrapper:o}={...r(),...t.components};return o?n.jsx(o,{...t,children:n.jsx(e,{...t})}):e()}export{w as default};
