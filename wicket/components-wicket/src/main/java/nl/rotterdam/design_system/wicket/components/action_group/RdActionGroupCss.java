package nl.rotterdam.design_system.wicket.components.action_group;

import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdActionGroupCss implements CssClassNames {
    DEFAULT("utrecht-button-group"),
    ;

    private final String cssClassNames;

    RdActionGroupCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return cssClassNames;
    }
}
