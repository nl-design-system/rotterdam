package nl.rotterdam.design_system.wicket.components.checkbox.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtCheckboxContainerBehavior extends TagNameClassComponentBehavior {

    public static final UtrechtCheckboxContainerBehavior INSTANCE = new UtrechtCheckboxContainerBehavior();
    private UtrechtCheckboxContainerBehavior() {
        super("div", "utrecht-form-field--checkbox");

        addHeaderItem(cssReferenceHeaderItem(UtrechtCheckboxContainerBehavior.class, "@utrecht/checkbox-css/dist/index.css"));
        addHeaderItem(cssReferenceHeaderItem(UtrechtCheckboxContainerBehavior.class, "@utrecht/custom-checkbox-css/dist/index.css"));
    }
}
