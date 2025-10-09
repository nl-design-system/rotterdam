package nl.rotterdam.design_system.wicket.components.button_group;

import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.border.Border;

import static nl.rotterdam.design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.UNSTABLE;

/**
 * Action group based on Utrecht Button Group.
 *
 * TODO: use https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-action-group--docs
 * (also verify that RdButton works properly with it)
 */
@NlComponentState(wicketState = UNSTABLE, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdActionGroup extends Border {

    public RdActionGroup(String id) {
        super(id);
        add(RdActionGroupBehavior.INSTANCE);
    }
}
