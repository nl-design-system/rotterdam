package nl.rotterdam.design_system.wicket.components.button_group.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtButtonGroupBehavior extends TagNameClassComponentBehavior {

    public static final CssReferenceHeaderItem CSS =
        cssReferenceHeaderItem(UtrechtButtonGroupBehavior.class, "@utrecht/button-group-css/dist/index.css");

    private static final String EXPECTED_TAG_NAME = "div";
    private static final String CLASS_NAME = "utrecht-button-group";

    public UtrechtButtonGroupBehavior() {
        super(EXPECTED_TAG_NAME, CLASS_NAME);
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);

        response.render(CSS);
    }
}
