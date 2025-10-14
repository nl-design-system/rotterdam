package nl.rotterdam.design_system.wicket.components.data_summary;

import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

public enum RdDataSummaryValueCss implements CssClassNames {

    DEFAULT("utrecht-data-list__item-value utrecht-data-list__item-value--html-dd")
    ;

    private final String cssClassNames;

    RdDataSummaryValueCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return cssClassNames;
    }
}
