package nl.rotterdam.design_system.wicket.components.page_header.utrecht;

import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.border.Border;

import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY)
public class UtrechtPageHeaderBorder extends Border {

    public UtrechtPageHeaderBorder(String id) {
        super(id);
        add(new UtrechtPageHeaderBehavior());
    }
}
