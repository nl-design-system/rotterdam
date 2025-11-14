package nl.rotterdam.wicket.docs;

import nl.rotterdam.nl_design_system.wicket.components.html_content.RdHtmlContentBorder;

public class RotterdamPlaceholderPage extends RotterdamBasePage {
    public RotterdamPlaceholderPage() {
        super("Placeholder");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        pageBody.add(new RdHtmlContentBorder("html"));
    }
}
