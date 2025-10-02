package nl.rotterdam.design_system.wicket.components.badge_list.utrecht;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.UNSTABLE;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class UtrechtBadgeListBehavior extends TagNameClassComponentBehavior<Component> {

    private static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtBadgeListBehavior.class,
        "@utrecht/badge-list-css/dist/index.css"
    );

    public UtrechtBadgeListBehavior() {
        super("div", "utrecht-badge-list");
        addHeaderItem(CSS);
    }
}
