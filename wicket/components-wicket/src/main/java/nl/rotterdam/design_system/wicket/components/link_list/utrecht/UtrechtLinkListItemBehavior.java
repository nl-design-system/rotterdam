package nl.rotterdam.design_system.wicket.components.link_list.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class UtrechtLinkListItemBehavior extends TagNameClassComponentBehavior<Component> {

    public UtrechtLinkListItemBehavior() {
        super("li", "utrecht-link-list__item");
        addHeaderItem(UtrechtLinkListBehavior.CSS);
    }
}
