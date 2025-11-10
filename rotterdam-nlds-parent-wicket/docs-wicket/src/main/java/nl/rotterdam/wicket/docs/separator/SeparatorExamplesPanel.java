package nl.rotterdam.wicket.docs.separator;

import nl.rotterdam.nl_design_system.wicket.components.separator.RdSeparator;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

public class SeparatorExamplesPanel extends ExamplesPanel {
    public SeparatorExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdSeparator.class;
    }

    @ComponentExample
    private static RdSeparator exampleSeparator() {
        return new RdSeparator("separator");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleSeparator());
    }
}
