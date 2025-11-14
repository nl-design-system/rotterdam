package nl.rotterdam.nl_design_system.wicket.components.action_group;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdActionGroupCss implements CssClassNames {
    DEFAULT("utrecht-button-group");

    private final String cssClassNames;

    RdActionGroupCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
