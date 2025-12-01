package nl.rotterdam.nl_design_system.wicket.components.side_nav;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdSideNavItemCss implements CssClassNames {
    DEFAULT("denhaag-sidenav__item");

    private final String cssClassNames;

    RdSideNavItemCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
