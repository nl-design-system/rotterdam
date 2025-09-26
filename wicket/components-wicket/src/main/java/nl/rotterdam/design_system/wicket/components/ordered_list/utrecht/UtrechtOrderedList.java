package nl.rotterdam.design_system.wicket.components.ordered_list.utrecht;

import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.panel.Panel;

import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY)
public class UtrechtOrderedList extends Panel {

    public UtrechtOrderedList(String id) {
        super(id);
    }
}
