package nl.rotterdam.design_system.wicket.components.unordered_list.utrecht;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;

public class UtrechtUnorderedListItemBehavior extends Behavior {

    private final String expectedTagName;
    private final String className;

    public UtrechtUnorderedListItemBehavior() {
        this.expectedTagName = "li";
        this.className = "utrecht-unordered-list__item utrecht-unordered-list__item";
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        if (!expectedTagName.equals(tag.getName())) {
            tag.setName(expectedTagName);
        }

        if (!tag.isClose()) {
            tag.append("class", className, " ");
        }
    }
}
