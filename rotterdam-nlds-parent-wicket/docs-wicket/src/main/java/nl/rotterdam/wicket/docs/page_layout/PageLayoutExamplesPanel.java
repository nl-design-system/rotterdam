package nl.rotterdam.wicket.docs.page_layout;

import nl.rotterdam.nl_design_system.wicket.components.page_layout.utrecht.UtrechtPageLayoutBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

public class PageLayoutExamplesPanel extends ExamplesPanel {
    public PageLayoutExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return UtrechtPageLayoutBorder.class;
    }

    @ComponentExample
    private static UtrechtPageLayoutBorder examplePageLayout() {
        return new UtrechtPageLayoutBorder("pageLayout");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(examplePageLayout());
    }
}
