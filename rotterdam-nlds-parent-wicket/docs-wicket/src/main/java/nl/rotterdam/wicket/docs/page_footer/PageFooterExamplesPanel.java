package nl.rotterdam.wicket.docs.page_footer;

import nl.rotterdam.nl_design_system.wicket.components.page_footer.RdPageFooterBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

public class PageFooterExamplesPanel extends ExamplesPanel {
    public PageFooterExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdPageFooterBorder.class;
    }

    @ComponentExample
    private static RdPageFooterBorder examplePageFooter() {
        return new RdPageFooterBorder("pageFooter");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(examplePageFooter());
    }
}
