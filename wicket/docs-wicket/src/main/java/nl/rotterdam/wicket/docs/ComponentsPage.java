package nl.rotterdam.wicket.docs;

import nl.utrecht.components.UtrechtCodeBlock;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

// import nl.utrecht.components.UtrechtUnorderedList;

public class ComponentsPage extends BasePage {

    public ComponentsPage() {
        add(new Label(TITLE_ID, "ComponentsPage · Apache Wicket · Rotterdam Design System"));

        add(new WebMarkupContainer("heading") {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(NLDBehaviors.heading1());
                add(new NLDUntranslatableLabel("name", Model.of("Robbert van Frameless")));
            }
        });

        add(new UtrechtCodeBlock("code-block-example", Model.of("Reload Page")));
    }
}
