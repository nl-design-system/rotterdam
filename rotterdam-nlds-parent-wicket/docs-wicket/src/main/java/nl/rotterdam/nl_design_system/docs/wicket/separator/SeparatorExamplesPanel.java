package nl.rotterdam.nl_design_system.docs.wicket.separator;

import nl.rotterdam.nl_design_system.wicket.components.separator.RdSeparator;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;

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
