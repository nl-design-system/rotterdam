package nl.rotterdam.nl_design_system.docs.wicket.page_layout;

import nl.rotterdam.nl_design_system.wicket.components.page_layout.RdPageLayoutBorder;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;

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
