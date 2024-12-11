package nl.rotterdam.wicket.docs;

import java.util.Arrays;
import java.util.stream.Collectors;
import nl.rotterdam.design_system.wicket.components.body.utrecht.UtrechtBodyBehavior;
import nl.rotterdam.design_system.wicket.components.link.utrecht.UtrechtBookmarkableLink;
import nl.rotterdam.design_system.wicket.components.logo.utrecht.UtrechtLogoBorder;
import nl.rotterdam.design_system.wicket.components.logo_image.rotterdam.RotterdamLogoImage;
import nl.rotterdam.design_system.wicket.components.page_body.utrecht.UtrechtPageBodyBorder;
import nl.rotterdam.design_system.wicket.components.page_footer.utrecht.UtrechtPageFooterBorder;
import nl.rotterdam.design_system.wicket.components.page_header.utrecht.UtrechtPageHeaderBorder;
import nl.rotterdam.design_system.wicket.components.page_layout.utrecht.UtrechtPageLayoutBorder;
import nl.rotterdam.design_system.wicket.components.root.utrecht.UtrechtRootBehavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

public class RotterdamBasePage extends BasePage {

    public UtrechtPageLayoutBorder pageLayout;
    public UtrechtPageHeaderBorder pageHeader;
    public UtrechtPageBodyBorder pageBody;
    public UtrechtPageFooterBorder pageFooter;
    private UtrechtLogoBorder logo;
    private String siteTitle = "rotterdam.nl";
    public String pageTitle;
    public String stepTitle;
    public String errorTitle;
    public String titlePartSeparator = " · ";

    @Override
    protected void onInitialize() {
        super.onInitialize();

        // Build up the page layout
        pageLayout = new UtrechtPageLayoutBorder("utrechtPageLayout");
        add(pageLayout);

        pageHeader = new UtrechtPageHeaderBorder("utrechtPageHeader");
        pageLayout.add(pageHeader);

        logo = new UtrechtLogoBorder("utrechtLogo");
        pageHeader.add(logo);

        // Use Apache Wicket API to determine the internal homepage
        // TODO: Allow configuring an external homepage URL, outside of this application.
        Link<?> logoLink = new UtrechtBookmarkableLink<>("logoLink", getApplication().getHomePage());
        logo.add(logoLink);

        logoLink.add(new RotterdamLogoImage("rotterdamLogoImage"));

        pageBody = new UtrechtPageBodyBorder("utrechtPageBody");
        pageLayout.add(pageBody);

        pageFooter = new UtrechtPageFooterBorder("utrechtPageFooter");
        pageLayout.add(pageFooter);

        String[] titleParts = new String[] { this.errorTitle, this.stepTitle, this.pageTitle, this.siteTitle };

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

        response.render(UtrechtRootBehavior.CSS);
        response.render(UtrechtBodyBehavior.CSS);
    }
}
