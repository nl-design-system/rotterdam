package nl.rotterdam.nl_design_system.wicket.components.form_field_textarea;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdFormFieldTextAreaCss implements CssClassNames {
    // TODO discuss with Johan, move to RdFormFieldCss? same class as RdFormFieldTtextcss
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
