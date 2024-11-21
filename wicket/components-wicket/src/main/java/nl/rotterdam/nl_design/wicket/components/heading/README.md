# Heading component voor Apache Wicket

Gebruik de component als volgt:

Voorbeeld 1

```html
<p>Tekst kan gezet worden via defaultModel:</p>
<h4 wicket:id="utrechtHeadingDefaultModel">Text wordt gezet via defaultModel</h4>
```

```java
class NlDesignSystemWicketDemoPanel extends Panel {

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("utrechtHeadingDefaultModel", 3).setDefaultModel(Model.of("Text via defaultModel")));
    }
}
```

Voorbeeld 2

```html
<p>Het Wicket component vervangt automatisch een <em>div</em> door de juiste kop-tag:</p>
<div wicket:id="utrechtLabel3MetDivTag">
 Utrecht label 3 met div
</div>
```

```java
class NlDesignSystemWicketDemoPanel extends Panel {

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("utrechtLabel3MetDivTag", "div wordt vervangen met h3", 3));
    }
}
```

Voorbeeld 3

```html
<h1 wicket:id="utrechtLabel1">Header 1</h1>
```

```java
class NlDesignSystemWicketDemoPanel extends Panel {

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("utrechtLabel1", "Een label met kop 1", 1));
    }
}
```

Voorbeeld 4

```html
<h2 wicket:id="utrechtLabel2">Header 2</h2>
```

```java
class NlDesignSystemWicketDemoPanel extends Panel {

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("utrechtLabel2", "Een label met kop 2", 2));
    }
}
```

Voorbeeld 5

```html
<h3 wicket:id="utrechtLabel3">Header 3</h3>
```

```java
class NlDesignSystemWicketDemoPanel extends Panel {

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("utrechtLabel3", "Een label met kop 3", 3));
    }
}
```

Voorbeeld 6

```html
<h4 wicket:id="utrechtLabel4">Header 4</h4>
```

```java
class NlDesignSystemWicketDemoPanel extends Panel {

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("utrechtLabel4", "Een label met kop 4", 4));
    }
}
```

Voorbeeld 7

```html
<h5 wicket:id="utrechtLabel5">Header 5</h5>
```

```java
class NlDesignSystemWicketDemoPanel extends Panel {

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("utrechtLabel5", "Een label met kop 5", 5));
    }
}
```

Voorbeeld 8

```html
<h6 wicket:id="utrechtLabel6">Header 6</h6>
```

```java
class NlDesignSystemWicketDemoPanel extends Panel {

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("utrechtLabel6", "Een label met kop 6", 6));
    }
}
```

Voorbeeld 9

```html
<p>Bestaande CSS-class wordt behouden:</p>
<h4 class="extra-class" wicket:id="bestaandeCssClass">Keep the class!</h4>
```

```java
class NlDesignSystemWicketDemoPanel extends Panel {

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("bestaandeCssClass", "bestaande CSS class behouden", 4));
    }
}
```

Voorbeeld 10

```html
<p>Tekst kan gezet worden met model constructor:</p>
<h4 wicket:id="utrechtHeadingModelConstructor">Text wordt gezet via model constructor</h4>
```

```java
class NlDesignSystemWicketDemoPanel extends Panel {

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtHeading("utrechtHeadingModelConstructor", Model.of("Text via model constructor"), 3));
    }
}
```

Voorbeeld 11

```html
<p>Koptekst die een persoonsnaam bevat, die dus niet vertaald moet worden door vertaalsoftware:</p>
<h1 wicket:id="headingMetUntranslatableContent">Welkom mevrouw
  <bdi wicket:id="name">Van Bergenhenegouwen</bdi>
</h1>
```

```java
class NlDesignSystemWicketDemoPanel extends Panel {

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new WebMarkupContainer("headingMetUntranslatableContent") {

            @Override
            private void onInitialize() {
                super.onInitialize();
                add(heading(1));
                add(new UtrechtUntranslatableLabel("name", Model.of("Samira de Jongh")));
            }
        });
    }
}
```