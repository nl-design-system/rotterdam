package nl.rotterdam.nl_design_system.wicket.components.form_field_error_message;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdFormFieldErrorMessageCss implements CssClassNames {
    BASE("utrecht-form-field-error-message");

    private final String classNames;

    @Override
    public String getClassNames() {
        return classNames;
    }

    RdFormFieldErrorMessageCss(String classNames) {
        this.classNames = classNames;
    }
}
