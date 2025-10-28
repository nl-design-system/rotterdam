package nl.rotterdam.nl_design_system.wicket.components.number_badge.utrecht;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

public class UtrechtNumberBadgeBehavior extends Behavior {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtNumberBadgeBehavior.class,
        "@utrecht/number-badge-css/dist/index.css"
    );

    private final String expectedTagName;
    private final String className;

    public UtrechtNumberBadgeBehavior() {
        this.expectedTagName = "data";
        this.className = "utrecht-number-badge";
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

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        response.render(CSS);
    }
}
