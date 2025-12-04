package nl.rotterdam.nl_design_system.wicket.components.link_list;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;

class RdLinkListItemBehavior extends TagNameClassComponentBehavior<Component> {

    static final Behavior INSTANCE = new RdLinkListItemBehavior();

    private RdLinkListItemBehavior() {
        super("li", RdLinkListItemCss.ITEM_ELEMENT);
        addHeaderItem(RdLinkListBehavior.CSS);
    }
}
