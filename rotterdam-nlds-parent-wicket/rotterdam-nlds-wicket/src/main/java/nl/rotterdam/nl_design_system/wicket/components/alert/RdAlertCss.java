package nl.rotterdam.nl_design_system.wicket.components.alert;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdAlertCss implements CssClassNames {
    OK("utrecht-alert utrecht-alert--" + RdAlertType.OK.type),
    INFO("utrecht-alert utrecht-alert--" + RdAlertType.INFO.type),
    WARNING("utrecht-alert utrecht-alert--" + RdAlertType.WARNING.type),
    ERROR("utrecht-alert utrecht-alert--" + RdAlertType.ERROR.type);

    private final String cssClassNames;

    RdAlertCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
