package nl.rotterdam.wicket.docs.page_layout;

import nl.rotterdam.design_system.wicket.components.page_layout.utrecht.UtrechtPageLayout;
import org.apache.wicket.markup.html.panel.Panel;

public class PageLayoutExamplesPanel extends Panel {

    public PageLayoutExamplesPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new UtrechtPageLayout("utrechtPageLayout1"));
    }
}
