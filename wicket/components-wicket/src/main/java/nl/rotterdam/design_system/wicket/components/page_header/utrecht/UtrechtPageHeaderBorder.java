package nl.rotterdam.design_system.wicket.components.page_header.utrecht;

import static css.WicketComponentsCssReferences.PAGE_HEADER_HEADER_ITEM;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.border.Border;

public class UtrechtPageHeaderBorder extends Border {

    public UtrechtPageHeaderBorder(String id) {
        super(id);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(PAGE_HEADER_HEADER_ITEM);
    }
}
