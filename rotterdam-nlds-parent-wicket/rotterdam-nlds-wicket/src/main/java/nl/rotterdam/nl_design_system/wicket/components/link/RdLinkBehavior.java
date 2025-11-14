package nl.rotterdam.nl_design_system.wicket.components.link;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.html.link.AbstractLink;

/**
 * Add NL Design System link via a behavior. Used by various links type.
 * TODO consider to make this available internally in library only
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdLinkBehavior extends TagNameClassComponentBehavior<AbstractLink> {

    private static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        RdLinkBehavior.class,
        "@utrecht/link-css/dist/index.css"
    );

    /**
     * Singleton instance.
     */
    public static final RdLinkBehavior INSTANCE = new RdLinkBehavior();

    private RdLinkBehavior() {
        super("a", RdLinkCss.DEFAULT);
        addHeaderItem(CSS);
    }
}
