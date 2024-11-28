package nl.rotterdam.design_system.wicket.components.alert.utrecht;

import static css.WicketComponentsCssReferences.ALERT_HEADER_ITEM;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

public class UtrechtAlertBehavior extends Behavior {

    private final String expectedTagName;
    private final String className;
    private final HeaderItem cssHeaderItem;

    public UtrechtAlertBehavior() {
        this.expectedTagName = "div";
        this.className = "utrecht-alert--warning";
        this.cssHeaderItem = ALERT_HEADER_ITEM;
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        if (!expectedTagName.equals(tag.getName())) {
            tag.setName(expectedTagName);
        }
        tag.put("data-x", "omg");

        if (!tag.isClose()) {
            tag.append("class", className, " ");
        }
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        response.render(cssHeaderItem);
    }
}
