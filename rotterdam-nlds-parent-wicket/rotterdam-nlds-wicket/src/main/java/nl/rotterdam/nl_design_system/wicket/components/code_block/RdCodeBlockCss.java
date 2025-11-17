package nl.rotterdam.nl_design_system.wicket.components.code_block;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdCodeBlockCss implements CssClassNames {
    DEFAULT("utrecht-code-block");

    private final String cssClassNames;

    RdCodeBlockCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
