package nl.rotterdam.design_system.wicket.components.button;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.html.form.Button;

public class NlButtonBehavior extends TagNameClassComponentBehavior<Button> {


    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        NlButtonBehavior.class,
        "@utrecht/button-css/dist/index.css"
    );

    public static final NlButtonBehavior INSTANCE = new NlButtonBehavior();

    private NlButtonBehavior() {
        super("button", "utrecht-button", "utrecht-button--html-button");
        addHeaderItem(CSS);
    }
}
