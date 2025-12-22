package nl.rotterdam.nl_design_system.wicket.components.code;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdCodeCss implements CssClassNames {
    BASE("nl-code");

    private final String classNames;

    RdCodeCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public String getClassNames() {
        return classNames;
    }
}
