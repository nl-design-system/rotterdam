package nl.rotterdam.nl_design_system.wicket.components.body.utrecht;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.base.HeaderItemRenderingBehavior;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class UtrechtBodyBehavior extends HeaderItemRenderingBehavior {

    public static final UtrechtBodyBehavior INSTANCE = new UtrechtBodyBehavior();

    private UtrechtBodyBehavior() {
        addHeaderItem(cssReferenceHeaderItem(UtrechtBodyBehavior.class, "@utrecht/body-css/dist/index.css"));
    }
}
