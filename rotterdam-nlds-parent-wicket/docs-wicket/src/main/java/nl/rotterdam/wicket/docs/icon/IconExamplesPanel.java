package nl.rotterdam.wicket.docs.icon;

import nl.rotterdam.nl_design_system.wicket.components.icon.utrecht.UtrechtIconBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

public class IconExamplesPanel extends ExamplesPanel {
    public IconExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return UtrechtIconBorder.class;
    }

    @ComponentExample
    private static UtrechtIconBorder exampleIconComponent() {
        return new UtrechtIconBorder("icon");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleIconComponent());
    }
}
