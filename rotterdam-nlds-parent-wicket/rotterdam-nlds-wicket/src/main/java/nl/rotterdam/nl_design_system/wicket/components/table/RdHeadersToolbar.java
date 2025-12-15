package nl.rotterdam.nl_design_system.wicket.components.table;

import nl.rotterdam.nl_design_system.wicket.components.table.sort.RdOrderByBorder;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.HeadersToolbar;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.LoadableDetachableModel;

import java.util.Locale;

import static nl.rotterdam.nl_design_system.wicket.components.table.RdTableCss.TH_HEADER_CEL_ELEMENT;

class RdHeadersToolbar<T, S> extends HeadersToolbar<S> {

    public <T> RdHeadersToolbar(DataTable<T, S> table, ISortStateLocator<S> stateLocator) {
        super(table, stateLocator);
    }

    @Override
    protected WebMarkupContainer newSortableHeader(String headerId, S property, ISortStateLocator<S> locator) {

        return new RdOrderByBorder<>(headerId, property, locator) {
            @Override
            protected void onInitialize() {
                super.onInitialize();

                add(
                    AttributeModifier.replace("scope", "col"),
                    AttributeModifier.replace("aria-sort", new AriaSortSortNameLdm(locator, property)),
                    AttributeModifier.replace("class", TH_HEADER_CEL_ELEMENT.getClassNames())
                );
            }

            @Override
            protected void onSortChanged() {
                getTable().setCurrentPage(0);
            }
        };
    }

    private class AriaSortSortNameLdm extends LoadableDetachableModel<String> {

        private final ISortStateLocator<S> locator;
        private final S property;

        public AriaSortSortNameLdm(ISortStateLocator<S> locator, S property) {
            this.locator = locator;
            this.property = property;
        }

        @Override
        protected String load() {
            SortOrder sortOrder = locator.getSortState().getPropertySortOrder(property);

            return sortOrder.name().toLowerCase(Locale.ROOT);
        }
    }
}
