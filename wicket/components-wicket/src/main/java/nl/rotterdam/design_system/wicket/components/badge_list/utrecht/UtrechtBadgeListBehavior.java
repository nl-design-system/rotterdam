package nl.rotterdam.design_system.wicket.components.badge_list.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtBadgeListBehavior extends TagNameClassComponentBehavior {

    private static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtBadgeListBehavior.class,
        "@utrecht/badge-list-css/dist/index.css"
    );

    public static final UtrechtBadgeListBehavior INSTANCE = new UtrechtBadgeListBehavior();

    private UtrechtBadgeListBehavior() {
        super("div", "utrecht-badge-list");
        addHeaderItem(CSS);
    }
}
