package nl.rotterdam.nl_design_system.wicket.components.link_list;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class RdLinkListItemBehavior extends TagNameClassComponentBehavior<Component> {

    public RdLinkListItemBehavior() {
        super("li", RdLinkListItemCss.DEFAULT);
        addHeaderItem(RdLinkListBehavior.CSS);
    }
}
