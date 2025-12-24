package nl.rotterdam.nl_design_system.wicket.components.date_picker;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Behavior for the Date Picker component that loads the web component JavaScript.
 */
class RdDatePickerBehavior extends TagNameClassComponentBehavior<TextField<?>> {

    static final RdDatePickerBehavior INSTANCE = new RdDatePickerBehavior();

    private static final JavaScriptResourceReference DATE_PICKER_JS = new JavaScriptResourceReference(
        RdDatePickerBehavior.class,
        "date-picker-element.js"
    );

    private RdDatePickerBehavior() {
        super("rods-date-picker", RdDatePickerCss.BASE);
        addHeaderItem(JavaScriptHeaderItem.forReference(DATE_PICKER_JS));
    }

    @Override
    protected List<CssClassNames> customizeComponentAndReturnClasses(TextField<?> component, ComponentTag tag) {
        List<CssClassNames> classes = new ArrayList<>();
        
        if (!component.isEnabledInHierarchy()) {
            classes.add(RdDatePickerCss.DISABLED);
        }

        if (component.hasErrorMessage()) {
            classes.add(RdDatePickerCss.INVALID);
        }

        if (component.isRequired()) {
            tag.put("aria-required", "true");
        }
        
        if (component.hasErrorMessage()) {
            tag.put("aria-invalid", "true");
        }

        return classes;
    }
}
