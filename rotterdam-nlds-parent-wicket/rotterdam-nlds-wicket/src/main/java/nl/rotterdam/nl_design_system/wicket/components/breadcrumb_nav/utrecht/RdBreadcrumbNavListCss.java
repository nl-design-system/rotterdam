package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav.utrecht;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdBreadcrumbNavListCss implements CssClassNames {
    DEFAULT("utrecht-breadcrumb-nav__list");

    private final String cssClassNames;

    RdBreadcrumbNavListCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return cssClassNames;
    }
}
