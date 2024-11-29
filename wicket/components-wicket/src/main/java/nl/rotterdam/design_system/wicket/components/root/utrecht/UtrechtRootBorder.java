package nl.rotterdam.design_system.wicket.components.root.utrecht;

import static css.WicketComponentsCssReferences.ROOT_HEADER_ITEM;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.border.Border;

public class UtrechtRootBorder extends Border {

    public UtrechtRootBorder(String id) {
        super(id);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(ROOT_HEADER_ITEM);
    }
}
