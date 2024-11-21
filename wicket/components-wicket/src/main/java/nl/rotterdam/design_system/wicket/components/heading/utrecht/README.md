# Heading component voor Apache Wicket


<p>Koptekst die in de koppenstructuur ingesteld kan worden op het juiste niveau.</p>
<p><a href="https://nldesignsystem.nl/heading/">NL Design System Heading documentatie</a></p>
<p>Mogelijkheden om Kopteksten te maken in Wicket:</p>
<ol>
 <li>UtrechtHeading: een Label component om een waarde of Model te tonen</li>
 <li>UtrechtHeadingBehavior: pas de Utrecht Heading style toe op een ander Wicket component</li>
</ol>

Hieronder volgen verschillende voorbeelden van het gebruik van het component in Apache Wicket.

## Kop 1

```html
<h1 wicket:id="utrechtLabel1">Gebruik maximaal één h1 per pagina</h1>
```

```java
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
```

## Kop 2

```html
<h2 wicket:id="utrechtLabel2">Header 2</h2>
```

```java
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
```

## Kop 3

```html
<h3 wicket:id="utrechtLabel3">Header 3</h3>
```

```java
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
```

## Kop 4

```html
<h4 wicket:id="utrechtLabel4">Header 4</h4>
```

```java
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
```

## Kop 5

```html
<h5 wicket:id="utrechtLabel5">Header 5</h5>
```

```java
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
```

## Kop 6

```html
<h6 wicket:id="utrechtLabel6">Header 6</h6>
```

```java
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
```

## Tags worden vervangen

```html
<div wicket:id="utrechtLabel3MetDivTag">
 Utrecht label 3 met div wordt door Wicket bij het renderen vervangen.
</div>
```

```java
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
```

## Behoud bestaande CSS class

```html
<h4 class="extra-class" wicket:id="bestaandeCssClass">De bestaande class blijft behouden</h4>
```

```java
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
```

## Model constructor

```html
<h4 wicket:id="utrechtHeadingModelConstructor">Tekst wordt gezet via model constructor</h4>
```

```java
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
```

## Model via defaultModel

```html
<h4 wicket:id="utrechtHeadingDefaultModel">Tekst wordt gezet via defaultModel</h4>
```

```java
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
```

## MarkupContainer met niet-vertaalbare content

```html
<h1 wicket:id="headingMetUntranslatableContent">Welkom mevrouw <bdi wicket:id="name">Van Bergenhenegouwen</bdi></h1>
```

```java
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
```
