package nl.rotterdam.nl_design_system.wicket.components.side_nav;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class RdSideNavListBehavior extends TagNameClassComponentBehavior<Component> {

    public static final RdSideNavListBehavior SIDE_NAV_LIST_BEHAVIOR = new RdSideNavListBehavior();

    private RdSideNavListBehavior() {
        super("ul", RdSideNavListCss.DEFAULT);
        addHeaderItem(RdSideNavBehavior.CSS);
    }
}
