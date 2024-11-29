package nl.rotterdam.design_system.wicket.components.body.utrecht;

import static css.WicketComponentsCssReferences.BODY_HEADER_ITEM;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.border.Border;

public class UtrechtBodyBorder extends Border {

    public UtrechtBodyBorder(String id) {
        super(id);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(BODY_HEADER_ITEM);
    }
}
