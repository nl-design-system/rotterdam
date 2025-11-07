package nl.rotterdam.wicket.docs.page_body;

import nl.rotterdam.nl_design_system.wicket.components.page_body.utrecht.UtrechtPageBodyBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.markup.html.panel.Panel;

public class PageBodyExamplesPanel extends Panel {
    public static final Class<?> COMPONENT_CLASS = UtrechtPageBodyBorder.class;


    public PageBodyExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static UtrechtPageBodyBorder examplePageBody() {
        return new UtrechtPageBodyBorder("pageBody");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(examplePageBody());
    }
}
