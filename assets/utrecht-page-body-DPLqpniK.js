import{j as n}from"./jsx-runtime-C8prxwi0.js";import{useMDXComponents as r}from"./index-BVXH1tlS.js";import{ap as a,aq as i}from"./index-B3gJ7mz_.js";import"./index-DkGvG02X.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-T44GE3nj.js";import"../sb-preview/runtime.js";import"./index-DmLoi2Vx.js";import"./index-CHGET4sZ.js";const d=`<!-- @license CC0-1.0 -->

# Utrecht-page-body component voor Apache Wicket

Inhoud van de pagina.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/page_body/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/page_body/)

## Page Body

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtPageBody"></div>
\`\`\`

\`\`\`java
public class ExamplePanel extends Panel {

    public ExamplePanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtPageBodyBorder("utrechtPageBody"));
    }
}
\`\`\`
`;/*@license CC0-1.0*/function o(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(a,{title:"Apache Wicket/Page Body"}),`
`,n.jsx(i,{children:d})]})}function v(e={}){const{wrapper:t}={...r(),...e.components};return t?n.jsx(t,{...e,children:n.jsx(o,{...e})}):o()}export{v as default};
