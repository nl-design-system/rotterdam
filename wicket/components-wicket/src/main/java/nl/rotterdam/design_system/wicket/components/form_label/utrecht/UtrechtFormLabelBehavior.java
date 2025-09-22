package nl.rotterdam.design_system.wicket.components.form_label.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import java.util.List;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCssClassNames.FORM_LABEL_STATE_DISABLED_CLASS_NAME;
import static nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCssClassNames.UTRECHT_FORM_LABEL_CLASS_NAME;

public class UtrechtFormLabelBehavior extends TagNameClassComponentBehavior<Component> {

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
        super("label", UTRECHT_FORM_LABEL_CLASS_NAME, type.fullClassName);
        addHeaderItem(CSS);
    }


    @Override
    protected List<String> customizeComponentAndReturnClasses(Component component, ComponentTag tag) {
        if (!component.isEnabledInHierarchy()) {
            return List.of(FORM_LABEL_STATE_DISABLED_CLASS_NAME);
        }
        return List.of();
    }

}
