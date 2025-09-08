package nl.rotterdam.design_system.wicket.components.form_label.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtFormLabelBehavior extends TagNameClassComponentBehavior {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtFormLabelBehavior.class,
        "@utrecht/form-label-css/dist/index.css"
    );

    public static final UtrechtFormLabelBehavior INSTANCE_CHECKBOX = new UtrechtFormLabelBehavior(UtrechtFormLabelType.CHECKBOX);

    public static final UtrechtFormLabelBehavior INSTANCE_RADIO = new UtrechtFormLabelBehavior(UtrechtFormLabelType.RADIO);

    // Text has, by default, no specific type class
    public static final UtrechtFormLabelBehavior INSTANCE_DEFAULT = new UtrechtFormLabelBehavior();

    private UtrechtFormLabelBehavior() {
        super("label", "utrecht-form-label");
        addHeaderItem(CSS);
    }

    private UtrechtFormLabelBehavior(UtrechtFormLabelType type) {
        super("label", "utrecht-form-label", "utrecht-form-label--" + type.type);
        addHeaderItem(CSS);
    }

}
