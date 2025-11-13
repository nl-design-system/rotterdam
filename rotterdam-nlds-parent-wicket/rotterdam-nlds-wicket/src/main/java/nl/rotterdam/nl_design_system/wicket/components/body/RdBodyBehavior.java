package nl.rotterdam.nl_design_system.wicket.components.body;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.NOT_LISTED;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

/**
 * @see RdBodyBorder
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = NOT_LISTED, htmlCssImplementedBy = UTRECHT)
public class RdBodyBehavior extends TagNameClassComponentBehavior<RdBodyBorder> {

    /**
     * Singleton instance.
     */
    public static final RdBodyBehavior INSTANCE = new RdBodyBehavior();

    private RdBodyBehavior() {
        super("body", RdBodyCss.DEFAULT);
        addHeaderItem(cssReferenceHeaderItem(RdBodyBehavior.class, "@utrecht/body-css/dist/index.css"));
    }
}
