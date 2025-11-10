package nl.rotterdam.nl_design_system.wicket.components.form_field_checkbox;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdFormFieldCheckboxCss implements CssClassNames {
    FORM_FIELD_CHECKBOX("utrecht-form-field--checkbox"),
    FORM_FIELD_LABEL_CHECKBOX("utrecht-form-field__label--checkbox");

    private final String classNames;

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }

    RdFormFieldCheckboxCss(String classNames) {
        this.classNames = classNames;
    }
}
