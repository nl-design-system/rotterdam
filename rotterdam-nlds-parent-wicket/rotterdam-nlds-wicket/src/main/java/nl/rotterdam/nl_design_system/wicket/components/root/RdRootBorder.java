package nl.rotterdam.nl_design_system.wicket.components.root;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.border.Border;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.PROPOSED_TO_REMOVE;

/**
 * <p>
 * <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-root--docs">Top component of page</a>.    
 * </p>
 * <p>
 * Why proposed to remove? Adding a border changes the hierarchy of the page/component. This affects all sub classes of
 * the component. {@link RdRootTransparentContainer} can be added to a page/component without having to add all children
 * to it.
 * </p>
 */
@NlComponentState(wicketState = PROPOSED_TO_REMOVE, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdRootBorder extends Border {

    /**
     * Constructor.
     */
    public RdRootBorder(String id) {
        super(id);
        add(RdRootBehavior.INSTANCE);
    }
}
