package nl.rotterdam.nl_design_system.wicket.components.root;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdRootCss implements CssClassNames {
    BASE("utrecht-root");

    private final String classNames;

    RdRootCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public String getClassNames() {
        return classNames;
    }
}
