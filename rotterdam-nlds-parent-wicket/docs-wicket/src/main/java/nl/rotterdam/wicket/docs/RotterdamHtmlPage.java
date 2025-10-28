package nl.rotterdam.wicket.docs;

import nl.rotterdam.nl_design_system.wicket.components.html_content.utrecht.UtrechtHtmlContentBorder;

public class RotterdamHtmlPage extends RotterdamBasePage {

    @Override
    protected void onInitialize() {
        super.onInitialize();

        pageBody.add(new UtrechtHtmlContentBorder("html"));
    }
}
