package nl.rotterdam.nl_design_system.wicket.components.form_label;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.nl_design_system.wicket.components.form_label.RdFormLabelCss.DEFAULT;
import static nl.rotterdam.nl_design_system.wicket.components.form_label.RdFormLabelCss.FORM_LABEL_STATE_DISABLED;

import java.util.List;
import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

/**
 * <a href="https://nldesignsystem.nl/form-field-label/">Form Field Label</a> with behavior.
 *
 * <p>Checkbox needs this with different HTML structure compared to other form components.</p>
 */
@SuppressWarnings("doclint:missing")
public class RdFormLabelBehavior extends TagNameClassComponentBehavior<Component> {

    private static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        RdFormLabelBehavior.class,
        "@utrecht/form-label-css/dist/index.min.css"
    );

    /**
     * Form field label voor ch
     */
    public static final RdFormLabelBehavior INSTANCE_CHECKBOX = new RdFormLabelBehavior(
        RdFormLabelType.CHECKBOX
    );

    public static final RdFormLabelBehavior INSTANCE_RADIO = new RdFormLabelBehavior(
        RdFormLabelType.RADIO
    );

    /**
     * Text has, by default, no specific type class
      */
    public static final RdFormLabelBehavior INSTANCE_DEFAULT = new RdFormLabelBehavior();

    private RdFormLabelBehavior() {
        super("label", DEFAULT);
        addHeaderItem(CSS);
    }

    private RdFormLabelBehavior(RdFormLabelType type) {
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
