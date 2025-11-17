package nl.rotterdam.nl_design_system.docs.wicket.page_body;

import nl.rotterdam.nl_design_system.wicket.components.page_body.RdPageBodyBorder;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;

public class PageBodyExamplesPanel extends ExamplesPanel {
    public PageBodyExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdPageBodyBorder.class;
    }

    @ComponentExample
    private static RdPageBodyBorder examplePageBody() {
        return new RdPageBodyBorder("pageBody");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(examplePageBody());
    }
}
