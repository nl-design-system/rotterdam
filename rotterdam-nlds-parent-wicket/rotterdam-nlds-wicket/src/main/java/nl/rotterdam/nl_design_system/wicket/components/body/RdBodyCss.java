package nl.rotterdam.nl_design_system.wicket.components.body;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdBodyCss implements CssClassNames {
    DEFAULT("utrecht-body");

    private final String classNames;

    RdBodyCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public String getClassNames() {
        return classNames;
    }
}
