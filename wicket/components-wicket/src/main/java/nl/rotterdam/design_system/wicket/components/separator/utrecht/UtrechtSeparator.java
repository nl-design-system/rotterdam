package nl.rotterdam.design_system.wicket.components.separator.utrecht;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebComponent;

import static nl.rotterdam.design_system.wicket.components.component_tag.ComponentTagUtils.appendCssClassesTo;

public class UtrechtSeparator extends WebComponent {

    public UtrechtSeparator(String id) {
        super(id);
        add(new UtrechtSeparatorBehavior());
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);
        tag.setName("hr");
        appendCssClassesTo(tag, "utrecht-separator");
    }
}
