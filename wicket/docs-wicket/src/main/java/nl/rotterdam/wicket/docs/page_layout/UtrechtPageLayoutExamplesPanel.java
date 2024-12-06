package nl.rotterdam.wicket.docs.page_layout;

import nl.rotterdam.design_system.wicket.components.page_layout.utrecht.UtrechtPageLayoutBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class UtrechtPageLayoutExamplesPanel extends Panel {

    public UtrechtPageLayoutExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component examplePageLayout() {
        return new UtrechtPageLayoutBorder("utrechtPageLayout");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(examplePageLayout());
    }
}
