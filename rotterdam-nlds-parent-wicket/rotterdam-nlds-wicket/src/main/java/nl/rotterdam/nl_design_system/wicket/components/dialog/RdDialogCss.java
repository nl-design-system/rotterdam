package nl.rotterdam.nl_design_system.wicket.components.dialog;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdDialogCss implements CssClassNames {
    DEFAULT("ams-dialog");

    private final String classNames;

    RdDialogCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public String getClassNames() {
        return classNames;
    }
}
