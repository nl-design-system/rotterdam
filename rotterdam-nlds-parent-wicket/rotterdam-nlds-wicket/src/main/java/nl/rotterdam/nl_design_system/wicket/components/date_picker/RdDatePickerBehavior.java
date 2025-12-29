package nl.rotterdam.nl_design_system.wicket.components.date_picker;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Behavior for the Date Picker component that loads the web component JavaScript.
 */
class RdDatePickerBehavior extends TagNameClassComponentBehavior<RdDatePicker> {

    // target/classes/nl/rotterdam/nl_design_system/wicket/components/date_picker/@gemeente-rotterdam/date-picker-element/dist/index.js
    static final JavaScriptResourceReference DATE_PICKER_JS = new JavaScriptResourceReference(
        RdDatePickerBehavior.class,
        "@gemeente-rotterdam/date-picker-element/dist/index.js"
    );

    static final JavaScriptReferenceHeaderItem HEADER_ITEM = JavaScriptHeaderItem.forReference(DATE_PICKER_JS);

    static final RdDatePickerBehavior INSTANCE = new RdDatePickerBehavior();

    private RdDatePickerBehavior() {
        super("rods-date-picker", RdDatePickerCss.BASE);
        addHeaderItem(HEADER_ITEM);
    }

    @Override
    protected List<CssClassNames> customizeComponentAndReturnClasses(RdDatePicker component, ComponentTag tag) {
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
