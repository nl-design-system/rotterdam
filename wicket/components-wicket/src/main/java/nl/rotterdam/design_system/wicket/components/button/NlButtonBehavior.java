package nl.rotterdam.design_system.wicket.components.button;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.html.form.Button;

class NlButtonBehavior extends TagNameClassComponentBehavior<Button> {

    static final CssReferenceHeaderItem CSS_HEADER_ITEM = cssReferenceHeaderItem(
        NlButtonBehavior.class,
        "@utrecht/button-css/dist/index.css"
    );

    public static final NlButtonBehavior INSTANCE = new NlButtonBehavior();

    private NlButtonBehavior() {
        super("button", "utrecht-button", "utrecht-button--html-button");
        addHeaderItem(CSS_HEADER_ITEM);
    }
}
