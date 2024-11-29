package nl.rotterdam.design_system.wicket.components.unordered_list.utrecht;

import static css.WicketComponentsCssReferences.UNORDERED_LIST_HEADER_ITEM;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.panel.Panel;

public class UtrechtUnorderedList extends Panel {

    public UtrechtUnorderedList(String id) {
        super(id);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(UNORDERED_LIST_HEADER_ITEM);
    }
}
