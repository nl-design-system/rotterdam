package nl.rotterdam.nl_design_system.wicket.components.form_field_text_input;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdFormFieldTexInputCss implements CssClassNames {
    TEXT("utrecht-form-field--text");

    private final String classNames;

    @Override
    public String getClassNames() {
        return classNames;
    }

    RdFormFieldTexInputCss(String classNames) {
        this.classNames = classNames;
    }
}
