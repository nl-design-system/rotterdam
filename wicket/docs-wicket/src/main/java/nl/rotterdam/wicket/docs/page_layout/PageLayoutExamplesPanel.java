package nl.rotterdam.wicket.docs.page_layout;

import nl.rotterdam.design_system.wicket.components.page_layout.utrecht.UtrechtPageLayoutBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.markup.html.panel.Panel;

public class PageLayoutExamplesPanel extends Panel {

    public PageLayoutExamplesPanel(String id) {
        super(id);
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
