package nl.rotterdam.nl_design_system.wicket.components.visually_hidden;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdVisuallyHiddenCss implements CssClassNames {
    DEFAULT("ams-visually-hidden");

    @NonNull
    private final String classNames;

    RdVisuallyHiddenCss(@NonNull String classNames) {
        this.classNames = classNames;
    }


    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }
}
