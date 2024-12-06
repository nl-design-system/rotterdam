package nl.rotterdam.design_system.wicket.components.button_group.utrecht;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtButtonGroupBehavior extends Behavior {

    public static final CssReferenceHeaderItem CSS =
        cssReferenceHeaderItem(UtrechtButtonGroupBehavior.class, "@utrecht/button-group-css/dist/index.css");

    private static final String EXPECTED_TAG_NAME = "div";
    private static final String CLASS_NAME = "utrecht-button-group";

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);

        response.render(CSS);
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        if (!EXPECTED_TAG_NAME.equals(tag.getName())) {
            tag.setName(EXPECTED_TAG_NAME);
        }

        if (!tag.isClose()) {
            tag.put("class", CLASS_NAME);
        }
    }
}
