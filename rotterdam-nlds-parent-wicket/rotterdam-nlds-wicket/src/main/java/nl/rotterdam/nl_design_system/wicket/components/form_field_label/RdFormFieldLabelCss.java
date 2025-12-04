package nl.rotterdam.nl_design_system.wicket.components.form_field_label;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdFormFieldLabelCss implements CssClassNames {
    BASE("utrecht-form-label"),
    CHECKBOX("utrecht-form-label--checkbox"),
    CHECKED("utrecht-form-label--checked"),
    DISABLED("utrecht-form-label--disabled"),
    RADIO("utrecht-form-label--radio");

    private final String classNames;

    @Override
    public String getClassNames() {
        return classNames;
    }

    RdFormFieldLabelCss(String classNames) {
        this.classNames = classNames;
    }
}
