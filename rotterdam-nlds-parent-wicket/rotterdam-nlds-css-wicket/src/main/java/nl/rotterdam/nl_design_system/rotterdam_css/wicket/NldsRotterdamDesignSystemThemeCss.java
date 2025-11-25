package nl.rotterdam.nl_design_system.rotterdam_css.wicket;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum NldsRotterdamDesignSystemThemeCss implements CssClassNames {
    DEFAULT("rods-theme");

    private final String classNames;

    NldsRotterdamDesignSystemThemeCss(String classNames) {
        this.classNames = classNames;
    }


    @Override
    public String getClassNames() {
        return classNames;
    }
}
