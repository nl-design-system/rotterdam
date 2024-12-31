import{j as n}from"./jsx-runtime-C8prxwi0.js";import{useMDXComponents as a}from"./index-BVXH1tlS.js";import{ap as i,aq as r}from"./index-B3gJ7mz_.js";import"./index-DkGvG02X.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-T44GE3nj.js";import"../sb-preview/runtime.js";import"./index-DmLoi2Vx.js";import"./index-CHGET4sZ.js";const m=`<!-- @license CC0-1.0 -->

# Rotterdam-logo-image component voor Apache Wicket

Logo van gemeente Rotterdam als SVG-afbeelding.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/logo_image/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/logo_image/)

## Logo Image

Voorbeeld.


\`\`\`html
<div wicket:id="rotterdamLogoImage"></div>
\`\`\`

\`\`\`java
public class ExamplePanel extends Panel {

    public ExamplePanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new RotterdamLogoImage("rotterdamLogoImage"));
    }
}
\`\`\`
`;/*@license CC0-1.0*/function t(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(i,{title:"Apache Wicket/Rotterdam Logo Image"}),`
`,n.jsx(r,{children:m})]})}function b(e={}){const{wrapper:o}={...a(),...e.components};return o?n.jsx(o,{...e,children:n.jsx(t,{...e})}):t()}export{b as default};
