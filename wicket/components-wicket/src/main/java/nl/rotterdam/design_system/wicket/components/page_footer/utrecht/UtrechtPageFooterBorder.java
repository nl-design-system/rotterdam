package nl.rotterdam.design_system.wicket.components.page_footer.utrecht;

import static css.WicketComponentsCssReferences.PAGE_FOOTER_HEADER_ITEM;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.border.Border;

public class UtrechtPageFooterBorder extends Border {

    public UtrechtPageFooterBorder(String id) {
        super(id);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(PAGE_FOOTER_HEADER_ITEM);
    }
}
