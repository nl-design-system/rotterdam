package nl.rotterdam.design_system.wicket.components.button_group.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtButtonGroupBehavior extends TagNameClassComponentBehavior<Component> {

    public static final CssReferenceHeaderItem CSS =
        cssReferenceHeaderItem(UtrechtButtonGroupBehavior.class, "@utrecht/button-group-css/dist/index.css");

    public UtrechtButtonGroupBehavior() {
        super("div", "utrecht-button-group");
        addHeaderItem(CSS);
    }
}
