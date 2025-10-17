package nl.rotterdam.wicket.docs.root;

import nl.rotterdam.design_system.wicket.components.root.utrecht.UtrechtRootBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class RootExamplesPanel extends Panel {

    public RootExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleRoot() {
        return new UtrechtRootBorder("root");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleRoot());
    }
}
