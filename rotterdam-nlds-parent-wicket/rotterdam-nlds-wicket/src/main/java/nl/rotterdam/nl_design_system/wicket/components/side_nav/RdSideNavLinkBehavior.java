package nl.rotterdam.nl_design_system.wicket.components.side_nav;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class RdSideNavLinkBehavior extends TagNameClassComponentBehavior<Component> {

    public RdSideNavLinkBehavior() {
        super("a", RdSideNavLinkCss.DEFAULT);
        addHeaderItem(RdSideNavBehavior.CSS);
    }
}
