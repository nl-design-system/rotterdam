package nl.rotterdam.nl_design_system.wicket.components.form_field_textarea;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdFormFieldTextAreaCss implements CssClassNames {
    // TODO this is shared between text box, textarea. But for form-field-checkbox, for form-field-radio it is different
    // Discuss with Johan where to put these, in this enum, or move to RdFormFieldCss?
    BASE("utrecht-form-field--text");

    private final String classNames;

    @Override
    public String getClassNames() {
        return classNames;
    }

    RdFormFieldTextAreaCss(String classNames) {
        this.classNames = classNames;
    }
}
