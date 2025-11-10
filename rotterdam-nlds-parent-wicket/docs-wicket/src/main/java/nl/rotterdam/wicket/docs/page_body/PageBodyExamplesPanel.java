package nl.rotterdam.wicket.docs.page_body;

import nl.rotterdam.nl_design_system.wicket.components.page_body.RdPageBodyBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

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
