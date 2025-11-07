package nl.rotterdam.wicket.docs.root;

import nl.rotterdam.nl_design_system.wicket.components.root.utrecht.UtrechtRootBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.markup.html.panel.Panel;

public class RootExamplesPanel extends Panel {
    public static final Class<?> COMPONENT_CLASS = UtrechtRootBorder.class;

    public RootExamplesPanel(String id) {
        super(id);
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
