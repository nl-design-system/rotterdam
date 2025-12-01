package nl.rotterdam.nl_design_system.wicket.components.page_footer;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdPageFooterCss implements CssClassNames {
    BASE("utrecht-page-footer");

    private final String classNames;

    RdPageFooterCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public String getClassNames() {
        return classNames;
    }
}
