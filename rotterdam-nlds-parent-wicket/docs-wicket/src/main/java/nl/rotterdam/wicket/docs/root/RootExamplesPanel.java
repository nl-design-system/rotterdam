package nl.rotterdam.wicket.docs.root;

import nl.rotterdam.nl_design_system.wicket.components.root.RdRootBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

public class RootExamplesPanel extends ExamplesPanel {
    public RootExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdRootBorder.class;
    }

    @ComponentExample
    private static RdRootBorder exampleRoot() {
        return new RdRootBorder("root");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleRoot());
    }
}
