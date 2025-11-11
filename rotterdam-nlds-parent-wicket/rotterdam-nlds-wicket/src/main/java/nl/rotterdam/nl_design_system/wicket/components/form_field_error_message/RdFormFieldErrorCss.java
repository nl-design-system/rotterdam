package nl.rotterdam.nl_design_system.wicket.components.form_field_error_message;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdFormFieldErrorCss implements CssClassNames {
    DEFAULT("utrecht-form-field-error-message");

    private final String classNames;

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }

    RdFormFieldErrorCss(String classNames) {
        this.classNames = classNames;
    }
}
