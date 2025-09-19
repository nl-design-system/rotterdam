package nl.rotterdam.design_system.wicket.components.breadcrumb_nav.utrecht;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

public class UtrechtBreadcrumbNavBehavior extends TagNameClassComponentBehavior<Component> {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtBreadcrumbNavBehavior.class,
        "@utrecht/breadcrumb-nav-css/dist/index.css"
    );

    public UtrechtBreadcrumbNavBehavior() {
        super("nav", "utrecht-breadcrumb-nav");
        addHeaderItem(CSS);
    }
}
