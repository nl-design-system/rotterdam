package nl.rotterdam.nl_design_system.wicket.components.page_header;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class RdPageHeaderBehavior extends TagNameClassComponentBehavior<RdPageHeaderBorder> {

    public static final RdPageHeaderBehavior INSTANCE = new RdPageHeaderBehavior();

    private RdPageHeaderBehavior() {
        super("header", RdPageHeaderCss.DEFAULT);
        addHeaderItem(cssReferenceHeaderItem(RdPageHeaderBehavior.class, "@utrecht/page-header-css/dist/index.css"));
    }

}
