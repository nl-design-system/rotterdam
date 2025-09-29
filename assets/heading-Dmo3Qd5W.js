import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as i}from"./index-DbGdhrAm.js";import{ap as r,aq as o}from"./index-Cl-lmMzQ.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-c3Dmc2oz.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const l=`<!-- @license CC0-1.0 -->

# Heading component voor Apache Wicket

Koptekst die in de koppenstructuur ingesteld kan worden op het juiste niveau.

[NL Design System Heading documentatie](https://nldesignsystem.nl/heading/)

Mogelijkheden om Kopteksten te maken in Wicket:

1. UtrechtHeading: een Label component om een waarde of Model te tonen
2. UtrechtHeadingBehavior: pas de Utrecht Heading style toe op een ander Wicket component


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/heading/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/heading/)

## Kop 1

Gebruik h1 maximaal één keer per pagina.


\`\`\`html
<h1 class="utrecht-heading-1">Een label met kop 1</h1>
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
    
    private UtrechtHeading createComponent() {
        return new UtrechtHeading("utrechtLabel1", "Een label met kop 1", 1);
    }

}
\`\`\`

## Kop 2

\`\`\`html
<h2 class="utrecht-heading-2">Een label met kop 2</h2>
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
    
    private UtrechtHeading createComponent() {
        return new UtrechtHeading("utrechtLabel2", "Een label met kop 2", 2);
    }

}
\`\`\`

## Kop 3

\`\`\`html
<h3 class="utrecht-heading-3">Een label met kop 3</h3>
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
    
    private UtrechtHeading createComponent() {
        return new UtrechtHeading("utrechtLabel3", "Een label met kop 3", 3);
    }

}
\`\`\`

## Kop 4

\`\`\`html
<h4 class="utrecht-heading-4">Een label met kop 4</h4>
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
    
    private UtrechtHeading createComponent() {
        return new UtrechtHeading("utrechtLabel4", "Een label met kop 4", 4);
    }

}
\`\`\`

## Kop 5

\`\`\`html
<h5 class="utrecht-heading-5">Een label met kop 5</h5>
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
    
    private UtrechtHeading createComponent() {
        return new UtrechtHeading("utrechtLabel5", "Een label met kop 5", 5);
    }

}
\`\`\`

## Kop 6

\`\`\`html
<h6 class="utrecht-heading-6">Een label met kop 6</h6>
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
    
    private UtrechtHeading createComponent() {
        return new UtrechtHeading("utrechtLabel6", "Een label met kop 6", 6);
    }

}
\`\`\`

## Tags worden vervangen

Het Wicket component vervangt automatisch een *div* door de juiste kop-tag:


\`\`\`html
<h3 class="utrecht-heading-3">div wordt vervangen met h3</h3>
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
    
    private UtrechtHeading createComponent() {
        return new UtrechtHeading("utrechtLabel3MetDivTag", "div wordt vervangen met h3", 3);
    }

}
\`\`\`

## Behoud bestaande CSS class

Bestaande CSS-class wordt behouden:


\`\`\`html
<h4 class="extra-class utrecht-heading-4">bestaande CSS class behouden</h4>
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
    
    private UtrechtHeading createComponent() {
        return new UtrechtHeading("bestaandeCssClass", "bestaande CSS class behouden", 4);
    }

}
\`\`\`

## Model constructor

Tekst kan gezet worden met model constructor:


\`\`\`html
<h3 class="utrecht-heading-3">Text via model constructor</h3>
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
    
    private UtrechtHeading createComponent() {
        return new UtrechtHeading("utrechtHeadingModelConstructor", Model.of("Text via model constructor"), 3);
    }

}
\`\`\`

## Model via defaultModel

Tekst kan gezet worden via defaultModel:


\`\`\`html
<h3 class="utrecht-heading-3">Text via defaultModel</h3>
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
        return new UtrechtHeading("utrechtHeadingDefaultModel", 3).setDefaultModel(Model.of("Text via defaultModel"));
    }

}
\`\`\`

## MarkupContainer met niet-vertaalbare content

Koptekst die een persoonsnaam bevat, die dus niet vertaald moet worden door vertaalsoftware:


\`\`\`html
<h1 class="utrecht-heading-1">Welkom mevrouw <bdi translate="no" class="utrecht-preserve-data">Samira de Jongh</bdi></h1>
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
    
    private WebMarkupContainer createComponent() {
        return new WebMarkupContainer("headingMetUntranslatableContent") {
    
            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(heading(1));
                add(new UtrechtPreserveDataLabel("name", Model.of("Samira de Jongh")));
            }
        };
    }

}
\`\`\`
`;/*@license CC0-1.0*/function a(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(r,{title:"Apache Wicket/Heading"}),`
`,n.jsx(o,{children:l})]})}function b(e={}){const{wrapper:t}={...i(),...e.components};return t?n.jsx(t,{...e,children:n.jsx(a,{...e})}):a()}export{b as default};
