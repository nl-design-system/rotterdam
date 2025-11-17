package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdBreadcrumbNavItemCss implements CssClassNames {
    DEFAULT("utrecht-breadcrumb-nav__item");

    private final String cssClassNames;

    RdBreadcrumbNavItemCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
