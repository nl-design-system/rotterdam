package nl.rotterdam.nl_design_system.wicket.components.form_field_checkbox;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdFormFieldCheckboxCss implements CssClassNames {
    FORM_FIELD_CHECKBOX("utrecht-form-field--checkbox"),
    FORM_FIELD_LABEL_CHECKBOX("utrecht-form-field__label--checkbox");

    private final String classNames;

    @Override
    public String getClassNames() {
        return classNames;
    }

    RdFormFieldCheckboxCss(String classNames) {
        this.classNames = classNames;
    }
}
