package nl.rotterdam.wicket.docs;

import nl.rotterdam.nl_design.wicket.components.code_block.UtrechtCodeBlock;
import nl.rotterdam.nl_design.wicket.components.heading_1.Heading1Behavior;
import nl.rotterdam.nl_design.wicket.components.untranslatable.NLDUntranslatableLabel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

// import nl.utrecht.components.UtrechtUnorderedList;

public class ComponentsPage extends BasePage {

  public ComponentsPage() {
    add(
      new Label(
        TITLE_ID,
        "ComponentsPage · Apache Wicket · Rotterdam Design System"
      )
    );

    add(
      new WebMarkupContainer("heading") {
        @Override
        protected void onInitialize() {
          super.onInitialize();
          add(Heading1Behavior.heading1());
          add(
            new NLDUntranslatableLabel(
              "name",
              Model.of("Robbert van Frameless")
            )
          );
        }
      }
    );

    add(new UtrechtCodeBlock("code-block-example", Model.of("Reload Page")));
  }
}
