package nl.rotterdam.nl_design_system.wicket.components.link;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdLinkCss implements CssClassNames {
    DEFAULT("nl-link"),
    INLINE_BOX("nl-link nl-link--inline-box");

    private final String cssClassNames;

    RdLinkCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
