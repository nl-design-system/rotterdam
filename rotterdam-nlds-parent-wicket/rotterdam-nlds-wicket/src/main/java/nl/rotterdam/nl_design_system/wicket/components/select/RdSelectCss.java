package nl.rotterdam.nl_design_system.wicket.components.select;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdSelectCss implements CssClassNames {
    BASE("utrecht-select"),
    HTML_SELECT("utrecht-select--html-select"),
    INVALID("utrecht-select--invalid"),
    REQUIRED("utrecht-select--required");

    private final String classNames;

    RdSelectCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public String getClassNames() {
        return classNames;
    }
}
