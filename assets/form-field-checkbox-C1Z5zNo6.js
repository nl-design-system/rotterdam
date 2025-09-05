import{j as e}from"./jsx-runtime-C8prxwi0.js";import{useMDXComponents as r}from"./index-BVXH1tlS.js";import{ap as i,aq as c}from"./index-YLKE6usJ.js";import"./index-DkGvG02X.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-ByrazHvR.js";import"../sb-preview/runtime.js";import"./index-DmLoi2Vx.js";import"./index-CHGET4sZ.js";const d=`<!-- @license CC0-1.0 -->

# Form Field Checkbox component voor Apache Wicket

Formulierveld om te kiezen tussen "wel" of "niet".


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/form_field_checkbox/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/form_field_checkbox/)

## Form Field Checkbox

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtFormFieldCheckbox"></div>
\`\`\`

\`\`\`java
public class ExamplePanel extends Panel {

    public ExamplePanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtFormFieldCheckbox("utrechtFormFieldCheckbox", Model.of(false), Model.of("I agree"), Model.of("Description"), Model.of("error")));
    }
}
\`\`\`
`;/*@license CC0-1.0*/function t(n){return e.jsxs(e.Fragment,{children:[`
`,`
`,e.jsx(i,{title:"Apache Wicket/Form Field Checkbox"}),`
`,e.jsx(c,{children:d})]})}function u(n={}){const{wrapper:o}={...r(),...n.components};return o?e.jsx(o,{...n,children:e.jsx(t,{...n})}):t()}export{u as default};
