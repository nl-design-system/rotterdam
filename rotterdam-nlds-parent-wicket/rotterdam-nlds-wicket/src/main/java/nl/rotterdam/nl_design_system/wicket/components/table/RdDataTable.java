package nl.rotterdam.nl_design_system.wicket.components.table;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

import java.util.List;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.BETA;

/**
 * <a href="https://nldesignsystem.nl/table/">Table</a> NL Design System implementation.
 *
 * <p>Uses the <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-table--docs">
 *     Utrecht Table</a> community implementation.
 * </p>
 *
 * <p>This component extends Wicket's {@link DataTable} and applies Utrecht CSS styling.
 * It can display text columns, action links (edit, details), and supports row reordering.</p>
 *
 * <p>Attach this component to a {@code <div>} tag in your HTML markup.</p>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * List<IColumn<Person, String>> columns = List.of(
 *     new PropertyColumn<>(Model.of("Name"), "name"),
 *     new PropertyColumn<>(Model.of("Email"), "email")
 * );
 * IDataProvider<Person> dataProvider = new ListDataProvider<>(persons);
 * RdDataTable<Person, String> table = new RdDataTable<>("table", columns, dataProvider, 10);
 * add(table);
 * }</pre>
 *
 * @param <T> The model object type
 * @param <S> The type of the sort property
 *
 * @see DataTable
 * @see <a href="https://nldesignsystem.nl/table/">NL Design System Table</a>
 * @see <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-table--docs">Utrecht Table Documentation</a>
 */
@NlComponentState(wicketState = BETA, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdDataTable<T extends @Nullable Object, S extends @Nullable Object> extends DefaultDataTable<T, S> {

    /**
     * Constructor.
     *
     * @param id component id
     * @param columns list of columns
     * @param dataProvider data provider
     * @param rowsPerPage number of rows per page
     */
    public RdDataTable(String id,
                       List<? extends IColumn<T, S>> columns,
                       ISortableDataProvider<T, S> dataProvider,
                       int rowsPerPage) {
        super(id, columns, dataProvider, rowsPerPage);
    }


    @Override
    protected void onInitialize() {
        super.onInitialize();

        initializeNldsStyle();

        add(RdTableBehavior.INSTANCE);
    }

    private void initializeNldsStyle() {
        get("caption").add(RdTableCss.CAPTION_ELEMENT.asBehavior());
        get("topToolbars").add(RdTableCss.THEAD_ELEMENT.asBehavior());
    }

    @Override
    protected Item<T> newRowItem(String id, int index, IModel<T> model) {
        Item<T> item = super.newRowItem(id, index, model);

        item.add(AttributeModifier.append("class", "utrecht-table__row"));

        var extraClass = (index % 2 == 0) ? RdTableCss.TR_ELEMENT_EVEN : RdTableCss.TR_ELEMENT_ODD;
        item.add(extraClass.asBehavior());
        return item;
    }


}
