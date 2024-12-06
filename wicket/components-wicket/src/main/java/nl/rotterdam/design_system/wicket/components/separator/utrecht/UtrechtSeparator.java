package nl.rotterdam.design_system.wicket.components.separator.utrecht;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebComponent;

public class UtrechtSeparator extends WebComponent {

    public UtrechtSeparator(String id) {
        super(id);
        add(new UtrechtSeparatorBehavior());
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);
        tag.setName("hr");
        tag.put("class", "utrecht-separator");
    }
}
