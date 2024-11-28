package nl.rotterdam.design_system.wicket.components.unordered_list.utrecht;

import static css.WicketComponentsCssReferences.UNORDERED_LIST_HEADER_ITEM;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

public class UtrechtUnorderedListBehavior extends Behavior {

    private final String expectedTagName;
    private final String className;
    private final HeaderItem cssHeaderItem;

    public UtrechtUnorderedListBehavior() {
        this.expectedTagName = "ul";
        this.className = "utrecht-unordered-list";
        this.cssHeaderItem = UNORDERED_LIST_HEADER_ITEM;
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        if (!expectedTagName.equals(tag.getName())) {
            tag.setName(expectedTagName);
        }

        if (!tag.isClose()) {
            tag.put("role", "list");
            tag.append("class", className, " ");
        }
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        response.render(cssHeaderItem);
    }
}
