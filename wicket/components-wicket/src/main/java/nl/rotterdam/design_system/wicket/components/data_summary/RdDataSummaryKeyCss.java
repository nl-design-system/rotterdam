package nl.rotterdam.design_system.wicket.components.data_summary;

import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdDataSummaryKeyCss implements CssClassNames {

    DEFAULT("utrecht-data-list__item-key")
    ;

    private final String cssClassNames;

    RdDataSummaryKeyCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return cssClassNames;
    }
}
