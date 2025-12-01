package nl.rotterdam.nl_design_system.wicket.components.preserve_data;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdPreserveDataCss implements CssClassNames {
    DEFAULT("utrecht-preserve-data");

    private final String classNames;

    @Override
    public String getClassNames() {
        return classNames;
    }

    RdPreserveDataCss(String classNames) {
        this.classNames = classNames;
    }
}
