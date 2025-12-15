package nl.rotterdam.nl_design_system.wicket.components.table;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdTableCss implements CssClassNames {
    BASE("utrecht-table"),
    CAPTION_ELEMENT("utrecht-table__caption"),
    THEAD_ELEMENT("utrecht-table__header"),
    TR_ELEMENT_ODD("utrecht-table__row--alternate-odd"),
    TH_HEADER_CEL_ELEMENT("utrecht-table__header-cell"),
    TR_ELEMENT_EVEN("utrecht-table__row--alternate-even"),
    ;

    private final String classNames;

    RdTableCss(String classNames) {
        this.classNames = classNames;
    }

    @Override
    public String getClassNames() {
        return classNames;
    }
}
