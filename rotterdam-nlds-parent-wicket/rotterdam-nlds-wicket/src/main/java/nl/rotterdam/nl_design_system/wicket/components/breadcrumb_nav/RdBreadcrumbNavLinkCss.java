package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdBreadcrumbNavLinkCss implements CssClassNames {
    LINK_ELEMENT("utrecht-breadcrumb-nav__link");

    private final String cssClassNames;

    RdBreadcrumbNavLinkCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
