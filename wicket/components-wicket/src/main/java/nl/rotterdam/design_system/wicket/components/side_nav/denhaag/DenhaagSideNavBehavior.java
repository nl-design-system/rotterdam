package nl.rotterdam.design_system.wicket.components.side_nav.denhaag;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

public class DenhaagSideNavBehavior extends TagNameClassComponentBehavior<Component> {

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        DenhaagSideNavBehavior.class,
        "@gemeente-denhaag/sidenav/dist/index.css"
    );

    public DenhaagSideNavBehavior() {
        super("nav", "denhaag-sidenav");
        addHeaderItem(CSS);
    }
}
