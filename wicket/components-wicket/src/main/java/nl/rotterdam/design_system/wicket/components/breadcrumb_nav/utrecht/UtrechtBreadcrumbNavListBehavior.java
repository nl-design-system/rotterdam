package nl.rotterdam.design_system.wicket.components.breadcrumb_nav.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;

public class UtrechtBreadcrumbNavListBehavior extends TagNameClassComponentBehavior {

    public UtrechtBreadcrumbNavListBehavior() {
        super("ul", "utrecht-breadcrumb-nav__list");
        addHeaderItem(UtrechtBreadcrumbNavBehavior.CSS);
    }
}
