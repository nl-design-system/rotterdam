package nl.rotterdam.nl_design_system.wicket.components.icon;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdIconCss implements CssClassNames {
    DEFAULT("utrecht-icon");

    private final String classNames;

    RdIconCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }
}
