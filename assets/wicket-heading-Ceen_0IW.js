import{j as e}from"./jsx-runtime-BlAj40OV.js";import{useMDXComponents as a}from"./index-BI1Biiay.js";import{aj as l,ak as d}from"./index-CmI1lUdS.js";import"./index-Cs7sjTYM.js";import"./_commonjsHelpers-BosuxZz1.js";import"./iframe-B4dS-EDr.js";import"../sb-preview/runtime.js";import"./index-BU4L-DQy.js";import"./extends-CF3RwP-h.js";import"./index-DSgSp0X8.js";const o=`# Heading component voor Apache Wicket

[Voorbeeld sourcecode](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/heading/)

Koptekst die in de koppenstructuur ingesteld kan worden op het juiste niveau.

[NL Design System Heading documentatie](https://nldesignsystem.nl/heading/)

Mogelijkheden om Kopteksten te maken in Wicket:

1. UtrechtHeading: een Label component om een waarde of Model te tonen
2. UtrechtHeadingBehavior: pas de Utrecht Heading style toe op een ander Wicket component

Hieronder volgen verschillende voorbeelden van het gebruik van het component in Apache Wicket.

## Kop 1

\`\`\`html
<h1 wicket:id="utrechtLabel1">Gebruik maximaal één h1 per pagina</h1>
\`\`\`

\`\`\`java
public class NlDesignSystemWicketDemoPanel extends Panel {

    public NlDesignSystemWicketDemoPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("utrechtLabel1", "Een label met kop 1", 1));
    }
}
\`\`\`

## Kop 2

\`\`\`html
<h2 wicket:id="utrechtLabel2">Header 2</h2>
\`\`\`

\`\`\`java
public class NlDesignSystemWicketDemoPanel extends Panel {

    public NlDesignSystemWicketDemoPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("utrechtLabel2", "Een label met kop 2", 2));
    }
}
\`\`\`

## Kop 3

\`\`\`html
<h3 wicket:id="utrechtLabel3">Header 3</h3>
\`\`\`

\`\`\`java
public class NlDesignSystemWicketDemoPanel extends Panel {

    public NlDesignSystemWicketDemoPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("utrechtLabel3", "Een label met kop 3", 3));
    }
}
\`\`\`

## Kop 4

\`\`\`html
<h4 wicket:id="utrechtLabel4">Header 4</h4>
\`\`\`

\`\`\`java
public class NlDesignSystemWicketDemoPanel extends Panel {

    public NlDesignSystemWicketDemoPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("utrechtLabel4", "Een label met kop 4", 4));
    }
}
\`\`\`

## Kop 5

\`\`\`html
<h5 wicket:id="utrechtLabel5">Header 5</h5>
\`\`\`

\`\`\`java
public class NlDesignSystemWicketDemoPanel extends Panel {

    public NlDesignSystemWicketDemoPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("utrechtLabel5", "Een label met kop 5", 5));
    }
}
\`\`\`

## Kop 6

\`\`\`html
<h6 wicket:id="utrechtLabel6">Header 6</h6>
\`\`\`

\`\`\`java
public class NlDesignSystemWicketDemoPanel extends Panel {

    public NlDesignSystemWicketDemoPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("utrechtLabel6", "Een label met kop 6", 6));
    }
}
\`\`\`

## Tags worden vervangen

\`\`\`html
<div wicket:id="utrechtLabel3MetDivTag">
 Utrecht label 3 met div wordt door Wicket bij het renderen vervangen.
</div>
\`\`\`

\`\`\`java
public class NlDesignSystemWicketDemoPanel extends Panel {

    public NlDesignSystemWicketDemoPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("utrechtLabel3MetDivTag", "div wordt vervangen met h3", 3));
    }
}
\`\`\`

## Behoud bestaande CSS class

\`\`\`html
<h4 class="extra-class" wicket:id="bestaandeCssClass">De bestaande class blijft behouden</h4>
\`\`\`

\`\`\`java
public class NlDesignSystemWicketDemoPanel extends Panel {

    public NlDesignSystemWicketDemoPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("bestaandeCssClass", "bestaande CSS class behouden", 4));
    }
}
\`\`\`

## Model constructor

\`\`\`html
<h4 wicket:id="utrechtHeadingModelConstructor">Tekst wordt gezet via model constructor</h4>
\`\`\`

\`\`\`java
public class NlDesignSystemWicketDemoPanel extends Panel {

    public NlDesignSystemWicketDemoPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("utrechtHeadingModelConstructor", Model.of("Text via model constructor"), 3));
    }
}
\`\`\`

## Model via defaultModel

\`\`\`html
<h4 wicket:id="utrechtHeadingDefaultModel">Tekst wordt gezet via defaultModel</h4>
\`\`\`

\`\`\`java
public class NlDesignSystemWicketDemoPanel extends Panel {

    public NlDesignSystemWicketDemoPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("utrechtHeadingDefaultModel", 3).setDefaultModel(Model.of("Text via defaultModel")));
    }
}
\`\`\`

## MarkupContainer met niet-vertaalbare content

\`\`\`html
<h1 wicket:id="headingMetUntranslatableContent">Welkom mevrouw <bdi wicket:id="name">Van Bergenhenegouwen</bdi></h1>
\`\`\`

\`\`\`java
public class NlDesignSystemWicketDemoPanel extends Panel {

    public NlDesignSystemWicketDemoPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new WebMarkupContainer("headingMetUntranslatableContent") {

        @Override
        protected void onInitialize() {
            super.onInitialize();
            add(heading(1));
            add(new UtrechtPreserveDataLabel("name", Model.of("Samira de Jongh")));
        }
    });
    }
}
\`\`\`
`;function i(n){return e.jsxs(e.Fragment,{children:[e.jsx(l,{title:"Apache Wicket/Heading"}),`
`,e.jsx(d,{children:o})]})}function v(n={}){const{wrapper:t}={...a(),...n.components};return t?e.jsx(t,{...n,children:e.jsx(i,{...n})}):i()}export{v as default};
