package nl.rotterdam.nl_design_system.wicket.components.link_list;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

public class RdLinkListBehavior extends TagNameClassComponentBehavior<Component> {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        RdLinkListBehavior.class,
        "@utrecht/link-list-css/dist/index.css"
    );

    public static final RdLinkListBehavior LINK_LIST_BEHAVIOR = new RdLinkListBehavior();

    private RdLinkListBehavior() {
        super("ul", RdLinkListCss.DEFAULT);
        addHeaderItem(CSS);
    }
}
