package nl.rotterdam.wicket.docs;

import nl.rotterdam.nl_design.wicket.components.code_block.UtrechtCodeBlock;
import nl.rotterdam.wicket.docs.heading.HeadingPanel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

public class ComponentsPage extends BasePage {

    public ComponentsPage() {

        // TODO set title using model in BasePage
        add(
            new Label(
                TITLE_ID,
                "ComponentsPage · Apache Wicket · Rotterdam Design System"
            )
        );

        add(new UtrechtCodeBlock("code-block-example", Model.of("Reload Page")));

        add(new HeadingPanel("headingComponents"));
    }
}
