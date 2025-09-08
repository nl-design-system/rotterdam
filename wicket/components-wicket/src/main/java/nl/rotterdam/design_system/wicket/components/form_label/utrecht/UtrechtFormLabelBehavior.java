package nl.rotterdam.design_system.wicket.components.form_label.utrecht;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtFormLabelBehavior extends Behavior {

    public static final CssReferenceHeaderItem CSS =
        cssReferenceHeaderItem(UtrechtFormLabelBehavior.class, "@utrecht/form-label-css/dist/index.css");

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);

        response.render(CSS);
    }
}
