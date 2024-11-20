package nl.rotterdam.wicket.docs;

import nl.rotterdam.nl_design.wicket.components.code_block.UtrechtCodeBlock;
import nl.rotterdam.wicket.docs.heading.HeadingPanel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComponentsPage extends BasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentsPage.class);

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

        add(new Link<Void>("refreshStatefulPageLink") {
            @Override
            public void onClick() {
                LOGGER.info("Link was clicked. Page url now has state. Gives ability to inspect HTML in different state.");
            }
        });
    }
}
