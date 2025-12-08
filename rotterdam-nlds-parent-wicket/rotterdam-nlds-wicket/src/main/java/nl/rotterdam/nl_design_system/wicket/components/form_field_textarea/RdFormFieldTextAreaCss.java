package nl.rotterdam.nl_design_system.wicket.components.form_field_textarea;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdFormFieldTextAreaCss implements CssClassNames {
    TEXTAREA("utrecht-form-field--textarea");

    private final String classNames;

    @Override
    public String getClassNames() {
        return classNames;
    }

    RdFormFieldTextAreaCss(String classNames) {
        this.classNames = classNames;
    }
}
