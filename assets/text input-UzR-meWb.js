import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as i}from"./index-DbGdhrAm.js";import{ap as p,aq as r}from"./index-CVjLHMhw.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-XrOEV80q.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const a=`<!-- @license CC0-1.0 -->

# Text Input component voor Apache Wicket

Biedt de mogelijkheid om één regel aan tekens in te vullen.

Zie ook: [Form Field Text Input](?path=/docs/apache-wicket-form-field-text-input--docs)


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/text_input/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/text_input/)

## Text Input

Voorbeeld standaard textInput.


\`\`\`html
<input wicket:id="textInput" type="text">
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
        return new RdTextInput<>("textInput", Model.of(""));
    }

}
\`\`\`

## Text Input Disabled

Voorbeeld.


\`\`\`html
<input wicket:id="textInputDisabled" type="text">
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
        RdTextInput<String> component = new RdTextInput<>("textInputDisabled", Model.of(""));
        component.setEnabled(false);
        return component;
    }

}
\`\`\`

## Texbox Required

Voorbeeld.


\`\`\`html
<input wicket:id="textInputRequired" type="text">
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
        RdTextInput<String> component = new RdTextInput<>("textInputRequired", Model.of(""));
        component.setRequired(true);
        return component;
    }

}
\`\`\`
`;/*@license CC0-1.0*/function o(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(p,{title:"Apache Wicket/Text Input"}),`
`,n.jsx(r,{children:a})]})}function v(e={}){const{wrapper:t}={...i(),...e.components};return t?n.jsx(t,{...e,children:n.jsx(o,{...e})}):o()}export{v as default};
