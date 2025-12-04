package nl.rotterdam.nl_design_system.wicket.components.side_nav;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdSideNavLinkCss implements CssClassNames {
    LINK_ELEMENT("denhaag-sidenav__link"),
    ACTIVE("utrecht-link--active");

    private final String cssClassNames;

    RdSideNavLinkCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
