package nl.rotterdam.nl_design_system.wicket.components.badge_list;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;


/**
 * @see RdBadgeListBorder
 * TODO: use Border class instead of behavior directly (make it package private)
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdBadgeListBehavior extends TagNameClassComponentBehavior<Component> {

    private static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        RdBadgeListBehavior.class,
        "@utrecht/badge-list-css/dist/index.min.css"
    );

    public RdBadgeListBehavior() {
        super("div", RdBadgeListCss.DEFAULT);
        addHeaderItem(CSS);
    }
}
