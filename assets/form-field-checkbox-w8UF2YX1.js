import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as r}from"./index-DbGdhrAm.js";import{ap as i,aq as d}from"./index-7Tl8BCET.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-r8bVayTC.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const a=`<!-- @license CC0-1.0 -->

# Form Field Checkbox component voor Apache Wicket

Formulierveld om te kiezen tussen "wel" of "niet".


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/form_field_checkbox/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/form_field_checkbox/)

## Form Field Checkbox

Voorbeeld.


\`\`\`html
<div wicket:id="nlFormFieldCheckbox"></div>
\`\`\`

\`\`\`java
public class ExamplePanel extends Panel {

    public ExamplePanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(createComponent());
    }
    
    private Component createComponent() {
        return new RdFormFieldCheckbox("nlFormFieldCheckbox", Model.of(false), Model.of("Ik ga akkoord met de algemene voorwaarden"), Model.of());
    }

}
\`\`\`

## Form Field Checkbox Invalid

Voorbeeld.


\`\`\`html
<div wicket:id="nlFormFieldCheckboxInvalid"></div>
\`\`\`

\`\`\`java
public class ExamplePanel extends Panel {

    public ExamplePanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(createComponent());
    }
    
    private Component createComponent() {
        RdFormFieldCheckbox component = new RdFormFieldCheckbox("nlFormFieldCheckboxInvalid", Model.of(false), Model.of("Ik ga akkoord met de algemene voorwaarden"), Model.of("U kunt ons echt vertrouwen!"));
        component.getControl().error("U moet akkoord gaan met de algemene voorwaarden, anders kunt u niet verder.");
        return component;
    }

}
\`\`\`
`;/*@license CC0-1.0*/function t(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(i,{title:"Apache Wicket/Form Field Checkbox"}),`
`,n.jsx(d,{children:a})]})}function u(e={}){const{wrapper:o}={...r(),...e.components};return o?n.jsx(o,{...e,children:n.jsx(t,{...e})}):t()}export{u as default};
