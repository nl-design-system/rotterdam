package nl.rotterdam.wicket.docs.page_footer;

import nl.rotterdam.nl_design_system.wicket.components.page_footer.utrecht.UtrechtPageFooterBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.markup.html.panel.Panel;

public class PageFooterExamplesPanel extends Panel {
    public static final Class<?> COMPONENT_CLASS = UtrechtPageFooterBorder.class;

    public PageFooterExamplesPanel(String id) {
        super(id);
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
