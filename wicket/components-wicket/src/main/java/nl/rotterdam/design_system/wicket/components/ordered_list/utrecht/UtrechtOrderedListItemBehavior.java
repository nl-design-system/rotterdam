package nl.rotterdam.design_system.wicket.components.ordered_list.utrecht;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;

public class UtrechtOrderedListItemBehavior extends Behavior {

    private final String expectedTagName;
    private final String className;

    public UtrechtOrderedListItemBehavior() {
        this.expectedTagName = "li";
        this.className = "utrecht-ordered-list__item utrecht-ordered-list__item";
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
