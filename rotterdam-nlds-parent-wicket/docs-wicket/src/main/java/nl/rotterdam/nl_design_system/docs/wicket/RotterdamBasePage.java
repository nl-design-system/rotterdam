package nl.rotterdam.nl_design_system.docs.wicket;

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
import org.jspecify.annotations.Nullable;

import java.util.Arrays;
import java.util.stream.Collectors;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class RotterdamBasePage extends DocsBasePage {

    protected static final String titlePartSeparator = " · ";

    protected final RdPageLayoutBorder pageLayout;
    protected final RdPageHeaderBorder pageHeader;
    protected final RdPageBodyBorder pageBody;
    protected final RdPageFooterBorder pageFooter;
    protected final String pageTitle;
    @Nullable
    protected String stepTitle;
    @Nullable
    protected String errorTitle;


    public RotterdamBasePage(String pageTitle) {
        pageLayout = new RdPageLayoutBorder("pageLayout");
        pageHeader = new RdPageHeaderBorder("pageHeader");
        pageBody = new RdPageBodyBorder("pageBody");
        pageFooter = new RdPageFooterBorder("pageFooter");
        this.pageTitle = pageTitle;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(RdRootBehavior.INSTANCE);

        RdLogoBorder logo = new RdLogoBorder("logo");

        // Use Apache Wicket API to determine the internal homepage
        // TODO: Allow configuring an external homepage URL, outside of this application.
        Link<?> logoLink = new RdBookmarkableLink<>("logoLink", getApplication().getHomePage());

        String siteTitle = "rotterdam.nl";
        @Nullable String[] titleParts = new @Nullable String[] { this.errorTitle, this.stepTitle, this.pageTitle, siteTitle };

        // Build up the page layout
        add(
            pageLayout.add(
                pageHeader.add(
                    logo.add(
                        logoLink.add(
                            new RotterdamLogoImage("rotterdamLogoImage")
                        )
                    )
                ),
                pageBody,
                pageFooter),
            new Label(
                "title",
                Arrays.stream(titleParts)
                    .filter(part -> part != null && !part.trim().isEmpty())
                    .collect(Collectors.joining(titlePartSeparator))
            ));
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        // Add the style of the following components directly, because I don't know how to apply a behavior to the <head> and <html> elements
        // - Root for <html>
        // - Body for <body>

        // TODO: RdBodyBorder instead of loading the CSS directly.
        response.render(cssReferenceHeaderItem(RdBodyBehavior.class, "@utrecht/body-css/dist/index.min.css"));
    }
}
