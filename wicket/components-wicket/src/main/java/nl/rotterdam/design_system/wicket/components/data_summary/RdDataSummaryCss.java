package nl.rotterdam.design_system.wicket.components.data_summary;

import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdDataSummaryCss implements CssClassNames {

    DEFAULT("utrecht-data-list utrecht-data-list--html-dl utrecht-data-list--rows");

    private final String cssClassNames;

    RdDataSummaryCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return cssClassNames;
    }
}
