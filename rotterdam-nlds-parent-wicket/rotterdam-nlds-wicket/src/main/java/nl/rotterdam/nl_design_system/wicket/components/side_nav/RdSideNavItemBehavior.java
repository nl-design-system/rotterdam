package nl.rotterdam.nl_design_system.wicket.components.side_nav;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class RdSideNavItemBehavior extends TagNameClassComponentBehavior<Component> {

    public RdSideNavItemBehavior() {
        super("li", RdSideNavItemCss.DEFAULT);
        addHeaderItem(RdSideNavBehavior.CSS);
    }
}
