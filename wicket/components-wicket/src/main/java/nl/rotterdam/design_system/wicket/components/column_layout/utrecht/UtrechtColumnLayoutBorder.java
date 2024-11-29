package nl.rotterdam.design_system.wicket.components.column_layout.utrecht;

import static css.WicketComponentsCssReferences.COLUMN_LAYOUT_HEADER_ITEM;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.border.Border;

public class UtrechtColumnLayoutBorder extends Border {

    public UtrechtColumnLayoutBorder(String id) {
        super(id);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(COLUMN_LAYOUT_HEADER_ITEM);
    }
}
