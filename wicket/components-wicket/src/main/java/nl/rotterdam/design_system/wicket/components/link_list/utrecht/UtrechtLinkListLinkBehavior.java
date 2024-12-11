package nl.rotterdam.design_system.wicket.components.link_list.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;

public class UtrechtLinkListLinkBehavior extends TagNameClassComponentBehavior {

    public UtrechtLinkListLinkBehavior() {
        super("a", "utrecht-link-list__link");
        addHeaderItem(UtrechtLinkListBehavior.CSS);
    }
}
