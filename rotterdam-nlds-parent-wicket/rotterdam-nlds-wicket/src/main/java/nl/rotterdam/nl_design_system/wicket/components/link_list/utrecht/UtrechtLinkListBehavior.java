package nl.rotterdam.nl_design_system.wicket.components.link_list.utrecht;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

public class UtrechtLinkListBehavior extends TagNameClassComponentBehavior<Component> {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtLinkListBehavior.class,
        "@utrecht/link-list-css/dist/index.css"
    );

    public static final UtrechtLinkListBehavior UTRECHT_LINK_LIST_BEHAVIOR = new UtrechtLinkListBehavior();

    private UtrechtLinkListBehavior() {
        super("ul", RdLinkListCss.DEFAULT);
        addHeaderItem(CSS);
    }
}
