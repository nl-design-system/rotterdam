import{j as e}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as r}from"./index-DbGdhrAm.js";import{ap as o,aq as a}from"./index-CKhHj84B.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-zyKUXn25.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const l=`<!-- @license CC0-1.0 -->

# Alert component voor Apache Wicket

Belangrijk bericht dat informeert over de huidige activiteit van de gebruiker.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/alert/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/alert/)

## Alert Alert

Voorbeeld


\`\`\`html
<div class="extra-class" wicket:id="utrechtAlertAlert">Lorem ipsum dolor sit amet</div>
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
        return new UtrechtAlert("utrechtAlertAlert", Model.of("Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."), UtrechtAlertType.ERROR);
    }

}
\`\`\`

## Alert Info

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtAlertInfo">Lorem ipsum dolor sit amet</div>
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
        return new UtrechtAlert("utrechtAlertInfo", Model.of("Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."), UtrechtAlertType.INFO);
    }

}
\`\`\`

## Alert OK

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtAlertOk">Lorem ipsum dolor sit amet</div>
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
        return new UtrechtAlert("utrechtAlertOk", Model.of("Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."), UtrechtAlertType.OK);
    }

}
\`\`\`

## Alert Warning

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtAlertWarning">Lorem ipsum dolor sit amet</div>
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
        return new UtrechtAlert("utrechtAlertWarning", Model.of("Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."), UtrechtAlertType.WARNING);
    }

}
\`\`\`
`;/*@license CC0-1.0*/function i(n){return e.jsxs(e.Fragment,{children:[`
`,`
`,e.jsx(o,{title:"Apache Wicket/Alert"}),`
`,e.jsx(a,{children:l})]})}function k(n={}){const{wrapper:t}={...r(),...n.components};return t?e.jsx(t,{...n,children:e.jsx(i,{...n})}):i()}export{k as default};
