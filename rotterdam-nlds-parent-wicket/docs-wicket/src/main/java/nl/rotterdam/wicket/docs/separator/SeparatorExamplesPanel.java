package nl.rotterdam.wicket.docs.separator;

import nl.rotterdam.nl_design_system.wicket.components.separator.utrecht.UtrechtSeparator;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.markup.html.panel.Panel;

public class SeparatorExamplesPanel extends Panel {
    public static final Class<?> COMPONENT_CLASS = UtrechtSeparator.class;

    public SeparatorExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static UtrechtSeparator exampleSeparator() {
        return new UtrechtSeparator("separator");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleSeparator());
    }
}
