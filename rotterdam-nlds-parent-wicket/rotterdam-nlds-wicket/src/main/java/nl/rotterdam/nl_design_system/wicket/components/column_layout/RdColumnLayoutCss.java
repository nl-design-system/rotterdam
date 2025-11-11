package nl.rotterdam.nl_design_system.wicket.components.column_layout;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdColumnLayoutCss implements CssClassNames {
    DEFAULT("utrecht-column-layout");

    private final String classNames;

    RdColumnLayoutCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }
}
