package nl.rotterdam.nl_design_system.wicket.components.ordered_list;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
/**
 * @deprecated implementation incomplete
 */
@Deprecated
@SuppressWarnings("doclint:missing")
public class RdOrderedListItemBehavior extends Behavior {

    private final String expectedTagName;
    private final String className;

    public RdOrderedListItemBehavior() {
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
