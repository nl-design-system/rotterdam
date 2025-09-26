package nl.rotterdam.design_system.wicket.components.heading_group.utrecht;

import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.border.Border;

import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY)
public class UtrechtHeadingGroupBorder extends Border {

    public UtrechtHeadingGroupBorder(String id) {
        super(id);
        add(new UtrechtHeadingGroupBehavior());
    }
}
