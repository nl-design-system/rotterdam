package nl.rotterdam.nl_design_system.docs.wicket.body;

import nl.rotterdam.nl_design_system.wicket.components.body.RdBodyBorder;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;

public class BodyExamplesPanel extends ExamplesPanel {
    public BodyExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdBodyBorder.class;
    }

    @ComponentExample
    private static RdBodyBorder exampleBody() {
        return new RdBodyBorder("body");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleBody());
    }
}
