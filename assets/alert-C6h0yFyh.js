import{j as e}from"./jsx-runtime-C8prxwi0.js";import{useMDXComponents as r}from"./index-BVXH1tlS.js";import{ap as o,aq as l}from"./index-YLKE6usJ.js";import"./index-DkGvG02X.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-ByrazHvR.js";import"../sb-preview/runtime.js";import"./index-DmLoi2Vx.js";import"./index-CHGET4sZ.js";const d=`<!-- @license CC0-1.0 -->

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
        add(new UtrechtAlert("utrechtAlertAlert", Model.of("Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."), UtrechtAlertType.ERROR));
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
        add(new UtrechtAlert("utrechtAlertInfo", Model.of("Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."), UtrechtAlertType.INFO));
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
        add(new UtrechtAlert("utrechtAlertOk", Model.of("Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."), UtrechtAlertType.OK));
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
        add(new UtrechtAlert("utrechtAlertWarning", Model.of("Deze gegevens zijn reeds ingevuld en komen uit Basis Registratie Personen (BRP). Indien deze gegevens niet kloppen, kunt u dit wijzigen in het BRP."), UtrechtAlertType.WARNING));
    }
}
\`\`\`
`;/*@license CC0-1.0*/function i(n){return e.jsxs(e.Fragment,{children:[`
`,`
`,e.jsx(o,{title:"Apache Wicket/Alert"}),`
`,e.jsx(l,{children:d})]})}function k(n={}){const{wrapper:t}={...r(),...n.components};return t?e.jsx(t,{...n,children:e.jsx(i,{...n})}):i()}export{k as default};
