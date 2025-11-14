package nl.rotterdam.nl_design_system.wicket.components.column_layout;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.border.Border;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.NOT_LISTED;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

/**
 * <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-column-layout--docs">Column layout</a>
 *
 * <p>Utrecht specific component</p>
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = NOT_LISTED, htmlCssImplementedBy = UTRECHT)
public class RdColumnLayoutBorder extends Border {

    /**
     * Creates instance
     * @param id the Wicket ID
     */
    public RdColumnLayoutBorder(String id) {
        super(id);
        add(RdColumnLayoutBehavior.INSTANCE);
    }
}
