package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

class RdBreadcrumbNavItemBehavior extends TagNameClassComponentBehavior<Component> {

    static final RdBreadcrumbNavItemBehavior INSTANCE =
        new RdBreadcrumbNavItemBehavior();

    private RdBreadcrumbNavItemBehavior() {
        super("li", RdBreadcrumbNavItemCss.DEFAULT);
        addHeaderItem(RdBreadcrumbNavBehavior.CSS);
    }
}
