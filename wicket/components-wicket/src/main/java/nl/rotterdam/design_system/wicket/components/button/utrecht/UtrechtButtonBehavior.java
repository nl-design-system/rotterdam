package nl.rotterdam.design_system.wicket.components.button.utrecht;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.html.form.Button;

public class UtrechtButtonBehavior extends TagNameClassComponentBehavior<Button> {


    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        UtrechtButtonBehavior.class,
        "@utrecht/button-css/dist/index.css"
    );

    public static final UtrechtButtonBehavior INSTANCE = new UtrechtButtonBehavior();

    private UtrechtButtonBehavior() {
        super("button", "utrecht-button", "utrecht-button--html-button");
        addHeaderItem(CSS);
    }
}
