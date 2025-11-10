package nl.rotterdam.nl_design_system.wicket.components.page_layout;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.HELP_WANTED;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.border.Border;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = HELP_WANTED, htmlCssImplementedBy = UTRECHT)
public class RdPageLayoutBorder extends Border {

    public RdPageLayoutBorder(String id) {
        super(id);
        add(new RdPageLayoutBehavior());
    }
}
