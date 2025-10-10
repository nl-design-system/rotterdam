import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as i}from"./index-DbGdhrAm.js";import{ap as c,aq as r}from"./index-DM1K1-lq.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-C8GJd0H2.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const a=`<!-- @license CC0-1.0 -->

# Checkbox component voor Apache Wicket

Invoerveld voor het kiezen van een optie uit een groep van opties, of om te kiezen tussen "wel" of "niet".

Zie ook: [Form Field Checkbox](?path=/docs/apache-wicket-form-field-checkbox--docs)


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/checkbox/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/checkbox/)

## Checkbox

Voorbeeld standaard checkbox.


\`\`\`html
<input wicket:id="checkbox" type="checkbox">
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
        return new RdCheckbox("checkbox", Model.of(false));
    }

}
\`\`\`

## Checkbox Invalid

Voorbeeld checkbox die door gebruiker verzonden is, maar niet is ingevuld.


\`\`\`html
<input wicket:id="checkboxInvalid" type="checkbox">
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
        CheckBox component = new RdCheckbox("checkboxInvalid", Model.of(false));
        component.error("Melding, wordt bij standalone Checkbox niet getoond, wel is het veld rood");
        return component;
    }

}
\`\`\`
`;/*@license CC0-1.0*/function t(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(c,{title:"Apache Wicket/Checkbox"}),`
`,n.jsx(r,{children:a})]})}function u(e={}){const{wrapper:o}={...i(),...e.components};return o?n.jsx(o,{...e,children:n.jsx(t,{...e})}):t()}export{u as default};
