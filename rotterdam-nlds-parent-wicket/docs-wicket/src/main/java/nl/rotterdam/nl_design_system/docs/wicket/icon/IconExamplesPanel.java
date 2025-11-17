package nl.rotterdam.nl_design_system.docs.wicket.icon;

import nl.rotterdam.nl_design_system.wicket.components.icon.RdIconBorder;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;

public class IconExamplesPanel extends ExamplesPanel {
    public IconExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdIconBorder.class;
    }

    @ComponentExample
    private static RdIconBorder exampleIconComponent() {
        return new RdIconBorder("icon");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleIconComponent());
    }
}
