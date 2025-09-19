package nl.rotterdam.design_system.wicket.components.form_label.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import java.util.List;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCssClasses.FORM_LABEL_STATE_DISABLED_CLASSNAME;
import static nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCssClasses.UTRECHT_FORM_LABEL;

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
        super("label", UTRECHT_FORM_LABEL, type.fullClassName);
        addHeaderItem(CSS);
    }


    @Override
    protected List<String> customizeComponentAndReturnClasses(Component component, ComponentTag tag) {
        if (!component.isEnabledInHierarchy()) {
            return List.of(FORM_LABEL_STATE_DISABLED_CLASSNAME);
        }
        return List.of();
    }

}
