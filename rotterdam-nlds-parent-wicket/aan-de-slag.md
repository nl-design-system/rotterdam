# Aan de slag als developer

## Als gebruiker van de componenten

### Dependencies opnemen

Gebruik de laatste versie van `rotterdam-nlds-wicket` zoals te vinden op
[mvnrepository.com](https://mvnrepository.com/artifact/nl.rotterdam.nl-design-system/rotterdam-nlds-wicket).

Neem de volgende dependencies op in je project:

```xml
<properties>
  <nlds-rotterdam.version>0.0.8</nlds-rotterdam.version>
</properties>

<dependency>
  <!-- Generieke NL Design System componentenbibliotheek -->
  <groupId>nl.rotterdam.nl-design-system</groupId>
  <artifactId>rotterdam-nlds-wicket</artifactId>
  <version>${nlds-rotterdam.version}</version>
</dependency>

<dependency>
  <!-- CSS gebaseerd op de design tokens van gemeente Rotterdam.
       Andere organisaties leveren hun eigen CSS op basis van hun eigen design tokens. -->
  <groupId>nl.rotterdam.nl-design-system</groupId>
  <artifactId>rotterdam-nlds-css-wicket</artifactId>
  <version>${nlds-rotterdam.version}</version>
</dependency>

<dependency>
  <!-- Rotterdam-specifieke uitbreidingen, zoals iconen en logo -->
  <groupId>nl.rotterdam.nl-design-system</groupId>
  <artifactId>rotterdam-nlds-extensions-wicket</artifactId>
  <version>${nlds-rotterdam.version}</version>
</dependency>
```

### Base page met thema-activatie

Het NL Design System-thema wordt geactiveerd in een centrale base page.
Hieronder een voorbeeld voor het Rotterdam-thema.

Java code:

```java
package nl.rotterdam.demo;

import nl.rotterdam.nl_design_system.rotterdam_css.wicket.NldsRotterdamDesignSystemThemeBehavior;
import nl.rotterdam.nl_design_system.wicket.components.body.RdBodyTransparentContainer;
import nl.rotterdam.nl_design_system.wicket.components.root.RdRootTransparentContainer;
import org.apache.wicket.markup.html.GenericWebPage;

public abstract class MyNlDesignBasePage<MODEL_OBJECT_TYPE> extends GenericWebPage<MODEL_OBJECT_TYPE> {

  @Override
  protected void onInitialize() {
    super.onInitialize();
    add(
      new RdRootTransparentContainer("root").add(NldsRotterdamDesignSystemThemeBehavior.INSTANCE),
      new RdBodyTransparentContainer("body")
    );
  }
}
```

HTML code:

```html
<!DOCTYPE html>
<html wicket:id="root" xmlns:wicket="http://wicket.apache.org/">
  <head>
    <title>NL Design System Base Page</title>
  </head>

  <body wicket:id="body">
    <wicket:child />
  </body>
</html>
```

### Componenten gebruiken

NL Design System Wicket-componenten zijn te vinden in je IDE met de zoekexpressie: `nl.rotterdam.**.RD*`.

Elk component heeft voorbeelden. Bekijk deze als volgt:

- Clone de repository
- Volg de instructies in de
  [README](https://github.com/nl-design-system/rotterdam/tree/main/rotterdam-nlds-parent-wicket) om de documentatie te starten.

## Als ontwikkelaar van NL Design System

Wil je bijdragen aan NL Design System voor Wicket?

Lees de
[README op GitHub](https://github.com/nl-design-system/rotterdam/tree/main/rotterdam-nlds-parent-wicket)
om te starten.
