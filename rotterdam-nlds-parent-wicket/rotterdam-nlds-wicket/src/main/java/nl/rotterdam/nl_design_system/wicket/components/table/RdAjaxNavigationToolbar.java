package nl.rotterdam.nl_design_system.wicket.components.table;

import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxNavigationToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;

class RdAjaxNavigationToolbar extends AjaxNavigationToolbar {

    /**
     * Constructor.
     *
     * @param table data table this toolbar will be attached to
     */
    protected RdAjaxNavigationToolbar(DataTable<?, ?> table) {
        super(table);
    }

    @Override
    protected PagingNavigator newPagingNavigator(String navigatorId, DataTable<?, ?> table) {
        return new RdPagingNavigator(navigatorId, table);
    }
}
