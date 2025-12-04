package nl.rotterdam.nl_design_system.wicket.components.logo;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
class RdLogoBehavior extends TagNameClassComponentBehavior<RdLogoBorder> {

    public static final RdLogoBehavior INSTANCE = new RdLogoBehavior();

    private RdLogoBehavior() {
        super("div", RdLogoCss.BASE);
        addHeaderItem(cssReferenceHeaderItem(RdLogoBehavior.class, "@utrecht/logo-css/dist/index.min.css"));
    }

}
