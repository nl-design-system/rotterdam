package nl.rotterdam.wicket.docs.html_content;

import nl.rotterdam.design_system.wicket.components.html_content.utrecht.UtrechtHtmlContentBorder;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class HtmlContentExamplesPanel extends Panel {

    public HtmlContentExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleHtmlContent() {
        return new UtrechtHtmlContentBorder("utrechtHtmlContent");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleHtmlContent());
    }
}
