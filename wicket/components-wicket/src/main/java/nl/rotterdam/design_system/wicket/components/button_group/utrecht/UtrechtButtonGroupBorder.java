package nl.rotterdam.design_system.wicket.components.button_group.utrecht;

import static css.WicketComponentsCssReferences.BUTTON_GROUP_HEADER_ITEM;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.border.Border;

public class UtrechtButtonGroupBorder extends Border {

    public UtrechtButtonGroupBorder(String id) {
        super(id);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(BUTTON_GROUP_HEADER_ITEM);
    }
}
