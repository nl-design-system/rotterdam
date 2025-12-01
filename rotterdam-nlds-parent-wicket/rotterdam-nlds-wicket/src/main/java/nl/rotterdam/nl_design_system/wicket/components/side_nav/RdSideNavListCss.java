package nl.rotterdam.nl_design_system.wicket.components.side_nav;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdSideNavListCss implements CssClassNames {
    LIST_ELEMENT("denhaag-sidenav__list");

    private final String cssClassNames;

    RdSideNavListCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
