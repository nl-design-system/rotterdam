package nl.rotterdam.design_system.wicket.components.form_field_error_message.utrecht;

import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum UtrechtFormFieldErrorCss implements CssClassNames {

    DEFAULT("utrecht-form-field-error-message");

    private final String classNames;

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }

    UtrechtFormFieldErrorCss(String classNames) {
        this.classNames = classNames;
    }
}
