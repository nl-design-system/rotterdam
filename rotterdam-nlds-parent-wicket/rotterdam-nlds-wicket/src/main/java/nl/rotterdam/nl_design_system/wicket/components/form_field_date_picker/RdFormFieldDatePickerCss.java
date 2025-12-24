package nl.rotterdam.nl_design_system.wicket.components.form_field_date_picker;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdFormFieldDatePickerCss implements CssClassNames {
    DATE_PICKER("utrecht-form-field--date-picker");

    private final String classNames;

    @Override
    public String getClassNames() {
        return classNames;
    }

    RdFormFieldDatePickerCss(String classNames) {
        this.classNames = classNames;
    }
}
