package nl.rotterdam.nl_design_system.wicket.components.page_body;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdPageBodyCss implements CssClassNames {
    DEFAULT("utrecht-page-body");

    private final String classNames;

    RdPageBodyCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public String getClassNames() {
        return classNames;
    }
}
