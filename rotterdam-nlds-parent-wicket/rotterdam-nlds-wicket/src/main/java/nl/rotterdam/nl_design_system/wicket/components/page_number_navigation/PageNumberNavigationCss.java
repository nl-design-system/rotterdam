package nl.rotterdam.nl_design_system.wicket.components.page_number_navigation;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

public enum PageNumberNavigationCss implements CssClassNames {

    // TODO code uses before also for after. Introduced after instead.
    //  See https://github.com/nl-design-system/utrecht/issues/3005
    AFTER("utrecht-pagination__after"),
    BASE("utrecht-pagination utrecht-pagination--distanced"),
    LINK_ELEMENT_PAGES("utrecht-pagination__pages"),
    BEFORE("utrecht-pagination__before"),
    LINK_ELEMENT_NON_RELATIVE("utrecht-pagination__page-link"),
    LINK_ELEMENT_RELATIVE("utrecht-pagination__relative-link"),
    LINK_ELEMENT_RELATIVE_NEXT("utrecht-pagination__relative-link--next"),
    LINK_ELEMENT_RELATIVE_PREV("utrecht-pagination__relative-link--prev"),
    LINK_ELEMENT_RELATIVE_DISABLED("utrecht-pagination__relative-link--disabled"),
    LINK_ELEMENT_CURRENT("utrecht-pagination__page-link--current");

    private final String classNames;

    PageNumberNavigationCss(String classNames) {
        this.classNames = classNames;
    }


    @Override
    public String getClassNames() {
        return classNames;
    }
}
