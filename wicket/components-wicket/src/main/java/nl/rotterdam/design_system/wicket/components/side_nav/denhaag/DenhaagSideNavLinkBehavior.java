package nl.rotterdam.design_system.wicket.components.side_nav.denhaag;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;

public class DenhaagSideNavLinkBehavior extends TagNameClassComponentBehavior {

    public DenhaagSideNavLinkBehavior() {
        super("a", "denhaag-sidenav__link");
        addHeaderItem(DenhaagSideNavBehavior.CSS);
    }
}
