package nl.rotterdam.wicket.docs.body;

import nl.rotterdam.design_system.wicket.components.body.utrecht.UtrechtBodyBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class BodyExamplesPanel extends Panel {

    public BodyExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleBodyExample() {
        return new UtrechtBodyBorder("utrechtBody");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleBodyExample());
    }
}
