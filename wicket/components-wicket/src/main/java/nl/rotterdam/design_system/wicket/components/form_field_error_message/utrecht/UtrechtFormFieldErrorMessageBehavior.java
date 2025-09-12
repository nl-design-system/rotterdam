package nl.rotterdam.design_system.wicket.components.form_field_error_message.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtFormFieldErrorMessageBehavior extends TagNameClassComponentBehavior {

    public static final UtrechtFormFieldErrorMessageBehavior INSTANCE = new UtrechtFormFieldErrorMessageBehavior();

    private UtrechtFormFieldErrorMessageBehavior() {
        super("div", "utrecht-form-field-error-message utrecht-form-field__error-message");

        addHeaderItem(cssReferenceHeaderItem(UtrechtFormFieldErrorMessageBehavior.class,
            "@utrecht/form-field-error-message-css/dist/index.css"));

    }

}
