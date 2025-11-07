package nl.rotterdam.wicket.docs.html_content;

import nl.rotterdam.nl_design_system.wicket.components.html_content.utrecht.UtrechtHtmlContentBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.markup.html.panel.Panel;

public class HtmlContentExamplesPanel extends Panel {
    public static final Class<?> COMPONENT_CLASS = UtrechtHtmlContentBorder.class;

    public HtmlContentExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static UtrechtHtmlContentBorder exampleHtmlContent() {
        return new UtrechtHtmlContentBorder("htmlContent");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleHtmlContent());
    }
}
