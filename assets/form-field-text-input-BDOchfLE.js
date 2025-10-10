import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as i}from"./index-DbGdhrAm.js";import{ap as r,aq as d}from"./index-CKhHj84B.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-zyKUXn25.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const l=`<!-- @license CC0-1.0 -->

# Form Field TextInput component voor Apache Wicket

Biedt de mogelijkheid om één regel aan tekens in te vullen.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/form_field_text_input/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/form_field_text_input/)

## Form Field Text Input

Voorbeeld.


\`\`\`html
<div wicket:id="formFieldTextInput"></div>
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
        return new RdFormFieldTextInput<>("formFieldTextInput", Model.of("Koen"), Model.of("Voornaam"), Model.of("Vul je voornaam in."));
    }

}
\`\`\`

## Form Field TextInput Disabled

Voorbeeld.


\`\`\`html
<div wicket:id="formFieldTextInputDisabled"></div>
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
        return new RdFormFieldTextInput<>("formFieldTextInputDisabled", Model.of("Hello world!"), Model.of("I agree"), Model.of("Description")).setEnabled(false);
    }

}
\`\`\`

## Form Field TextInput Required

Voorbeeld.


\`\`\`html
<div wicket:id="formFieldTextInputRequired"></div>
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
        return new RdFormFieldTextInput<>("formFieldTextInputRequired", DefaultModels.EMPTY_STRING_MODEL, Model.of("Email")).setInputType("email").setRequired(true);
    }

}
\`\`\`
`;/*@license CC0-1.0*/function o(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(r,{title:"Apache Wicket/Form Field TextInput"}),`
`,n.jsx(d,{children:l})]})}function F(e={}){const{wrapper:t}={...i(),...e.components};return t?n.jsx(t,{...e,children:n.jsx(o,{...e})}):o()}export{F as default};
