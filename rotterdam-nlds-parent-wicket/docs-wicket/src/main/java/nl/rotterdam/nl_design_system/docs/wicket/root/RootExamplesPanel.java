package nl.rotterdam.nl_design_system.docs.wicket.root;

import nl.rotterdam.nl_design_system.wicket.components.root.RdRootBorder;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;

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
