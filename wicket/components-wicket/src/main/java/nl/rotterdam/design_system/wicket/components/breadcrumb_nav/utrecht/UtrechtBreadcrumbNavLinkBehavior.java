package nl.rotterdam.design_system.wicket.components.breadcrumb_nav.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;

public class UtrechtBreadcrumbNavLinkBehavior extends TagNameClassComponentBehavior {

    public UtrechtBreadcrumbNavLinkBehavior() {
        super("a", "utrecht-breadcrumb-nav__link");
        addHeaderItem(UtrechtBreadcrumbNavBehavior.CSS);
    }
}
