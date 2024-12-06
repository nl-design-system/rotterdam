package nl.rotterdam.wicket.docs.separator;

import nl.rotterdam.design_system.wicket.components.separator.utrecht.UtrechtSeparator;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class UtrechtSeparatorExamplesPanel extends Panel {

    public UtrechtSeparatorExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleSeparator() {
        return new UtrechtSeparator("utrechtSeparator");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleSeparator());
    }
}
