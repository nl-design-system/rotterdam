package nl.rotterdam.nl_design_system.wicket.components.page_footer;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.border.Border;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

/**
 * <a href="https://nldesignsystem.nl/page-footer/">NL Design System Page Footer component</a>.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdPageFooterBorder extends Border {

    /**
     * Creates new instance
     * @param id the Wicket ID
     */
    public RdPageFooterBorder(String id) {
        super(id);
        add(RdPageFooterBehavior.INSTANCE);
    }
}
