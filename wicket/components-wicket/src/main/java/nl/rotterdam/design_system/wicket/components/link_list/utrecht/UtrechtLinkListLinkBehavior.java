package nl.rotterdam.design_system.wicket.components.link_list.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.link.AbstractLink;

public class UtrechtLinkListLinkBehavior extends TagNameClassComponentBehavior<AbstractLink> {

    public UtrechtLinkListLinkBehavior() {
        super("a", "utrecht-link-list__link");
        addHeaderItem(UtrechtLinkListBehavior.CSS);
    }
}
