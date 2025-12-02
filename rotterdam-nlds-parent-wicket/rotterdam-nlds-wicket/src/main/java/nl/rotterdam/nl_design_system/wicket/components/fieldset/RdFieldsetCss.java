package nl.rotterdam.nl_design_system.wicket.components.fieldset;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdFieldsetCss implements CssClassNames {
    BASE("utrecht-form-fieldset"),
    FIELDSET_ELEMENT("utrecht-form-fieldset__fieldset"),
    HTML_FIELDSET("utrecht-form-fieldset--html-fieldset"),
    INVALID("utrecht-form-fieldset--invalid"),
    LEGEND_ELEMENT("utrecht-form-fieldset__legend"),
    LEGEND_ELEMENT_HTML_LEGEND("utrecht-form-fieldset__legend--html-legend"),
    SECTION("utrecht-form-fieldset--section");

    private final String cssClassNames;

    RdFieldsetCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
