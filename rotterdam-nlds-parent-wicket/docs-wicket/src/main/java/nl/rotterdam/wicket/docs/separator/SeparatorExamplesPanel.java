package nl.rotterdam.wicket.docs.separator;

import nl.rotterdam.nl_design_system.wicket.components.separator.utrecht.UtrechtSeparator;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

public class SeparatorExamplesPanel extends ExamplesPanel {
    public SeparatorExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return UtrechtSeparator.class;
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
