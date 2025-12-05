package nl.rotterdam.nl_design_system.wicket.components.side_nav;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

class RdSideNavListBehavior extends TagNameClassComponentBehavior<Component> {

    static final RdSideNavListBehavior INSTANCE = new RdSideNavListBehavior();

    private RdSideNavListBehavior() {
        super("ul", RdSideNavListCss.LIST_ELEMENT);
        addHeaderItem(RdSideNavBehavior.CSS);
    }
}
