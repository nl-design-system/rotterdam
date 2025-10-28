package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav.utrecht;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdBreadcrumbNavItemCss implements CssClassNames {
    DEFAULT("utrecht-breadcrumb-nav__item");

    private final String cssClassNames;

    RdBreadcrumbNavItemCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return cssClassNames;
    }
}
