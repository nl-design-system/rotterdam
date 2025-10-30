package nl.rotterdam.nl_design_system.wicket.components.text_input;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdTextInputCss implements CssClassNames {
    DEFAULT("utrecht-textbox utrecht-textbox--html-input"),
    INVALID("utrecht-textbox--invalid"),
    DISABLED("utrecht-textbox--disabled"),
    READ_ONLY("utrecht-textbox--readonly");

    private final String classNames;

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }

    RdTextInputCss(String classNames) {
        this.classNames = classNames;
    }
}
