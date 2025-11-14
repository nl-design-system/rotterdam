package nl.rotterdam.nl_design_system.wicket.components.link;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdLinkCss implements CssClassNames {
    DEFAULT("utrecht-link utrecht-link--html-a");

    private final String cssClassNames;

    RdLinkCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
