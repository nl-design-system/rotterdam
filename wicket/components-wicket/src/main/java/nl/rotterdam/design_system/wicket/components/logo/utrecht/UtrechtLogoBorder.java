package nl.rotterdam.design_system.wicket.components.logo.utrecht;

import static css.WicketComponentsCssReferences.LOGO_HEADER_ITEM;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.border.Border;

public class UtrechtLogoBorder extends Border {

    public UtrechtLogoBorder(String id) {
        super(id);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(LOGO_HEADER_ITEM);
    }
}
