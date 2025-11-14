package nl.rotterdam.wicket.docs;

import nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_logo.RotterdamLogoImage;
import nl.rotterdam.nl_design_system.wicket.components.body.RdBodyBehavior;
import nl.rotterdam.nl_design_system.wicket.components.link.RdBookmarkableLink;
import nl.rotterdam.nl_design_system.wicket.components.logo.RdLogoBorder;
import nl.rotterdam.nl_design_system.wicket.components.page_body.RdPageBodyBorder;
import nl.rotterdam.nl_design_system.wicket.components.page_footer.RdPageFooterBorder;
import nl.rotterdam.nl_design_system.wicket.components.page_header.RdPageHeaderBorder;
import nl.rotterdam.nl_design_system.wicket.components.page_layout.RdPageLayoutBorder;
import nl.rotterdam.nl_design_system.wicket.components.root.RdRootBehavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import java.util.Arrays;
import java.util.stream.Collectors;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class RotterdamBasePage extends DocsBasePage {

    protected static final String titlePartSeparator = " · ";

    protected RdPageLayoutBorder pageLayout;
    protected RdPageHeaderBorder pageHeader;
    protected RdPageBodyBorder pageBody;
    protected RdPageFooterBorder pageFooter;
    protected String pageTitle;
    protected String stepTitle;
    protected String errorTitle;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(RdRootBehavior.INSTANCE);

        // Build up the page layout
        pageLayout = new RdPageLayoutBorder("pageLayout");
        add(pageLayout);

        pageHeader = new RdPageHeaderBorder("pageHeader");
        pageLayout.add(pageHeader);

        RdLogoBorder logo = new RdLogoBorder("logo");
        pageHeader.add(logo);

        // Use Apache Wicket API to determine the internal homepage
        // TODO: Allow configuring an external homepage URL, outside of this application.
        Link<?> logoLink = new RdBookmarkableLink<>("logoLink", getApplication().getHomePage());
        logo.add(logoLink);

        logoLink.add(new RotterdamLogoImage("rotterdamLogoImage"));

        pageBody = new RdPageBodyBorder("pageBody");
        pageLayout.add(pageBody);

        pageFooter = new RdPageFooterBorder("pageFooter");
        pageLayout.add(pageFooter);

        String siteTitle = "rotterdam.nl";
        String[] titleParts = new String[] { this.errorTitle, this.stepTitle, this.pageTitle, siteTitle };

        add(
            new Label(
                "title",
                Arrays.stream(titleParts)
                    .filter(part -> part != null && !part.trim().isEmpty())
                    .collect(Collectors.joining(titlePartSeparator))
            )
        );
    }

    public RotterdamBasePage() {}

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        // Add the style of the following components directly, because I don't know how to apply a behavior to the <head> and <html> elements
        // - Root for <html>
        // - Body for <body>

        response.render(cssReferenceHeaderItem(RdBodyBehavior.class, "@utrecht/body-css/dist/index.css"));
    }
}
