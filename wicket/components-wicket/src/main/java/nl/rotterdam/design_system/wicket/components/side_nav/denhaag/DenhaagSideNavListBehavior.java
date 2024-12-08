package nl.rotterdam.design_system.wicket.components.side_nav.denhaag;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;

public class DenhaagSideNavListBehavior extends TagNameClassComponentBehavior {

    public DenhaagSideNavListBehavior() {
        super("ul", "denhaag-sidenav__list");
        addHeaderItem(DenhaagSideNavBehavior.CSS);
    }
}
