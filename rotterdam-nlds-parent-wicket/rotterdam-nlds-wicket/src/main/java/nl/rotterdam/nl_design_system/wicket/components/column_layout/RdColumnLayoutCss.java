package nl.rotterdam.nl_design_system.wicket.components.column_layout;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdColumnLayoutCss implements CssClassNames {
    BASE("utrecht-column-layout");

    private final String classNames;

    RdColumnLayoutCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public String getClassNames() {
        return classNames;
    }
}
