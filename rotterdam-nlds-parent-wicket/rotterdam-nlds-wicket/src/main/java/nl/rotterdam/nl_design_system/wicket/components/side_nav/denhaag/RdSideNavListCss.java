package nl.rotterdam.nl_design_system.wicket.components.side_nav.denhaag;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdSideNavListCss implements CssClassNames {
    DEFAULT("denhaag-sidenav__list");

    private final String cssClassNames;

    RdSideNavListCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return cssClassNames;
    }
}
