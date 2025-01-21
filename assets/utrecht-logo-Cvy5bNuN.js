import{j as n}from"./jsx-runtime-C8prxwi0.js";import{useMDXComponents as i}from"./index-BVXH1tlS.js";import{ap as r,aq as a}from"./index-DXqktkTG.js";import"./index-DkGvG02X.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-t3j7COuj.js";import"../sb-preview/runtime.js";import"./index-DmLoi2Vx.js";import"./index-CHGET4sZ.js";const c=`<!-- @license CC0-1.0 -->

# Logo component voor Apache Wicket

Bevat een afbeelding van een logo de gewenste afmetingen.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/logo/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/logo/)

## Logo

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtLogo"></div>
\`\`\`

\`\`\`java
public class ExamplePanel extends Panel {

    public ExamplePanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtLogoBorder("utrechtLogo"));
    }
}
\`\`\`
`;/*@license CC0-1.0*/function t(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(r,{title:"Apache Wicket/Logo"}),`
`,n.jsx(a,{children:c})]})}function w(e={}){const{wrapper:o}={...i(),...e.components};return o?n.jsx(o,{...e,children:n.jsx(t,{...e})}):t()}export{w as default};
