package nl.rotterdam.nl_design_system.wicket.components.table;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.HeadersToolbar;
import org.apache.wicket.model.IModel;

class RdHeadersToolbar<T, S> extends HeadersToolbar<S> {

    public <T> RdHeadersToolbar(DataTable<T, S> table, ISortStateLocator<S> stateLocator) {
        super(table, stateLocator);
    }

}
