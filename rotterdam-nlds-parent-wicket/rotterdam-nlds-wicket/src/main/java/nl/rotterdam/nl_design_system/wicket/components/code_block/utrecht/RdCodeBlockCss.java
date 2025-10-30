package nl.rotterdam.nl_design_system.wicket.components.code_block.utrecht;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdCodeBlockCss implements CssClassNames {
    DEFAULT("utrecht-code-block");

    private final String cssClassNames;

    RdCodeBlockCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return cssClassNames;
    }
}
