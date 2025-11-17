package nl.rotterdam.nl_design_system.docs.wicket.html_content;

import nl.rotterdam.nl_design_system.wicket.components.html_content.RdHtmlContentBorder;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;

public class HtmlContentExamplesPanel extends ExamplesPanel {
    public HtmlContentExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdHtmlContentBorder.class;
    }

    @ComponentExample
    private static RdHtmlContentBorder exampleHtmlContent() {
        return new RdHtmlContentBorder("htmlContent");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleHtmlContent());
    }
}
