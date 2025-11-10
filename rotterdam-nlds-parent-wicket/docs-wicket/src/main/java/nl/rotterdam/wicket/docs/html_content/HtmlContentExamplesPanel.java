package nl.rotterdam.wicket.docs.html_content;

import nl.rotterdam.nl_design_system.wicket.components.html_content.utrecht.UtrechtHtmlContentBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;

public class HtmlContentExamplesPanel extends ExamplesPanel {
    public HtmlContentExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return UtrechtHtmlContentBorder.class;
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
