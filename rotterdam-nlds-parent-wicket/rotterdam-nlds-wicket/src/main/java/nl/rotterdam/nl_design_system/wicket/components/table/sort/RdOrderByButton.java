package nl.rotterdam.nl_design_system.wicket.components.table.sort;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByLink;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.util.lang.Args;

/**
 * Copy of {@link org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByLink} but then as Button
 *
 * @param <S> type of sorting parameter
 *
 * @see OrderByLink
 */
public class RdOrderByButton<S> extends Button
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
    public void onSubmit() {
        super.onSubmit();
		sort();
		onSortChanged();
	}

	/**
	 * This method is a hook for subclasses to perform an action after sort has changed
	 */
	protected void onSortChanged()
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