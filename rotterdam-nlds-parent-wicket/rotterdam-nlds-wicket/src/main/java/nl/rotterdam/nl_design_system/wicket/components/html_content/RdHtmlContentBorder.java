package nl.rotterdam.nl_design_system.wicket.components.html_content;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.border.Border;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.NOT_LISTED;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

/**
 * Render HTML content.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = NOT_LISTED, htmlCssImplementedBy = UTRECHT)
public class RdHtmlContentBorder extends Border {

    /**
     * Create new instance
     * @param id the Wicket ID
     */
    public RdHtmlContentBorder(String id) {
        super(id);
        add(RdHtmlContentBehavior.INSTANCE);
    }
}
