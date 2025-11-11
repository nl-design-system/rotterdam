package nl.rotterdam.nl_design_system.wicket.components.page_body;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdPageBodyCss implements CssClassNames {
    DEFAULT("utrecht-page-body");

    private final String classNames;

    RdPageBodyCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }
}
