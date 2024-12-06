package nl.rotterdam.design_system.wicket.components.separator.utrecht;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.request.resource.CssResourceReference;

public class UtrechtSeparatorBehavior extends Behavior {

    public static final CssReferenceHeaderItem CSS = CssHeaderItem.forReference(
        new CssResourceReference(UtrechtSeparatorBehavior.class, "@utrecht/separator-css/dist/index.css")
    );

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);

        response.render(CSS);
    }
}
