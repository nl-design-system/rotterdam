package nl.rotterdam.nl_design_system.wicket.components.visually_hidden;

import nl.rotterdam.nl_design_system.wicket.components.base.ClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.component_state.Community;
import nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

/**
 * <p>
 * A behavior to add a CSS class indicating that the element is hidden for sighted users.
 * </p>
 */
@NlComponentState(wicketState = WicketState.UNSTABLE, estafetteState = EstafetteState.NOT_LISTED, htmlCssImplementedBy = Community.AMSTERDAM)
public class RdVisuallyHiddenBehavior extends ClassComponentBehavior<Component> {

    static final CssReferenceHeaderItem CSS_HEADER_ITEM = cssReferenceHeaderItem(
        RdVisuallyHiddenBehavior.class,
        "@amsterdam/design-system-css/dist/visually-hidden/visually-hidden.css"
    );

    /**
     * <p>
     * The single instance that can be used for all components.
     * </p>
     */
    public static final RdVisuallyHiddenBehavior INSTANCE = new RdVisuallyHiddenBehavior();

    private RdVisuallyHiddenBehavior() {
        super(RdVisuallyHiddenCss.DEFAULT);
        addHeaderItem(CSS_HEADER_ITEM);
    }
}
