package nl.rotterdam.wicket.docs.page_body;

import nl.rotterdam.design_system.wicket.components.page_body.utrecht.UtrechtPageBodyBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class UtrechtPageBodyExamplesPanel extends Panel {

    public UtrechtPageBodyExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component examplePageBody() {
        return new UtrechtPageBodyBorder("utrechtPageBody");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(examplePageBody());
    }
}
