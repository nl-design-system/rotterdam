package nl.rotterdam.nl_design_system.wicket.components.icon_button;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdIconButtonCss implements CssClassNames {
    DEFAULT("ams-icon-button");

    private final String classNames;

    RdIconButtonCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }
}
