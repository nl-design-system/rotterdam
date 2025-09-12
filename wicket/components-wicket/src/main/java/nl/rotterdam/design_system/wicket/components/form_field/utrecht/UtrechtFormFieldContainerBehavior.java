package nl.rotterdam.design_system.wicket.components.form_field.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtFormFieldContainerBehavior extends TagNameClassComponentBehavior {

    public static final UtrechtFormFieldContainerBehavior INSTANCE = new UtrechtFormFieldContainerBehavior();

    private UtrechtFormFieldContainerBehavior() {
        super("div", "utrecht-form-field");
        addHeaderItem(cssReferenceHeaderItem(UtrechtFormFieldContainerBehavior.class, "@utrecht/form-field-css/dist/index.css"));
    }
}
