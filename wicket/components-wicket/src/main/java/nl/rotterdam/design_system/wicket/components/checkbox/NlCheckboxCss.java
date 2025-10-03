package nl.rotterdam.design_system.wicket.components.checkbox;

import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum NlCheckboxCss implements CssClassNames {
    DEFAULT("utrecht-checkbox utrecht-checkbox--html-input utrecht-checkbox--custom"),
    DISABLED("utrecht-checkbox--disabled"),
    INVALID("utrecht-checkbox--invalid");

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }

    private final String classNames;

    NlCheckboxCss(String classNames) {
        this.classNames = classNames;
    }

}
