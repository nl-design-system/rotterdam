package nl.rotterdam.design_system.wicket.components.breadcrumb_nav.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class UtrechtBreadcrumbNavLinkBehavior extends TagNameClassComponentBehavior<Component> {

    public UtrechtBreadcrumbNavLinkBehavior() {
        super("a", "utrecht-breadcrumb-nav__link");
        addHeaderItem(UtrechtBreadcrumbNavBehavior.CSS);
    }
}
