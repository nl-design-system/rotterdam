package nl.rotterdam.nl_design_system.wicket.components.column_layout;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

class RdColumnLayoutBehavior extends TagNameClassComponentBehavior<RdColumnLayoutBorder> {

    static final RdColumnLayoutBehavior INSTANCE  = new RdColumnLayoutBehavior();

    private RdColumnLayoutBehavior() {
        super("div", RdColumnLayoutCss.DEFAULT);
        addHeaderItem(cssReferenceHeaderItem(RdColumnLayoutBehavior.class, "@utrecht/column-layout-css/dist/index.min.css"));
    }
}
