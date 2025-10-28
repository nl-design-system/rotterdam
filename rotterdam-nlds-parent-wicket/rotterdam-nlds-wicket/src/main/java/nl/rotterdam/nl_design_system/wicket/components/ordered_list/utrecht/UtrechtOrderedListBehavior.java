package nl.rotterdam.nl_design_system.wicket.components.ordered_list.utrecht;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

public class UtrechtOrderedListBehavior extends Behavior {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtOrderedListBehavior.class,
        "@utrecht/ordered-list-css/dist/index.css"
    );

    private final String expectedTagName;
    private final String className;

    public UtrechtOrderedListBehavior() {
        this.expectedTagName = "ol";
        this.className = "utrecht-ordered-list";
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
        response.render(CSS);
    }
}
