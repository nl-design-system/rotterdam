package nl.rotterdam.wicket.docs.page_footer;

import nl.rotterdam.nl_design_system.wicket.components.page_footer.utrecht.UtrechtPageFooterBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

public class PageFooterExamplesPanel extends ExamplesPanel {
    public PageFooterExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return UtrechtPageFooterBorder.class;
    }

    @ComponentExample
    private static UtrechtPageFooterBorder examplePageFooter() {
        return new UtrechtPageFooterBorder("pageFooter");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(examplePageFooter());
    }
}
