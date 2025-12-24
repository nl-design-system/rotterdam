package nl.rotterdam.nl_design_system.wicket.components.table;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;

enum RdTableCss implements CssClassNames {
    BASE("utrecht-table"),
    CAPTION_ELEMENT("utrecht-table__caption"),
    THEAD_ELEMENT("utrecht-table__header"),
    TABLE_ROW_ELEMENT_CSS("utrecht-table__row"),
    TABLE_ROW_ELEMENT_ODD("utrecht-table__row--alternate-odd"),
    TABLE_BODY_CELL_ELEMENT("utrecht-table__cell"),
    TABLE_HEADER_CELL_ELEMENT("utrecht-table__header-cell"),
    TABLE_ROW_ELEMENT_EVEN("utrecht-table__row--alternate-even"),
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
