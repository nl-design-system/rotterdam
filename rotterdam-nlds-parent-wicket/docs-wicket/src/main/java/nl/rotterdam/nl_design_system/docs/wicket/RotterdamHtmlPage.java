package nl.rotterdam.nl_design_system.docs.wicket;

import nl.rotterdam.nl_design_system.wicket.components.html_content.RdHtmlContentBorder;

public class RotterdamHtmlPage extends RotterdamBasePage {

    public RotterdamHtmlPage(String pageTitle) {
        super(pageTitle);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        pageBody.add(new RdHtmlContentBorder("html"));
    }
}
