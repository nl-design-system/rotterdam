package nl.rotterdam.nl_design_system.wicket.components.root;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.border.Border;

/**
 * <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-root--docs">Top component of page</a>.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdRootBorder extends Border {

    /**
     * Constructor.
     */
    public RdRootBorder(String id) {
        super(id);
        add(RdRootBehavior.INSTANCE);
    }
}
