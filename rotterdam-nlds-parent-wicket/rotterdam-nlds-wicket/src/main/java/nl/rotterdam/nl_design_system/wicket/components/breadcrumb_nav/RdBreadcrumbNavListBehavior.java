package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class RdBreadcrumbNavListBehavior extends TagNameClassComponentBehavior<Component> {

    public static final RdBreadcrumbNavListBehavior BREADCRUMB_NAV_LIST_BEHAVIOR =
        new RdBreadcrumbNavListBehavior();

    private RdBreadcrumbNavListBehavior() {
        super("ul", RdBreadcrumbNavListCss.DEFAULT);
        addHeaderItem(RdBreadcrumbNavBehavior.CSS);
    }
}
