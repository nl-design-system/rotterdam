package nl.rotterdam.nl_design_system.wicket.components.link_list;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdLinkListLinkCss implements CssClassNames {
    DEFAULT("utrecht-link-list__link");

    private final String cssClassNames;

    RdLinkListLinkCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
