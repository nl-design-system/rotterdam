package nl.rotterdam.nl_design_system.wicket.components.unordered_list;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Unordered List component. Not yet usable.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdUnorderedList extends Panel {

    /**
     * Create new list.
     *
     * @param id the Wicket ID
     */
    public RdUnorderedList(String id) {
        super(id);
        add(RdUnorderedListBehavior.INSTANCE);
    }
}
