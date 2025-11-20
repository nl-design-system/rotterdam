package nl.rotterdam.nl_design_system.wicket.components.page_body;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

/**
 * Body vs PageBody, unclear what should be used.
 * @deprecated  what is difference between Body and PageBody?
 */
@Deprecated
class RdPageBodyBehavior extends TagNameClassComponentBehavior<RdPageBodyBorder> {

    static final RdPageBodyBehavior INSTANCE = new RdPageBodyBehavior();

    private RdPageBodyBehavior() {
        super("div", RdPageBodyCss.DEFAULT);
        addHeaderItem(cssReferenceHeaderItem(RdPageBodyBehavior.class, "@utrecht/page-body-css/dist/index.min.css"));
    }

}
