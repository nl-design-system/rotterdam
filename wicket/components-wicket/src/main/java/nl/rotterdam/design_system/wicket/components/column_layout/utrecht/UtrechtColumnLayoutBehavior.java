package nl.rotterdam.design_system.wicket.components.column_layout.utrecht;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtColumnLayoutBehavior extends Behavior {

    public static final CssReferenceHeaderItem CSS =
        cssReferenceHeaderItem(UtrechtColumnLayoutBehavior.class, "@utrecht/column-layout-css/dist/index.css");

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);

        response.render(CSS);
    }
}
