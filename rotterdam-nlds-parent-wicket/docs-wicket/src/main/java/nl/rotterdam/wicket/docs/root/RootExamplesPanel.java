package nl.rotterdam.wicket.docs.root;

import nl.rotterdam.nl_design_system.wicket.components.root.utrecht.UtrechtRootBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

public class RootExamplesPanel extends ExamplesPanel {
    public RootExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return UtrechtRootBorder.class;
    }

    @ComponentExample
    private static UtrechtRootBorder exampleRoot() {
        return new UtrechtRootBorder("root");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleRoot());
    }
}
