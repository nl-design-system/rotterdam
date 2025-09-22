package nl.rotterdam.design_system.wicket.components.checkbox.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.CheckBox;

import java.util.ArrayList;
import java.util.List;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.design_system.wicket.components.checkbox.utrecht.UtrechtCheckboxCss.*;

/**
 * Applies NL Design System checkbox styles to a Wicket CheckBox component.
 *
 * <p>Some characteristics are not taken into account, so to be fully compliant use {@link UtrechtCheckbox}.</p>
 */
public class UtrechtCheckboxBehavior extends TagNameClassComponentBehavior<CheckBox> {

    public static final UtrechtCheckboxBehavior INSTANCE = new UtrechtCheckboxBehavior();
    private UtrechtCheckboxBehavior() {
        super("input", DEFAULT);
        addHeaderItem(cssReferenceHeaderItem(UtrechtCheckboxBehavior.class, "@utrecht/checkbox-css/dist/index.css"));
        addHeaderItem(cssReferenceHeaderItem(UtrechtCheckboxBehavior.class, "@utrecht/custom-checkbox-css/dist/index.css"));
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
