package nl.rotterdam.nl_design_system.wicket.components.page_footer;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class RdPageFooterBehavior extends TagNameClassComponentBehavior<RdPageFooterBorder> {

    public static final RdPageFooterBehavior INSTANCE = new RdPageFooterBehavior();

    private RdPageFooterBehavior() {
        super("footer", RdPageFooterCss.DEFAULT);
        addHeaderItem(cssReferenceHeaderItem(RdPageFooterBehavior.class, "@utrecht/page-footer-css/dist/index.css"));
    }

}
