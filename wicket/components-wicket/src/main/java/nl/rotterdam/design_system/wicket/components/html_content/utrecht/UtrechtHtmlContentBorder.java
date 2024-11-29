package nl.rotterdam.design_system.wicket.components.html_content.utrecht;

import static css.WicketComponentsCssReferences.HTML_CONTENT_HEADER_ITEM;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.border.Border;

public class UtrechtHtmlContentBorder extends Border {

    public UtrechtHtmlContentBorder(String id) {
        super(id);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(HTML_CONTENT_HEADER_ITEM);
    }
}
