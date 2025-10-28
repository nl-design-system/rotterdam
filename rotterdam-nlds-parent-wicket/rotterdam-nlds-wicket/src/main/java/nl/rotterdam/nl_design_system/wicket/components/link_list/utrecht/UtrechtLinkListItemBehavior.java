package nl.rotterdam.nl_design_system.wicket.components.link_list.utrecht;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class UtrechtLinkListItemBehavior extends TagNameClassComponentBehavior<Component> {

    public UtrechtLinkListItemBehavior() {
        super("li", RdLinkListItemCss.DEFAULT);
        addHeaderItem(UtrechtLinkListBehavior.CSS);
    }
}
