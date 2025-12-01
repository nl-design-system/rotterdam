package nl.rotterdam.nl_design_system.wicket.components.body;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.border.Border;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.PROPOSED_TO_REMOVE;

/**
 * <p>
 * <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-body--docs">Utrecht body</a> component.
 * </p>
 * <p>
 * Why proposed to remove? Adding a border changes the hierarchy of the page/component. This affects all sub classes of
 * the component. {@link RdBodyTransparentContainer} can be added to a page/component without having to add all children
 * to it.
 * </p>
 * TODO: decide if this is needed for all pages.
 * TODO: what is difference between body and page_body?
 */
@NlComponentState(wicketState = PROPOSED_TO_REMOVE, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdBodyBorder extends Border {

    public RdBodyBorder(String id) {
        super(id);
        add(RdBodyBehavior.INSTANCE);
    }
}
