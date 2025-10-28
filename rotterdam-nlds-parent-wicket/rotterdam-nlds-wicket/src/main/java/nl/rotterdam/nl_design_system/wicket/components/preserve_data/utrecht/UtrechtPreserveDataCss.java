package nl.rotterdam.nl_design_system.wicket.components.preserve_data.utrecht;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum UtrechtPreserveDataCss implements CssClassNames {
    DEFAULT("utrecht-preserve-data");

    private final String classNames;

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }

    UtrechtPreserveDataCss(String classNames) {
        this.classNames = classNames;
    }
}
