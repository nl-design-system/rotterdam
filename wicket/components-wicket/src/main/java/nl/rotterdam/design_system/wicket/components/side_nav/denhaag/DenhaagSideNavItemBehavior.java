package nl.rotterdam.design_system.wicket.components.side_nav.denhaag;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;

public class DenhaagSideNavItemBehavior extends TagNameClassComponentBehavior {

    public DenhaagSideNavItemBehavior() {
        super("li", "denhaag-sidenav__item");
        addHeaderItem(DenhaagSideNavBehavior.CSS);
    }
}
