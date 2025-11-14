package nl.rotterdam.nl_design_system.wicket.components.unordered_list;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;

/**
 * Behavior for list item.
 * TODO should probably not be public
 */
public class RdUnorderedListItemBehavior extends Behavior {

    private final String expectedTagName;
    private final String className;

    /**
     * Singleton instance.
     */
    public static final Behavior INSTANCE = new RdUnorderedListItemBehavior();

    private RdUnorderedListItemBehavior() {
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
