package nl.rotterdam.nl_design_system.wicket.components.page_layout;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class RdPageLayoutBehavior extends TagNameClassComponentBehavior<RdPageLayoutBorder> {

    public static final RdPageLayoutBehavior INSTANCE = new RdPageLayoutBehavior();

    private RdPageLayoutBehavior() {
        super("div", RdPageLayoutCss.DEFAULT);
        addHeaderItem(cssReferenceHeaderItem(RdPageLayoutBehavior.class, "@utrecht/page-layout-css/dist/index.css"));
    }

}
