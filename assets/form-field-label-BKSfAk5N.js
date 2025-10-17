import{j as e}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as a}from"./index-DbGdhrAm.js";import{ap as r,aq as i}from"./index-7Tl8BCET.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-r8bVayTC.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const l=`<!-- @license CC0-1.0 -->

# Form Field Label component voor Apache Wicket

Toont een tekstlabel dat informeert over de in te vullen informatie.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/form_field_label/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/form_field_label/)

## Form Field Label

* Plaats het label voor het invoerveld, behalve voor checkbox options en radio options.
* Plaats de checkbox of radio button in de form label.
* Koppel de label met de form control met "for" en "id".


\`\`\`html
<label wicket:id="formFieldLabel"></label>
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
        return new UtrechtFormLabel("formFieldLabel", Model.of("Voornaam"));
    }

}
\`\`\`

## Form Field Label for Checkbox

\`\`\`html
<label wicket:id="formFieldLabelCheckbox"></label>
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
        return new UtrechtFormLabel("formFieldLabelCheckbox", Model.of("Optie 1"), UtrechtFormLabelBehavior.INSTANCE_CHECKBOX);
    }

}
\`\`\`

## Form Field Label for Radio

\`\`\`html
<label wicket:id="formFieldLabelRadio"></label>
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
        return new UtrechtFormLabel("formFieldLabelRadio", Model.of("Optie 1"), UtrechtFormLabelBehavior.INSTANCE_RADIO);
    }

}
\`\`\`
`;/*@license CC0-1.0*/function t(n){return e.jsxs(e.Fragment,{children:[`
`,`
`,e.jsx(r,{title:"Apache Wicket/Form Field Label"}),`
`,e.jsx(i,{children:l})]})}function v(n={}){const{wrapper:o}={...a(),...n.components};return o?e.jsx(o,{...n,children:e.jsx(t,{...n})}):t()}export{v as default};
