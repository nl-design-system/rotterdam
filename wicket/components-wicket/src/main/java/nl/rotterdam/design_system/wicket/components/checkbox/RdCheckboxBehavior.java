package nl.rotterdam.design_system.wicket.components.checkbox;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.CheckBox;

import java.util.ArrayList;
import java.util.List;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.design_system.wicket.components.checkbox.RdCheckboxCss.*;

/**
 * Applies NL Design System checkbox styles to a Wicket CheckBox component.
 *
 * <p>Some characteristics are not taken into account, so to be fully compliant use {@link RdCheckbox}.</p>
 */
public class RdCheckboxBehavior extends TagNameClassComponentBehavior<CheckBox> {

    public static final RdCheckboxBehavior INSTANCE = new RdCheckboxBehavior();
    private RdCheckboxBehavior() {
        super("input", DEFAULT);
        addHeaderItem(cssReferenceHeaderItem(RdCheckboxBehavior.class, "@utrecht/checkbox-css/dist/index.css"));
        addHeaderItem(cssReferenceHeaderItem(RdCheckboxBehavior.class, "@utrecht/custom-checkbox-css/dist/index.css"));
    }

    @Override
    protected List<CssClassNames> customizeComponentAndReturnClasses(CheckBox component, ComponentTag tag) {

        List<CssClassNames> classNames = new ArrayList<>();

        if (!component.isEnabledInHierarchy()) {
            classNames.add(DISABLED);
            tag.put("disabled", "");
        }

        if (component.isRequired()) {
            tag.put("aria-required", "true");
        }

        if (component.hasErrorMessage()) {
            classNames.add(INVALID);
            tag.put("aria-invalid", "true");
        }

        return classNames;
    }
}
