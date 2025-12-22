package nl.rotterdam.nl_design_system.wicket.components.checkbox_group;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdCheckboxGroupCss implements CssClassNames {
    BASE("utrecht-checkbox-group"),
    DESCRIPTION_ELEMENT("utrecht-checkbox-group__description"),
    ERROR_MESSAGE_ELEMENT("utrecht-checkbox-group__error-message"),
    LABEL_ELEMENT("utrecht-checkbox-group__label");

    private final String classNames;

    RdCheckboxGroupCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public String getClassNames() {
        return classNames;
    }
}
