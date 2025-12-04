package nl.rotterdam.nl_design_system.wicket.components.form_label;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdFormLabelCss implements CssClassNames {
    BASE("utrecht-form-label"),
    FORM_LABEL_CHECKBOX("utrecht-form-label--checkbox"),
    FORM_LABEL_RADIO("utrecht-form-label--radio"),
    FORM_LABEL_STATE_DISABLED("utrecht-form-label--disabled");

    private final String classNames;

    @Override
    public String getClassNames() {
        return classNames;
    }

    RdFormLabelCss(String classNames) {
        this.classNames = classNames;
    }
}
