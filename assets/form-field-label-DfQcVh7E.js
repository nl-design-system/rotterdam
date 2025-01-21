import{j as e}from"./jsx-runtime-C8prxwi0.js";import{useMDXComponents as r}from"./index-BVXH1tlS.js";import{ap as i,aq as a}from"./index-DXqktkTG.js";import"./index-DkGvG02X.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-t3j7COuj.js";import"../sb-preview/runtime.js";import"./index-DmLoi2Vx.js";import"./index-CHGET4sZ.js";const l=`<!-- @license CC0-1.0 -->

# Form Field Label component voor Apache Wicket

Toont een tekstlabel dat informeert over de in te vullen informatie.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/form_field_label/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/form_field_label/)

## Form Field Label

* Plaats het label voor het invoerveld, behalve voor checkbox options en radio options.
* Plaats de checkbox of radio button in de form label.
* Koppel de label met de form control met "for" en "id".


\`\`\`html
<div wicket:id="utrechtFormFieldLabel"></div>
\`\`\`

\`\`\`java
public class ExamplePanel extends Panel {

    public ExamplePanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtFormLabel("utrechtFormFieldLabel", Model.of("Voornaam")));
    }
}
\`\`\`
`;/*@license CC0-1.0*/function t(n){return e.jsxs(e.Fragment,{children:[`
`,`
`,e.jsx(i,{title:"Apache Wicket/Form Field Label"}),`
`,e.jsx(a,{children:l})]})}function f(n={}){const{wrapper:o}={...r(),...n.components};return o?e.jsx(o,{...n,children:e.jsx(t,{...n})}):t()}export{f as default};
