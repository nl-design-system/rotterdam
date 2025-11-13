package nl.rotterdam.nl_design_system.wicket.components.html_content;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

/**
 * Render HTML content with behavior.
 */
public class RdHtmlContentBehavior extends TagNameClassComponentBehavior<RdHtmlContentBorder> {

    /**
     * Singleton instance.
     */
    public static final RdHtmlContentBehavior INSTANCE = new RdHtmlContentBehavior();

    private RdHtmlContentBehavior() {
        super("div", RdHtmlContentCss.DEFAULT);
        addHeaderItem(cssReferenceHeaderItem(RdHtmlContentBehavior.class, "@utrecht/html-content-css/dist/index.css"));
    }

}
