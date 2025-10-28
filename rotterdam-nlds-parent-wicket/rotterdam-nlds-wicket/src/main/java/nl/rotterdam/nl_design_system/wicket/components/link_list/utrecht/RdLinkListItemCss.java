package nl.rotterdam.nl_design_system.wicket.components.link_list.utrecht;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

public enum RdLinkListItemCss implements CssClassNames {
    DEFAULT("utrecht-link-list__item");

    private final String cssClassNames;

    RdLinkListItemCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return cssClassNames;
    }
}
