import{j as n}from"./jsx-runtime-C8prxwi0.js";import{useMDXComponents as a}from"./index-BVXH1tlS.js";import{ap as i,aq as r}from"./index-Fo0fc18B.js";import"./index-DkGvG02X.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-CY0NdQld.js";import"../sb-preview/runtime.js";import"./index-DmLoi2Vx.js";import"./index-CHGET4sZ.js";const c=`<!-- @license CC0-1.0 -->

# Page Layout component voor Apache Wicket

Layout van de paginainhoud, en de informatie en links boven en onder de pagina.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/page_layout/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/page_layout/)

## Page Layout

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtPageLayout"></div>
\`\`\`

\`\`\`java
public class ExamplePanel extends Panel {

    public ExamplePanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtPageLayoutBorder("utrechtPageLayout"));
    }
}
\`\`\`
`;/*@license CC0-1.0*/function o(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(i,{title:"Apache Wicket/Page Layout"}),`
`,n.jsx(r,{children:c})]})}function k(e={}){const{wrapper:t}={...a(),...e.components};return t?n.jsx(t,{...e,children:n.jsx(o,{...e})}):o()}export{k as default};
