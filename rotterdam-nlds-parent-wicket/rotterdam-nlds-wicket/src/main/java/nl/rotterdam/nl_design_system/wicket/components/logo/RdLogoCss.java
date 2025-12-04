package nl.rotterdam.nl_design_system.wicket.components.logo;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdLogoCss implements CssClassNames {
    BASE("utrecht-logo");

    private final String classNames;

    RdLogoCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public String getClassNames() {
        return classNames;
    }
}
