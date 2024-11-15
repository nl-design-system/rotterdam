# Heading component voor Apache Wicket

Gebruik de component als volgt:

```java
import nl.rotterdam.nl_design.wicket.components.heading_1.Heading1Behavior;

public class MyPage extends BasePage {

  public ComponentsPage() {
    add(
      new WebMarkupContainer("heading") {
        @Override
        protected void onInitialize() {
          super.onInitialize();
          add(Heading1Behavior.heading1());
          add(new NLDUntranslatableLabel("name", Model.of("John Doe")));
        }
      }
    );
  }
}

```

## Meer info

- [Broncode van `Heading1.java`](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket/src/main/java/nl/rotterdam/nl_design/wicket/components/heading_1/Heading1Behavior.java)
