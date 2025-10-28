package nl.rotterdam.nl_design_system.wicket.components.badge_list.utrecht;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdBadgeListCss implements CssClassNames {
    DEFAULT("utrecht-badge-list");

    private final String cssClassNames;

    RdBadgeListCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return cssClassNames;
    }
}
