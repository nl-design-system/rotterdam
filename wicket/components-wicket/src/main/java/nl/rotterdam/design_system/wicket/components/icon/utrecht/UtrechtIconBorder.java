package nl.rotterdam.design_system.wicket.components.icon.utrecht;

import static css.WicketComponentsCssReferences.ICON_HEADER_ITEM;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.border.Border;

public class UtrechtIconBorder extends Border {

    public UtrechtIconBorder(String id) {
        super(id);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(ICON_HEADER_ITEM);
    }
}
