package nl.rotterdam.design_system.wicket.components.form_field.utrecht;

import nl.rotterdam.design_system.wicket.components.base.HeaderItemRenderingBehavior;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtFormFieldBehavior extends HeaderItemRenderingBehavior {

    public static final UtrechtFormFieldBehavior INSTANCE = new UtrechtFormFieldBehavior();

    private UtrechtFormFieldBehavior() {
        addHeaderItem(cssReferenceHeaderItem(UtrechtFormFieldBehavior.class, "@utrecht/form-field-css/dist/index.css"));
    }
}
