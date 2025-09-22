package nl.rotterdam.design_system.wicket.components.form_field.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;
import static nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldCssClassNames.UTRECHT_FORM_FIELD_CLASS_NAME;

public class UtrechtFormFieldBehavior extends TagNameClassComponentBehavior<Component> {

    public static final UtrechtFormFieldBehavior INSTANCE = new UtrechtFormFieldBehavior();

    private UtrechtFormFieldBehavior() {
        super("div", UTRECHT_FORM_FIELD_CLASS_NAME);
        addHeaderItem(cssReferenceHeaderItem(UtrechtFormFieldBehavior.class, "@utrecht/form-field-css/dist/index.css"));
    }
}
