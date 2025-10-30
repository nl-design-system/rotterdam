package nl.rotterdam.nl_design_system.wicket.components.checkbox;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdCheckboxCss implements CssClassNames {
    DEFAULT("utrecht-checkbox utrecht-checkbox--html-input utrecht-checkbox--custom"),
    DISABLED("utrecht-checkbox--disabled"),
    INVALID("utrecht-checkbox--invalid");

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }

    private final String classNames;

    RdCheckboxCss(String classNames) {
        this.classNames = classNames;
    }
}
