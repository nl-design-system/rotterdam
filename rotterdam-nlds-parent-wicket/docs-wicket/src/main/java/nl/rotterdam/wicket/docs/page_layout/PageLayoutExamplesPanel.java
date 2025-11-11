package nl.rotterdam.wicket.docs.page_layout;

import nl.rotterdam.nl_design_system.wicket.components.page_layout.RdPageLayoutBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

public class PageLayoutExamplesPanel extends ExamplesPanel {
    public PageLayoutExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdPageLayoutBorder.class;
    }

    @ComponentExample
    private static RdPageLayoutBorder examplePageLayout() {
        return new RdPageLayoutBorder("pageLayout");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(examplePageLayout());
    }
}
