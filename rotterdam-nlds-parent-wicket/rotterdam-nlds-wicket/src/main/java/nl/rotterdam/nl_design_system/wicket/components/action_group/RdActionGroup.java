package nl.rotterdam.nl_design_system.wicket.components.action_group;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.UNSTABLE;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.border.Border;

/**
 * Action group has a list of actions, often {@link nl.rotterdam.nl_design_system.wicket.components.button.RdButton}s.
 * TODO: use https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-action-group--docs
 *  (also verify that RdButton works properly with it)
 */
@NlComponentState(wicketState = UNSTABLE, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdActionGroup extends Border {

    /**
     * Create new instance. Use {@link #add(Component...)} to add buttons.
     */
    public RdActionGroup(String id) {
        super(id);
        add(RdActionGroupBehavior.INSTANCE);
    }
}
