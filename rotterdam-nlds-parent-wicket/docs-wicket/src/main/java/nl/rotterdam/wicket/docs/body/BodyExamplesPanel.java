package nl.rotterdam.wicket.docs.body;

import nl.rotterdam.nl_design_system.wicket.components.body.utrecht.UtrechtBodyBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

public class BodyExamplesPanel extends ExamplesPanel {
    public BodyExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return UtrechtBodyBorder.class;
    }

    @ComponentExample
    private static UtrechtBodyBorder exampleBody() {
        return new UtrechtBodyBorder("body");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleBody());
    }
}
