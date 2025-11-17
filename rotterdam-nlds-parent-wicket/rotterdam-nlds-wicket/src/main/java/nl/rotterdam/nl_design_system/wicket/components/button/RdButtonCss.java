package nl.rotterdam.nl_design_system.wicket.components.button;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdButtonCss implements CssClassNames {
    DEFAULT("utrecht-button utrecht-button--html-button");

    private final String classNames;

    RdButtonCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public String getClassNames() {
        return classNames;
    }
}
