package nl.rotterdam.nl_design_system.wicket.components.action_group;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;

class RdActionGroupBehavior extends TagNameClassComponentBehavior<Component> {

    public static final Behavior INSTANCE = new RdActionGroupBehavior();

    private RdActionGroupBehavior() {
        super("div", RdActionGroupCss.DEFAULT);
        addHeaderItem(cssReferenceHeaderItem(RdActionGroupBehavior.class, "@utrecht/button-group-css/dist/index.min.css"));
    }
}
