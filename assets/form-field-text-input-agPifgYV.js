import{j as e}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as o}from"./index-DbGdhrAm.js";import{ap as r,aq as d}from"./index-7Tl8BCET.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-r8bVayTC.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const a=`<!-- @license CC0-1.0 -->

# Form Field Text Input component voor Apache Wicket

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

Een form field in disabled mode. Wordt zo gerenderd door Wicket setEnabled(false) te gebruiken.


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
        return new RdFormFieldTextInput<>("formFieldTextInputDisabled", Model.of("Willem-Alexander van Oranje-Nassau"), Model.of("Naam"), Model.of("Je volledig naam.")).setEnabled(false);
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

## Form Field TextInput with autocomplete enabled and spell check disabled.

Met configureTextInput() kan je dit regelen zonder een [fluent code style](https://java-design-patterns.com/patterns/fluent-interface/) te laten varen.


\`\`\`html
<div wicket:id="formFieldTextInputWithAutocompleteConfigured"></div>
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
        return new RdFormFieldTextInput<>("formFieldTextInputWithAutocompleteConfigured", Model.of(""), Model.of("Voornaam"), Model.of("Vul je voornaam in.")).withTextInput((input, formField) -> input.add(AttributeModifier.replace("autocomplete", "given-name"), AttributeModifier.replace("spellcheck", "false")));
    }

}
\`\`\`
`;/*@license CC0-1.0*/function i(n){return e.jsxs(e.Fragment,{children:[`
`,`
`,e.jsx(r,{title:"Apache Wicket/Form Field Text Input"}),`
`,e.jsx(d,{children:a})]})}function F(n={}){const{wrapper:t}={...o(),...n.components};return t?e.jsx(t,{...n,children:e.jsx(i,{...n})}):i()}export{F as default};
