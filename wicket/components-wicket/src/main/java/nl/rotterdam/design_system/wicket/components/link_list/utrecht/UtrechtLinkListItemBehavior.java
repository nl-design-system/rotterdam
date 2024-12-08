package nl.rotterdam.design_system.wicket.components.link_list.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;

public class UtrechtLinkListItemBehavior extends TagNameClassComponentBehavior {

    public UtrechtLinkListItemBehavior() {
        super("li", "utrecht-link-list__item");
        addHeaderItem(UtrechtLinkListBehavior.CSS);
    }
}
