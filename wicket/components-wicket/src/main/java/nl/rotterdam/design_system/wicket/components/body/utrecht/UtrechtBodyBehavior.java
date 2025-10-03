package nl.rotterdam.design_system.wicket.components.body.utrecht;

import nl.rotterdam.design_system.wicket.components.base.HeaderItemRenderingBehavior;
import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.UNSTABLE;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class UtrechtBodyBehavior extends HeaderItemRenderingBehavior {

    public static final UtrechtBodyBehavior INSTANCE = new UtrechtBodyBehavior();

    private UtrechtBodyBehavior() {
        addHeaderItem(cssReferenceHeaderItem(UtrechtBodyBehavior.class, "@utrecht/body-css/dist/index.css"));
    }
}
