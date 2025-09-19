package nl.rotterdam.design_system.wicket.components.badge_list.utrecht;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

public class UtrechtBadgeListBehavior extends TagNameClassComponentBehavior<Component> {

    private static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtBadgeListBehavior.class,
        "@utrecht/badge-list-css/dist/index.css"
    );

    public UtrechtBadgeListBehavior() {
        super("div", "utrecht-badge-list");
        addHeaderItem(CSS);
    }
}
