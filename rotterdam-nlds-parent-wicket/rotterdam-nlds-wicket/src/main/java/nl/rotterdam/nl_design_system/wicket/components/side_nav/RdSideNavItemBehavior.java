package nl.rotterdam.nl_design_system.wicket.components.side_nav;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;


/**
 * Behavior for list item.
 */
class RdSideNavItemBehavior extends TagNameClassComponentBehavior<Component> {

    static final RdSideNavItemBehavior INSTANCE = new RdSideNavItemBehavior();

    private RdSideNavItemBehavior() {
        super("li", RdSideNavItemCss.DEFAULT);
        addHeaderItem(RdSideNavBehavior.CSS);
    }
}
