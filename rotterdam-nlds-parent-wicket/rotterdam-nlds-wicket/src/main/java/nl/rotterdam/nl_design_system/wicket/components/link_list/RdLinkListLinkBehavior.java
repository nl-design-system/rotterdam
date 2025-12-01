package nl.rotterdam.nl_design_system.wicket.components.link_list;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.link.AbstractLink;

class RdLinkListLinkBehavior extends TagNameClassComponentBehavior<AbstractLink> {

    static final RdLinkListLinkBehavior INSTANCE = new RdLinkListLinkBehavior();

    private RdLinkListLinkBehavior() {
        super("a", RdLinkListLinkCss.DEFAULT);
        addHeaderItem(RdLinkListBehavior.CSS);
    }
}
