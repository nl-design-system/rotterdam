package nl.rotterdam.nl_design_system.wicket.components.action_group;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

class RdActionGroupBehavior extends TagNameClassComponentBehavior<Component> {

    public static final Behavior INSTANCE = new RdActionGroupBehavior();

    private RdActionGroupBehavior() {
        super("div", RdActionGroupCss.BASE);
        addHeaderItem(cssReferenceHeaderItem(RdActionGroupBehavior.class, "@utrecht/button-group-css/dist/index.min.css"));
    }
}
