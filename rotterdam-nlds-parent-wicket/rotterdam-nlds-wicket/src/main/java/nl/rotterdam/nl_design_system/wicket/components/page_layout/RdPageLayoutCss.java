package nl.rotterdam.nl_design_system.wicket.components.page_layout;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdPageLayoutCss implements CssClassNames {
    BASE("utrecht-page-layout");

    private final String classNames;

    RdPageLayoutCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public String getClassNames() {
        return classNames;
    }
}
