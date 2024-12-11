package nl.rotterdam.design_system.wicket.components.link_list.utrecht;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

public class UtrechtLinkListBehavior extends TagNameClassComponentBehavior {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtLinkListBehavior.class,
        "@utrecht/link-list-css/dist/index.css"
    );

    public UtrechtLinkListBehavior() {
        super("ul", "utrecht-link-list");
        addHeaderItem(CSS);
    }
}
