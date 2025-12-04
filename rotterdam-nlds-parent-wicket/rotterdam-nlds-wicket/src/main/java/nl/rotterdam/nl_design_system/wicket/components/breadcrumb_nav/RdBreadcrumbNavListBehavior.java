package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

/**
 * @see RdBreadcrumbNavPanel
 */
public class RdBreadcrumbNavListBehavior extends TagNameClassComponentBehavior<Component> {

    /**
     * Singleton instance.
     */
    public static final RdBreadcrumbNavListBehavior BREADCRUMB_NAV_LIST_BEHAVIOR =
        new RdBreadcrumbNavListBehavior();

    private RdBreadcrumbNavListBehavior() {
        super("ol", RdBreadcrumbNavListCss.LIST_ELEMENT);
        addHeaderItem(RdBreadcrumbNavBehavior.CSS);
    }
}
