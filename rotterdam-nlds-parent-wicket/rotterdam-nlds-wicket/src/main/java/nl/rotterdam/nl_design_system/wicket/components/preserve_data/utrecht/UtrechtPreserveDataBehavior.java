package nl.rotterdam.nl_design_system.wicket.components.preserve_data.utrecht;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

public class UtrechtPreserveDataBehavior extends Behavior {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtPreserveDataBehavior.class,
        "@utrecht/preserve-data-css/dist/index.css"
    );

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);

        response.render(CSS);
    }
}
