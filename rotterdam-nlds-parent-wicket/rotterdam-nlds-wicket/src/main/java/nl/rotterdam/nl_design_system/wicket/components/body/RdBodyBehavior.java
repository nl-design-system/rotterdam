package nl.rotterdam.nl_design_system.wicket.components.body;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.base.HeaderItemRenderingBehavior;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdBodyBehavior extends HeaderItemRenderingBehavior {

    public static final RdBodyBehavior INSTANCE = new RdBodyBehavior();

    private RdBodyBehavior() {
        addHeaderItem(cssReferenceHeaderItem(RdBodyBehavior.class, "@utrecht/body-css/dist/index.css"));
    }
}
