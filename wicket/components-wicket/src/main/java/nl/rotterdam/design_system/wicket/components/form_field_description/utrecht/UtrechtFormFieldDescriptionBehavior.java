package nl.rotterdam.design_system.wicket.components.form_field_description.utrecht;

import nl.rotterdam.design_system.wicket.components.base.HeaderItemRenderingBehavior;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtFormFieldDescriptionBehavior extends HeaderItemRenderingBehavior {

    public static final UtrechtFormFieldDescriptionBehavior INSTANCE = new UtrechtFormFieldDescriptionBehavior();

    private UtrechtFormFieldDescriptionBehavior() {
        addHeaderItem(cssReferenceHeaderItem(UtrechtFormFieldDescriptionBehavior.class,
            "@utrecht/form-field-description-css/dist/index.css"));
    }

}
