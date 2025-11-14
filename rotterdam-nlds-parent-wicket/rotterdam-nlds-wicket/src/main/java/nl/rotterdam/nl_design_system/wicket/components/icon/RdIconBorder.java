package nl.rotterdam.nl_design_system.wicket.components.icon;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.border.Border;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

/**
 * <a href="https://nldesignsystem.nl/icon/">NL Design System Icon component</a>.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdIconBorder extends Border {

    /**
     * Create instance.
     * @param id the Wicket ID
     */
    public RdIconBorder(String id) {
        super(id);
        add(RdIconBehavior.INSTANCE);
    }
}
