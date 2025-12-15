package nl.rotterdam.nl_design_system.wicket.components.table;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import java.util.List;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

class RdTableBehavior extends TagNameClassComponentBehavior<DataTable<?, ?>> {

    static final CssReferenceHeaderItem CSS_HEADER_ITEM = cssReferenceHeaderItem(
        RdTableBehavior.class,
        "@utrecht/table-css/dist/index.min.css"
    );

    static final RdTableBehavior INSTANCE = new RdTableBehavior();

    private RdTableBehavior() {
        super("table", RdTableCss.BASE);
        addHeaderItem(CSS_HEADER_ITEM);
    }

    @Override
    protected List<CssClassNames> customizeComponentAndReturnClasses(DataTable<?, ?> component, ComponentTag tag) {
        return super.customizeComponentAndReturnClasses(component, tag);
    }
}
