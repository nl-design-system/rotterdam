package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav.utrecht;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class UtrechtBreadcrumbNavListBehavior extends TagNameClassComponentBehavior<Component> {

    public static final UtrechtBreadcrumbNavListBehavior UTRECHT_BREADCRUMB_NAV_LIST_BEHAVIOR =
        new UtrechtBreadcrumbNavListBehavior();

    private UtrechtBreadcrumbNavListBehavior() {
        super("ul", RdBreadcrumbNavListCss.DEFAULT);
        addHeaderItem(UtrechtBreadcrumbNavBehavior.CSS);
    }
}
