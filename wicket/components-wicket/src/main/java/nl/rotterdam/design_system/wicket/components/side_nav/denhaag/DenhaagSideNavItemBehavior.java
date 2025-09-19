package nl.rotterdam.design_system.wicket.components.side_nav.denhaag;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class DenhaagSideNavItemBehavior extends TagNameClassComponentBehavior<Component> {

    public DenhaagSideNavItemBehavior() {
        super("li", "denhaag-sidenav__item");
        addHeaderItem(DenhaagSideNavBehavior.CSS);
    }
}
