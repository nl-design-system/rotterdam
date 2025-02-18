package nl.rotterdam.design_system.wicket.components.form_label.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

// TODO: make it a singleton, create base class
public class UtrechtFormLabelBehavior extends TagNameClassComponentBehavior {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtFormLabelBehavior.class,
        "@utrecht/form-label-css/dist/index.css"
    );

    public UtrechtFormLabelBehavior() {
        super("label", "utrecht-form-label");
        addHeaderItem(CSS);
    }

    public UtrechtFormLabelBehavior(UtrechtFormLabelType type) {
        super("label", "utrecht-form-label", "utrecht-form-label--" + type.type);
        addHeaderItem(CSS);
    }

}
