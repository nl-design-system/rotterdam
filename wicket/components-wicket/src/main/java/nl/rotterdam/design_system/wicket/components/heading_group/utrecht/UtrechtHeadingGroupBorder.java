package nl.rotterdam.design_system.wicket.components.heading_group.utrecht;

import static css.WicketComponentsCssReferences.HEADING_GROUP_HEADER_ITEM;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.border.Border;

public class UtrechtHeadingGroupBorder extends Border {

    public UtrechtHeadingGroupBorder(String id) {
        super(id);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(HEADING_GROUP_HEADER_ITEM);
    }
}
