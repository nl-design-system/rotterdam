package nl.rotterdam.design_system.wicket.components.breadcrumb_nav.utrecht;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.design_system.wicket.components.component_state.EstafetteState;
import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

public class UtrechtBreadcrumbNavBehavior extends TagNameClassComponentBehavior<Component> {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtBreadcrumbNavBehavior.class,
        "@utrecht/breadcrumb-nav-css/dist/index.css"
    );

    public UtrechtBreadcrumbNavBehavior() {
        super("nav", "utrecht-breadcrumb-nav");
        addHeaderItem(CSS);
    }
}
