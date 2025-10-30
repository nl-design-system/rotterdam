package nl.rotterdam.nl_design_system.wicket.components.form_label.utrecht;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.nl_design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCss.DEFAULT;
import static nl.rotterdam.nl_design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCss.FORM_LABEL_STATE_DISABLED;

import java.util.List;
import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

public class UtrechtFormLabelBehavior extends TagNameClassComponentBehavior<Component> {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtFormLabelBehavior.class,
        "@utrecht/form-label-css/dist/index.css"
    );

    public static final UtrechtFormLabelBehavior INSTANCE_CHECKBOX = new UtrechtFormLabelBehavior(
        UtrechtFormLabelType.CHECKBOX
    );

    public static final UtrechtFormLabelBehavior INSTANCE_RADIO = new UtrechtFormLabelBehavior(
        UtrechtFormLabelType.RADIO
    );

    // Text has, by default, no specific type class
    public static final UtrechtFormLabelBehavior INSTANCE_DEFAULT = new UtrechtFormLabelBehavior();

    private UtrechtFormLabelBehavior() {
        super("label", DEFAULT);
        addHeaderItem(CSS);
    }

    private UtrechtFormLabelBehavior(UtrechtFormLabelType type) {
        super("label", DEFAULT, type.fullClassName);
        addHeaderItem(CSS);
    }

    @Override
    protected List<CssClassNames> customizeComponentAndReturnClasses(Component component, ComponentTag tag) {
        if (!component.isEnabledInHierarchy()) {
            return List.of(FORM_LABEL_STATE_DISABLED);
        }
        return List.of();
    }
}
