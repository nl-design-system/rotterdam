package nl.rotterdam.wicket.docs.icon;

import nl.rotterdam.nl_design_system.wicket.components.icon.RdIconBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

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
