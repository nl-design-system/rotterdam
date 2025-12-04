package nl.rotterdam.nl_design_system.wicket.components.data_summary;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdDataSummaryKeyCss implements CssClassNames {
    ITEM_KEY_ELEMENT("utrecht-data-list__item-key");

    private final String cssClassNames;

    RdDataSummaryKeyCss(String cssClassNames) {
        this.cssClassNames = cssClassNames;
    }

    @Override
    public String getClassNames() {
        return cssClassNames;
    }
}
