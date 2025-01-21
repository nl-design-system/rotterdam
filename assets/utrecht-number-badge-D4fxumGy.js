import{j as n}from"./jsx-runtime-C8prxwi0.js";import{useMDXComponents as o}from"./index-BVXH1tlS.js";import{ap as a,aq as i}from"./index-Fo0fc18B.js";import"./index-DkGvG02X.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-CY0NdQld.js";import"../sb-preview/runtime.js";import"./index-DmLoi2Vx.js";import"./index-CHGET4sZ.js";const d=`<!-- @license CC0-1.0 -->

# Number Badge component voor Apache Wicket

Klein label dat de aandacht trekt informeert over een aantal.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/number_badge/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/number_badge/)

## Number Badge

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtNumberBadge"></div>
\`\`\`

\`\`\`java
public class ExamplePanel extends Panel {

    public ExamplePanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtNumberBadge("utrechtNumberBadge", Model.of("42")));
    }
}
\`\`\`
`;/*@license CC0-1.0*/function r(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(a,{title:"Apache Wicket/Number Badge"}),`
`,n.jsx(i,{children:d})]})}function k(e={}){const{wrapper:t}={...o(),...e.components};return t?n.jsx(t,{...e,children:n.jsx(r,{...e})}):r()}export{k as default};
