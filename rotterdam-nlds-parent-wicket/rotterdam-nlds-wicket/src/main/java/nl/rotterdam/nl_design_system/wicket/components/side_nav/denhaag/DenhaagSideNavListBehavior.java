package nl.rotterdam.nl_design_system.wicket.components.side_nav.denhaag;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class DenhaagSideNavListBehavior extends TagNameClassComponentBehavior<Component> {

    public static final DenhaagSideNavListBehavior DENHAAG_SIDE_NAV_LIST_BEHAVIOR = new DenhaagSideNavListBehavior();

    private DenhaagSideNavListBehavior() {
        super("ul", RdSideNavListCss.DEFAULT);
        addHeaderItem(DenhaagSideNavBehavior.CSS);
    }
}
