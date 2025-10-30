package nl.rotterdam.nl_design_system.wicket.components.alert.utrecht;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

enum RdAlertCss implements CssClassNames {
    OK("utrecht-alert utrecht-alert--" + UtrechtAlertType.OK.type),
    INFO("utrecht-alert utrecht-alert--" + UtrechtAlertType.INFO.type),
    WARNING("utrecht-alert utrecht-alert--" + UtrechtAlertType.WARNING.type),
    ERROR("utrecht-alert utrecht-alert--" + UtrechtAlertType.ERROR.type);

    private final String cssClassNames;

    RdAlertCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public @NonNull String getClassNames() {
        return cssClassNames;
    }
}
