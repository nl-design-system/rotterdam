package nl.rotterdam.design_system.wicket.components.form_field_description.utrecht;

import nl.rotterdam.design_system.wicket.components.base.HeaderItemRenderingBehavior;
import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtFormFieldDescriptionBehavior extends TagNameClassComponentBehavior {

    public static final UtrechtFormFieldDescriptionBehavior INSTANCE = new UtrechtFormFieldDescriptionBehavior();

    private UtrechtFormFieldDescriptionBehavior() {
        super("div");
        addHeaderItem(cssReferenceHeaderItem(UtrechtFormFieldDescriptionBehavior.class,
            "@utrecht/form-field-description-css/dist/index.css"));
    }
}
