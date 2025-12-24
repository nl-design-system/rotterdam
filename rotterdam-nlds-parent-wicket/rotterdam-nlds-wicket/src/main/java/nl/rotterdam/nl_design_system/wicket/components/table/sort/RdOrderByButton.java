package nl.rotterdam.nl_design_system.wicket.components.table.sort;

import nl.rotterdam.nl_design_system.wicket.components.button.RdAjaxButton;
import nl.rotterdam.nl_design_system.wicket.components.button.RdButtonAppearance;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByLink;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.util.lang.Args;

/**
 * Copy of {@link org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByLink} but then as Button
 *
 * @param <S> type of sorting parameter
 *
 * @see OrderByLink
 */
public class RdOrderByButton<S> extends RdAjaxButton
{
	/** sortable property */
	private final S property;

	/** locator for sort state object */
	private final ISortStateLocator<S> stateLocator;

	/**
	 * Constructor.
	 *
	 * @param id
	 *            the component id of the link
	 * @param property
	 *            the name of the sortable property this link represents. this value will be used as
	 *            parameter for sort state object methods. sort state object will be located via the
	 *            stateLocator argument.
	 * @param stateLocator
	 *            locator used to locate sort state object that this will use to read/write state of
	 *            sorted properties
	 *
	 */
	public RdOrderByButton(final String id, final S property, final ISortStateLocator<S> stateLocator)
	{
		super(id);

		Args.notNull(property, "property");

		this.property = property;
		this.stateLocator = stateLocator;
	}

    @Override
    protected void onInitialize() {
        super.onInitialize();

        setAppearance(RdButtonAppearance.SUBTLE);

        // TODO: haal SVG van classpath (moeten wel inline blijven ivm dark mode support)
        var sortIconModel = new LoadableDetachableModel<String>() {

            @Override
            protected String load() {
                SortOrder sortOrder = stateLocator.getSortState().getPropertySortOrder(property);

                return switch (sortOrder) {
                    case NONE ->
// language=svg
"""
<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="tabler-icon tabler-icon-arrows-sort"><path d="M3 9l4 -4l4 4m-4 -4v14"></path><path d="M21 15l-4 4l-4 -4m4 4v-14"></path></svg>                        
""";
                    case ASCENDING ->
//language=svg
"""
<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="tabler-icon tabler-icon-sort-ascending"><path d="M4 6l7 0"></path><path d="M4 12l7 0"></path><path d="M4 18l9 0"></path><path d="M15 9l3 -3l3 3"></path><path d="M18 6l0 12"></path></svg>
""";
                    case DESCENDING ->
// language=svg
"""
<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="tabler-icon tabler-icon-sort-descending"><path d="M4 6l9 0"></path><path d="M4 12l7 0"></path><path d="M4 18l7 0"></path><path d="M15 15l3 3l3 -3"></path><path d="M18 6l0 12"></path></svg>                        
""";
                };
            }
        };

        add(new Label("icon", sortIconModel)
            .setEscapeModelStrings(false));
    }

    @Override
    public void onSubmit(AjaxRequestTarget target) {
        super.onSubmit();
		sort();
		onSortChanged(target);
	}

	/**
	 * This method is a hook for subclasses to perform an action after sort has changed
	 */
	protected void onSortChanged(AjaxRequestTarget target)
	{
		// noop
	}

	/**
	 * Re-sort data provider according to this link
	 * 
	 * @return this
	 */
	public final RdOrderByButton<S> sort()
	{
		if (isVersioned())
		{
			// version the old state
			addStateChange();
		}

		ISortState<S> state = stateLocator.getSortState();

		// get current sort order
		SortOrder order = state.getPropertySortOrder(property);

		// set next sort order
		state.setPropertySortOrder(property, nextSortOrder(order));

		return this;
	}

	/**
	 * returns the next sort order when changing it
	 * 
	 * @param order
	 *            previous sort order
	 * @return next sort order
	 */
	protected SortOrder nextSortOrder(final SortOrder order)
	{
		// init / flip order
		if (order == SortOrder.NONE)
		{
			return SortOrder.ASCENDING;
		}
		else
		{
			return order == SortOrder.ASCENDING ? SortOrder.DESCENDING : SortOrder.ASCENDING;
		}
	}
}