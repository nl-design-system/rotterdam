package nl.rotterdam.nl_design_system.wicket.components.radio_button;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdRadioButtonCss implements CssClassNames {
    BASE("utrecht-radio-button"),
    DISABLED("utrecht-radio-button--disabled"),
    HTML_INPUT("utrecht-radio-button--html-input"),
    INVALID("utrecht-radio-button--invalid");

    private final String classNames;

    RdRadioButtonCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public String getClassNames() {
        return classNames;
    }
}
