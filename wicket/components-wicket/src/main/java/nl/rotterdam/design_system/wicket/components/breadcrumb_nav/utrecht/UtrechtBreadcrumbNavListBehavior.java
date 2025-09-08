package nl.rotterdam.design_system.wicket.components.breadcrumb_nav.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;

public class UtrechtBreadcrumbNavListBehavior extends TagNameClassComponentBehavior {

    public static final UtrechtBreadcrumbNavListBehavior UTRECHT_BREADCRUMB_NAV_LIST_BEHAVIOR = new UtrechtBreadcrumbNavListBehavior();

    private UtrechtBreadcrumbNavListBehavior() {
        super("ul", "utrecht-breadcrumb-nav__list");
        addHeaderItem(UtrechtBreadcrumbNavBehavior.CSS);
    }
}
