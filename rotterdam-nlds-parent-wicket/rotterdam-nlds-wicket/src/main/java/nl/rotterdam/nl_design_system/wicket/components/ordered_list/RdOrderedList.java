package nl.rotterdam.nl_design_system.wicket.components.ordered_list;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * @deprecated implementation incomplete
 */
@Deprecated
@SuppressWarnings("doclint:missing")
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdOrderedList extends Panel {

    public RdOrderedList(String id) {
        super(id);
    }
}
