package nl.rotterdam.design_system.wicket.components.ordered_list.utrecht;

import static css.WicketComponentsCssReferences.ORDERED_LIST_HEADER_ITEM;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

public class UtrechtOrderedListItemBehavior extends Behavior {

    private final String expectedTagName;
    private final String className;
    private final HeaderItem cssHeaderItem;

    public UtrechtOrderedListItemBehavior() {
        this.expectedTagName = "li";
        this.className = "utrecht-ordered-list__item utrecht-ordered-list__item";
        this.cssHeaderItem = ORDERED_LIST_HEADER_ITEM;
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
