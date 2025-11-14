package nl.rotterdam.nl_design_system.wicket.components.visually_hidden;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdVisuallyHiddenCss implements CssClassNames {
    DEFAULT("ams-visually-hidden");

    private final String classNames;

    RdVisuallyHiddenCss(String classNames) {
        this.classNames = classNames;
    }


    @Override
    public String getClassNames() {
        return classNames;
    }
}
