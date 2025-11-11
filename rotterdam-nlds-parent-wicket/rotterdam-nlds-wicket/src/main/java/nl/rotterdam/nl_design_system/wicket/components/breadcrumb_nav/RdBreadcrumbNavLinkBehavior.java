package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class RdBreadcrumbNavLinkBehavior extends TagNameClassComponentBehavior<Component> {

    public RdBreadcrumbNavLinkBehavior() {
        super("a", RdBreadcrumbNavLinkCss.DEFAULT);
        addHeaderItem(RdBreadcrumbNavBehavior.CSS);
    }
}
