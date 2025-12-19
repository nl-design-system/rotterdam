package nl.rotterdam.nl_design_system.wicket.components.table;

import nl.rotterdam.nl_design_system.wicket.components.table.sort.RdOrderByBorder;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.*;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import static nl.rotterdam.nl_design_system.wicket.components.table.RdTableCss.TABLE_HEAD_HEADER_CEL_ELEMENT;

/**
 * Header toolbar styled for NLDS styles.
 *
 * <p>Much of the code is copy-pasted from {@link HeadersToolbar}, as it is not adaptable enough to support
 * NLDS styling.</p>
 *
 * @param <SORT_TYPE> sort type
 */
class RdHeadersToolbar<SORT_TYPE> extends AbstractToolbar {

    protected <MODEL_TYPE> RdHeadersToolbar(DataTable<MODEL_TYPE, SORT_TYPE> table, ISortStateLocator<SORT_TYPE> stateLocator) {
        super(table);

        RefreshingView<IColumn<MODEL_TYPE, SORT_TYPE>> headers = new RefreshingView<>("headers") {
            @Override
            protected Iterator<IModel<IColumn<MODEL_TYPE, SORT_TYPE>>> getItemModels() {
                List<IModel<IColumn<MODEL_TYPE, SORT_TYPE>>> columnsModels = new LinkedList<>();

                for (IColumn<MODEL_TYPE, SORT_TYPE> column : table.getColumns()) {
                    columnsModels.add(Model.of(column));
                }

                return columnsModels.iterator();
            }

            @Override
            protected void populateItem(Item<IColumn<MODEL_TYPE, SORT_TYPE>> item) {
                final IColumn<MODEL_TYPE, SORT_TYPE> column = item.getModelObject();

                WebMarkupContainer header;

                if (column.isSortable()) {
                    header = newSortableHeader("header", column.getSortProperty(), stateLocator);
                } else {
                    header = newNonSortableHeader("header");
                }

                if (column.getHeaderColspan() > 1) {
                    header.add(AttributeModifier.replace("colspan", column.getHeaderColspan()));
                    header.add(AttributeModifier.replace("scope", "colgroup"));
                } else {
                    header.add(AttributeModifier.replace("scope", "col"));
                }

                if (column.getHeaderRowspan() > 1) {
                    header.add(AttributeModifier.replace("rowspan", column.getHeaderRowspan()));
                }

                item.add(header);
                item.setRenderBodyOnly(true);
                header.add(column.getHeader("label"));
            }
        };
        add(headers);
    }

    private static WebMarkupContainer newNonSortableHeader(String id) {
        WebMarkupContainer header = new WebMarkupContainer(id);
        header
            .add(AttributeModifier.replace("class", TABLE_HEAD_HEADER_CEL_ELEMENT.getClassNames()));

        return header;
    }

    protected WebMarkupContainer newSortableHeader(String headerId, SORT_TYPE property, ISortStateLocator<SORT_TYPE> locator) {

        return new RdOrderByBorder<>(headerId, property, locator) {
            @Override
            protected void onInitialize() {
                super.onInitialize();

                add(
                    AttributeModifier.replace("scope", "col"),
                    AttributeModifier.replace("aria-sort", new AriaSortSortNameLdm(locator, property)),
                    AttributeModifier.replace("class", TABLE_HEAD_HEADER_CEL_ELEMENT.getClassNames())
                );
            }


            @Override
            protected void onSortChanged(AjaxRequestTarget target) {
                getTable().setCurrentPage(0);
                target.add(getTable());
            }
        };
    }

    private class AriaSortSortNameLdm extends LoadableDetachableModel<String> {

        private final ISortStateLocator<SORT_TYPE> locator;
        private final SORT_TYPE property;

        public AriaSortSortNameLdm(ISortStateLocator<SORT_TYPE> locator, SORT_TYPE property) {
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
