package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

class RdBreadcrumbNavLinkBehavior extends TagNameClassComponentBehavior<Component> {

    RdBreadcrumbNavLinkBehavior() {
        super("a", RdBreadcrumbNavLinkCss.LINK_ELEMENT);
        addHeaderItem(RdBreadcrumbNavBehavior.CSS);
    }
}
