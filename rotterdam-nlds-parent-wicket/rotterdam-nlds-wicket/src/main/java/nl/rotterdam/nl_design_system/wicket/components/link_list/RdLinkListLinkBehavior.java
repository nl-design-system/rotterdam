package nl.rotterdam.nl_design_system.wicket.components.link_list;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.link.AbstractLink;

public class RdLinkListLinkBehavior extends TagNameClassComponentBehavior<AbstractLink> {

    public RdLinkListLinkBehavior() {
        super("a", RdLinkListLinkCss.DEFAULT);
        addHeaderItem(RdLinkListBehavior.CSS);
    }
}
