package nl.rotterdam.nl_design_system.wicket.components.heading_group;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.border.Border;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

/**
 * <a href="https://nldesignsystem.nl/heading-group/">NL Design System Heading Group component</a>.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdHeadingGroupBorder extends Border {

    /**
     * Create new instance.
     * @param id Wicket ID
     */
    public RdHeadingGroupBorder(String id) {
        super(id);
        add(RdHeadingGroupBehavior.INSTANCE);
    }
}
