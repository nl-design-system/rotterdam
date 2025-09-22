package nl.rotterdam.design_system.wicket.components.form_field_description.utrecht;

import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum UtrechtFormFieldDescriptionCss implements CssClassNames {

    DEFAULT("utrecht-form-field-description");

    private final String classNames;

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }

    UtrechtFormFieldDescriptionCss(String classNames) {
        this.classNames = classNames;
    }
}
