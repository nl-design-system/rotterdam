package nl.rotterdam.nl_design_system.wicket.components.table;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdTableCss implements CssClassNames {
    BASE("utrecht-table");

    private final String classNames;

    RdTableCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public String getClassNames() {
        return classNames;
    }
}
