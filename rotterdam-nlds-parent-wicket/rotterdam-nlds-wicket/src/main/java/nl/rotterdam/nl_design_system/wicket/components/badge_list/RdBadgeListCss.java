package nl.rotterdam.nl_design_system.wicket.components.badge_list;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdBadgeListCss implements CssClassNames {
    DEFAULT("utrecht-badge-list");

    private final String cssClassNames;

    RdBadgeListCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
