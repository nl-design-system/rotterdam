package nl.rotterdam.design_system.wicket.components.button;

import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdButtonCss implements CssClassNames {

    DEFAULT("utrecht-button utrecht-button--html-button");

    private final String classNames;

    RdButtonCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }
}
