package nl.rotterdam.nl_design_system.wicket.components.side_nav.denhaag;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class DenhaagSideNavItemBehavior extends TagNameClassComponentBehavior<Component> {

    public DenhaagSideNavItemBehavior() {
        super("li", RdSideNavItemCss.DEFAULT);
        addHeaderItem(DenhaagSideNavBehavior.CSS);
    }
}
