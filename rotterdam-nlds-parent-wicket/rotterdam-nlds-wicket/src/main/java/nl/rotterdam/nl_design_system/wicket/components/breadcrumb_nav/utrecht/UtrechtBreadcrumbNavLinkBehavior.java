package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav.utrecht;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class UtrechtBreadcrumbNavLinkBehavior extends TagNameClassComponentBehavior<Component> {

    public UtrechtBreadcrumbNavLinkBehavior() {
        super("a", RdBreadcrumbNavLinkCss.DEFAULT);
        addHeaderItem(UtrechtBreadcrumbNavBehavior.CSS);
    }
}
