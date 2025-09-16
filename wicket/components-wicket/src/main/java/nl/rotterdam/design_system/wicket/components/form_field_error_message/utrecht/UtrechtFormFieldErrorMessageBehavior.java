package nl.rotterdam.design_system.wicket.components.form_field_error_message.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.design_system.wicket.components.component_visibility.HideWhenModelIsNullBehavior;
import org.apache.wicket.Component;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtFormFieldErrorMessageBehavior extends TagNameClassComponentBehavior {

    public static final UtrechtFormFieldErrorMessageBehavior INSTANCE = new UtrechtFormFieldErrorMessageBehavior();


    @Override
    public void bind(Component component) {
        component.add(HideWhenModelIsNullBehavior.INSTANCE);
    }

    private UtrechtFormFieldErrorMessageBehavior() {
        super("div", "utrecht-form-field-error-message");

        addHeaderItem(cssReferenceHeaderItem(UtrechtFormFieldErrorMessageBehavior.class,
            "@utrecht/form-field-error-message-css/dist/index.css"));

    }

}
