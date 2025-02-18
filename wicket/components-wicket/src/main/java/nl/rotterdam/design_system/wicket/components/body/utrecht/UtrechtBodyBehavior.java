package nl.rotterdam.design_system.wicket.components.body.utrecht;

import nl.rotterdam.design_system.wicket.components.base.HeaderItemRenderingBehavior;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtBodyBehavior extends HeaderItemRenderingBehavior {

    public static final UtrechtBodyBehavior INSTANCE = new UtrechtBodyBehavior();

    private UtrechtBodyBehavior() {
        addHeaderItem(cssReferenceHeaderItem(UtrechtBodyBehavior.class, "@utrecht/body-css/dist/index.css"));
    }
}
