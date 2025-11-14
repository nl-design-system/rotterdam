package nl.rotterdam.nl_design_system.wicket.components.html_content;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdHtmlContentCss implements CssClassNames {
    DEFAULT("utrecht-html");

    private final String classNames;

    RdHtmlContentCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public String getClassNames() {
        return classNames;
    }
}
