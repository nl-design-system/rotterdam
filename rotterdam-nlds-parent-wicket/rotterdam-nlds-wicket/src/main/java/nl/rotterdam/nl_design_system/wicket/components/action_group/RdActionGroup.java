package nl.rotterdam.nl_design_system.wicket.components.action_group;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.UNSTABLE;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.border.Border;

/**
 * <p>
 * Action group based on Utrecht Button Group.
 * </p>
 */
// TODO: use https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-action-group--docs
// (also verify that RdButton works properly with it)
@NlComponentState(wicketState = UNSTABLE, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdActionGroup extends Border {

    public RdActionGroup(String id) {
        super(id);
        add(RdActionGroupBehavior.INSTANCE);
    }
}
