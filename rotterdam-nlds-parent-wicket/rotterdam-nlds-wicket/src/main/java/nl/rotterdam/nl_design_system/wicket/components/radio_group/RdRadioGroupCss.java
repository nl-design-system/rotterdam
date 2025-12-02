package nl.rotterdam.nl_design_system.wicket.components.radio_group;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdRadioGroupCss implements CssClassNames {
    BASE("utrecht-radio-group"),
    DESCRIPTION_ELEMENT("utrecht-radio-group__description"),
    ERROR_MESSAGE_ELEMENT("utrecht-radio-group__error-message"),
    LABEL_ELEMENT("utrecht-radio-group__label");

    private final String cssClassNames;

    RdRadioGroupCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
