package nl.rotterdam.design_system.wicket.components.separator.utrecht;

import static css.WicketComponentsCssReferences.SEPARATOR_HEADER_ITEM;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebComponent;

public class UtrechtSeparator extends WebComponent {

    public UtrechtSeparator(String id) {
        super(id);
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);
        tag.setName("hr");
        tag.put("class", "utrecht-separator");
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(SEPARATOR_HEADER_ITEM);
    }
}
