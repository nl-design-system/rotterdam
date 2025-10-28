package nl.rotterdam.nl_design_system.wicket.components.page_body.utrecht;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

public class UtrechtPageBodyBehavior extends Behavior {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtPageBodyBehavior.class,
        "@utrecht/page-body-css/dist/index.css"
    );

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);

        response.render(CSS);
    }
}
