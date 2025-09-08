package nl.rotterdam.design_system.wicket.components.breadcrumb_nav.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;

public class UtrechtBreadcrumbNavItemBehavior extends TagNameClassComponentBehavior {

    public static final UtrechtBreadcrumbNavItemBehavior UTRECHT_BREADCRUMB_NAV_ITEM_BEHAVIOR = new UtrechtBreadcrumbNavItemBehavior();

    private UtrechtBreadcrumbNavItemBehavior() {
        super("li", "utrecht-breadcrumb-nav__item");
        addHeaderItem(UtrechtBreadcrumbNavBehavior.CSS);
    }
}
