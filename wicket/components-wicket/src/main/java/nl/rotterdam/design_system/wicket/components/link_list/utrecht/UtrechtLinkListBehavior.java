package nl.rotterdam.design_system.wicket.components.link_list.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtLinkListBehavior extends TagNameClassComponentBehavior {


    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtLinkListBehavior.class,
        "@utrecht/link-list-css/dist/index.css"
    );

    public static final UtrechtLinkListBehavior UTRECHT_LINK_LIST_BEHAVIOR = new UtrechtLinkListBehavior();

    private UtrechtLinkListBehavior() {
        super("ul", "utrecht-link-list");
        addHeaderItem(CSS);
    }
}
