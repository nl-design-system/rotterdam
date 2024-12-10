package nl.rotterdam.design_system.wicket.components.breadcrumb_nav.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;

public class UtrechtBreadcrumbNavItemBehavior extends TagNameClassComponentBehavior {

    public UtrechtBreadcrumbNavItemBehavior() {
        super("li", "utrecht-breadcrumb-nav__item");
        addHeaderItem(UtrechtBreadcrumbNavBehavior.CSS);
    }
}
