package nl.rotterdam.nl_design_system.docs.wicket.css;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum NldsVoorbeeldDesignSystemThemeCss implements CssClassNames {
    BASE("voorbeeld-theme");

    private final String classNames;

    NldsVoorbeeldDesignSystemThemeCss(String classNames) {
        this.classNames = classNames;
    }


    @Override
    public String getClassNames() {
        return classNames;
    }
}
