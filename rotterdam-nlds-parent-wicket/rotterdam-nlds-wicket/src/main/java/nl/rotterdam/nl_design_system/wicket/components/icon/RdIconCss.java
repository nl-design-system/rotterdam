package nl.rotterdam.nl_design_system.wicket.components.icon;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdIconCss implements CssClassNames {
    DEFAULT("utrecht-icon");

    private final String classNames;

    RdIconCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public String getClassNames() {
        return classNames;
    }
}
