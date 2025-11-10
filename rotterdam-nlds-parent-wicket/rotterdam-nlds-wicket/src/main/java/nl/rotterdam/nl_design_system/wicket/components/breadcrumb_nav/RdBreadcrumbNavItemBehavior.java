package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class RdBreadcrumbNavItemBehavior extends TagNameClassComponentBehavior<Component> {

    public static final RdBreadcrumbNavItemBehavior BREADCRUMB_NAV_ITEM_BEHAVIOR =
        new RdBreadcrumbNavItemBehavior();

    private RdBreadcrumbNavItemBehavior() {
        super("li", RdBreadcrumbNavItemCss.DEFAULT);
        addHeaderItem(RdBreadcrumbNavBehavior.CSS);
    }
}
