package nl.rotterdam.nl_design_system.wicket.components.link_list;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

/**
 * Link list behavior.
 * @see RdLinkListPanel
 */
public class RdLinkListBehavior extends TagNameClassComponentBehavior<Component> {

    /**
     * Reference to css, used by other components too hence public
     */
    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        RdLinkListBehavior.class,
        "@utrecht/link-list-css/dist/index.css"
    );

    /**
     * Singleton instance.
     */
    public static final RdLinkListBehavior INSTANCE = new RdLinkListBehavior();

    private RdLinkListBehavior() {
        super("ul", RdLinkListCss.DEFAULT);
        addHeaderItem(CSS);
    }
}
