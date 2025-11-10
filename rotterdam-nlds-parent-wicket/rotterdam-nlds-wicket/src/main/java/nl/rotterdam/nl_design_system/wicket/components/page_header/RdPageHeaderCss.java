package nl.rotterdam.nl_design_system.wicket.components.page_header;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdPageHeaderCss implements CssClassNames {
    DEFAULT("utrecht-page-header");

    private final String classNames;

    RdPageHeaderCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }
}
