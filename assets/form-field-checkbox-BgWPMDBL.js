import{j as e}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as r}from"./index-DbGdhrAm.js";import{ap as i,aq as a}from"./index-DkF4sKev.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-CVbUGdOT.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const d=`<!-- @license CC0-1.0 -->

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
        add(createComponent());
    }
    
    private Component createComponent() {
        return new UtrechtFormFieldCheckbox("utrechtFormFieldCheckbox", Model.of(false), Model.of("Ik ga akkoord met de algemene voorwaarden"), Model.of());
    }

}
\`\`\`

## Form Field Checkbox Invalid

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtFormFieldCheckboxInvalid"></div>
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
        UtrechtFormFieldCheckbox component = new UtrechtFormFieldCheckbox("utrechtFormFieldCheckboxInvalid", Model.of(false), Model.of("Ik ga akkoord met de algemene voorwaarden"), Model.of("U kunt ons echt vertrouwen!"));
        component.getControl().error("U moet akkoord gaan met de algemene voorwaarden, anders kunt u niet verder.");
        return component;
    }

}
\`\`\`
`;/*@license CC0-1.0*/function t(n){return e.jsxs(e.Fragment,{children:[`
`,`
`,e.jsx(i,{title:"Apache Wicket/Form Field Checkbox"}),`
`,e.jsx(a,{children:d})]})}function v(n={}){const{wrapper:o}={...r(),...n.components};return o?e.jsx(o,{...n,children:e.jsx(t,{...n})}):t()}export{v as default};
