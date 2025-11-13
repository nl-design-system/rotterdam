package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

class RdBreadcrumbNavBehavior extends TagNameClassComponentBehavior<Component> {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        RdBreadcrumbNavBehavior.class,
        "@utrecht/breadcrumb-nav-css/dist/index.css"
    );

    public RdBreadcrumbNavBehavior() {
        super("nav", RdBreadcrumbNavCss.DEFAULT);
        addHeaderItem(CSS);
    }
}
