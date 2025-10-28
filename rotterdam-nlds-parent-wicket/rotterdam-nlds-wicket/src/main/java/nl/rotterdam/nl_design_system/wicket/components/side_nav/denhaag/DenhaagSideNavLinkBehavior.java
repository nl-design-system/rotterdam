package nl.rotterdam.nl_design_system.wicket.components.side_nav.denhaag;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class DenhaagSideNavLinkBehavior extends TagNameClassComponentBehavior<Component> {

    public DenhaagSideNavLinkBehavior() {
        super("a", RdSideNavLinkCss.DEFAULT);
        addHeaderItem(DenhaagSideNavBehavior.CSS);
    }
}
