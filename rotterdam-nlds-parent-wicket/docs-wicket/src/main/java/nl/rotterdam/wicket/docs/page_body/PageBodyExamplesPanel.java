package nl.rotterdam.wicket.docs.page_body;

import nl.rotterdam.nl_design_system.wicket.components.page_body.utrecht.UtrechtPageBodyBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

public class PageBodyExamplesPanel extends ExamplesPanel {
    public PageBodyExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return UtrechtPageBodyBorder.class;
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
