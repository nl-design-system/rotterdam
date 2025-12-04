package nl.rotterdam.nl_design_system.wicket.components.data_summary;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdDataSummaryValueCss implements CssClassNames {
    ITEM_VALUE_ELEMENT("utrecht-data-list__item-value utrecht-data-list__item-value--html-dd");

    private final String cssClassNames;

    RdDataSummaryValueCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
