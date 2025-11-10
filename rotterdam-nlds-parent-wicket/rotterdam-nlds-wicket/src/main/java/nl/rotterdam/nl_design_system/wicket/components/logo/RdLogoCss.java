package nl.rotterdam.nl_design_system.wicket.components.logo;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdLogoCss implements CssClassNames {
    DEFAULT("utrecht-logo");

    private final String classNames;

    RdLogoCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }
}
