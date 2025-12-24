package nl.rotterdam.nl_design_system.wicket.components.date_picker;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdDatePickerCss implements CssClassNames {
    BASE("rods-date-picker"),
    INVALID("rods-date-picker--invalid"),
    DISABLED("rods-date-picker--disabled");

    private final String classNames;

    @Override
    public String getClassNames() {
        return classNames;
    }

    RdDatePickerCss(String classNames) {
        this.classNames = classNames;
    }
}
