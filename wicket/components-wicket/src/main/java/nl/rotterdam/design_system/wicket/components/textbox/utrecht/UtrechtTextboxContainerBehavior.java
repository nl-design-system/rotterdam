package nl.rotterdam.design_system.wicket.components.textbox.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtTextboxContainerBehavior extends TagNameClassComponentBehavior {

    public static final UtrechtTextboxContainerBehavior INSTANCE = new UtrechtTextboxContainerBehavior();

    private UtrechtTextboxContainerBehavior() {
        super("div", "utrecht-form-field--text");
        addHeaderItem(cssReferenceHeaderItem(UtrechtTextboxContainerBehavior.class, "@utrecht/textbox-css/dist/index.css"));
    }

}
