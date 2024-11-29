package nl.rotterdam.design_system.wicket.components.page_layout.utrecht;

import static css.WicketComponentsCssReferences.PAGE_LAYOUT_HEADER_ITEM;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.border.Border;

public class UtrechtPageLayoutBorder extends Border {

    public UtrechtPageLayoutBorder(String id) {
        super(id);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(PAGE_LAYOUT_HEADER_ITEM);
    }
}
