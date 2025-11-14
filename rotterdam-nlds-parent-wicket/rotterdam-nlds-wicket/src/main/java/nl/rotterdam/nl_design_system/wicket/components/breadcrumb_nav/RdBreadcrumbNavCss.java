package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdBreadcrumbNavCss implements CssClassNames {
    DEFAULT("utrecht-breadcrumb-nav");

    private final String cssClassNames;

    RdBreadcrumbNavCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
