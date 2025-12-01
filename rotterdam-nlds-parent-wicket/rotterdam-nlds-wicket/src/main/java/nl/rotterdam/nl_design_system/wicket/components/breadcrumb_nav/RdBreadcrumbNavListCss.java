package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdBreadcrumbNavListCss implements CssClassNames {
    LIST_ELEMENT("utrecht-breadcrumb-nav__list");

    private final String cssClassNames;

    RdBreadcrumbNavListCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
