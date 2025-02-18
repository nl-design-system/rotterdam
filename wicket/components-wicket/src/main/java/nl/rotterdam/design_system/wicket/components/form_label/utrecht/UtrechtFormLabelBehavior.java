package nl.rotterdam.design_system.wicket.components.form_label.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

// TODO: make it a singleton, create base class
public class UtrechtFormLabelBehavior extends TagNameClassComponentBehavior {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtFormLabelBehavior.class,
        "@utrecht/form-label-css/dist/index.css"
    );

    public UtrechtFormLabelBehavior() {
        super("label", "utrecht-form-label");
    }

    public UtrechtFormLabelBehavior(UtrechtFormLabelType type) {
        super("label", "utrecht-form-label", "utrecht-form-label--" + type.type);
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);

        response.render(CSS);
    }
}
