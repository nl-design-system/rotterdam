package nl.rotterdam.nl_design_system.wicket.components.page_number_navigation;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

public enum PageNumberNavigationCssClassnames implements CssClassNames {

    BASE ("utrecht-pagination utrecht-pagination--distanced"),
    LINK_ELEMENT_BASE("utrecht-pagination__page-link"),
    LINK_ELEMENT_CURRENT("utrecht-pagination__page-link--current")
    ;

    private final String classNames;

    PageNumberNavigationCssClassnames(String classNames) {
        this.classNames = classNames;
    }


    @Override
    public String getClassNames() {
        return classNames;
    }
}
