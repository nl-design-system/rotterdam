package nl.rotterdam.design_system.wicket.components.side_nav.denhaag;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class DenhaagSideNavLinkBehavior extends TagNameClassComponentBehavior<Component> {

    public DenhaagSideNavLinkBehavior() {
        super("a", "denhaag-sidenav__link");
        addHeaderItem(DenhaagSideNavBehavior.CSS);
    }
}
