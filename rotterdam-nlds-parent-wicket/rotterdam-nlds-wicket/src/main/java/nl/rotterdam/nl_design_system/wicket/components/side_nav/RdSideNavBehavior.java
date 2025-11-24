package nl.rotterdam.nl_design_system.wicket.components.side_nav;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

/**
 * @see RdSideNavPanel
 */
class RdSideNavBehavior extends TagNameClassComponentBehavior<Component> {

    static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        RdSideNavBehavior.class,
        "@gemeente-denhaag/sidenav/dist/index.css"
    );

    static final Behavior INSTANCE = new RdSideNavBehavior();

    private RdSideNavBehavior() {
        super("nav", RdSideNavCss.DEFAULT);
        addHeaderItem(CSS);
    }
}
