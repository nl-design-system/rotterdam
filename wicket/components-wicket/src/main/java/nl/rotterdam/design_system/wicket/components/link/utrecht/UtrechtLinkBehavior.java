package nl.rotterdam.design_system.wicket.components.link.utrecht;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.html.link.AbstractLink;

public class UtrechtLinkBehavior extends TagNameClassComponentBehavior<AbstractLink> {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtLinkBehavior.class,
        "@utrecht/link-css/dist/index.css"
    );

    public UtrechtLinkBehavior() {
        super("a", "utrecht-link", "utrecht-link--html-a");
        addHeaderItem(CSS);
    }
}
