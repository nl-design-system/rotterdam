package nl.rotterdam.nl_design_system.wicket.components.link_list;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdLinkListCss implements CssClassNames {
    DEFAULT("utrecht-link-list");

    private final String cssClassNames;

    RdLinkListCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
