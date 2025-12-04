package nl.rotterdam.nl_design_system.wicket.components.data_summary;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdDataSummaryItemCss implements CssClassNames {
    ITEM_ELEMENT("utrecht-data-list__item");

    private final String cssClassNames;

    RdDataSummaryItemCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
