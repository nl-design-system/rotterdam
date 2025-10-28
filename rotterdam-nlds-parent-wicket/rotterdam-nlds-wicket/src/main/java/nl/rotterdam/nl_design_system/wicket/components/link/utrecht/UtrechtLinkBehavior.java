package nl.rotterdam.nl_design_system.wicket.components.link.utrecht;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.html.link.AbstractLink;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class UtrechtLinkBehavior extends TagNameClassComponentBehavior<AbstractLink> {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtLinkBehavior.class,
        "@utrecht/link-css/dist/index.css"
    );

    public UtrechtLinkBehavior() {
        super("a", RdLinkCss.DEFAULT);
        addHeaderItem(CSS);
    }
}
