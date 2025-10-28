package nl.rotterdam.nl_design_system.wicket.components.button;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.html.form.Button;

class RdButtonBehavior extends TagNameClassComponentBehavior<Button> {

    static final CssReferenceHeaderItem CSS_HEADER_ITEM = cssReferenceHeaderItem(
        RdButtonBehavior.class,
        "@utrecht/button-css/dist/index.css"
    );

    public static final RdButtonBehavior INSTANCE = new RdButtonBehavior();

    private RdButtonBehavior() {
        super("button", RdButtonCss.DEFAULT);
        addHeaderItem(CSS_HEADER_ITEM);
    }
}
