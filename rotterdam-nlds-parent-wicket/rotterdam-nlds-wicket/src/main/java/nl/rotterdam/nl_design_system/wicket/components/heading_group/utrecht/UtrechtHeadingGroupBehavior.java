package nl.rotterdam.nl_design_system.wicket.components.heading_group.utrecht;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

public class UtrechtHeadingGroupBehavior extends Behavior {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtHeadingGroupBehavior.class,
        "@utrecht/heading-group-css/dist/index.css"
    );

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);

        response.render(CSS);
    }
}
