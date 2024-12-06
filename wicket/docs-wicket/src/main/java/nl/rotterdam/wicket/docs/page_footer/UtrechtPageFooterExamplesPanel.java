package nl.rotterdam.wicket.docs.page_footer;

import nl.rotterdam.design_system.wicket.components.page_footer.utrecht.UtrechtPageFooterBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class UtrechtPageFooterExamplesPanel extends Panel {

    public UtrechtPageFooterExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component examplePageFooter() {
        return new UtrechtPageFooterBorder("utrechtPageFooter");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(examplePageFooter());
    }
}
