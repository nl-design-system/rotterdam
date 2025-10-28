package nl.rotterdam.nl_design_system.wicket.components.link_list.utrecht;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.link.AbstractLink;

public class UtrechtLinkListLinkBehavior extends TagNameClassComponentBehavior<AbstractLink> {

    public UtrechtLinkListLinkBehavior() {
        super("a", RdLinkListLinkCss.DEFAULT);
        addHeaderItem(UtrechtLinkListBehavior.CSS);
    }
}
