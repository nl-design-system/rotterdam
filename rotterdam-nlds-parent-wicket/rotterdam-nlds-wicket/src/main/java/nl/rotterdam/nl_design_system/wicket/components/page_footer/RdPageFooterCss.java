package nl.rotterdam.nl_design_system.wicket.components.page_footer;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdPageFooterCss implements CssClassNames {
    DEFAULT("utrecht-page-footer");

    private final String classNames;

    RdPageFooterCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }
}
