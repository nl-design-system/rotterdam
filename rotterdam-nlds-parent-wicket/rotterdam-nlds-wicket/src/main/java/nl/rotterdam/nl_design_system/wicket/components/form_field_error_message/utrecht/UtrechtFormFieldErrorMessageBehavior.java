package nl.rotterdam.nl_design_system.wicket.components.form_field_error_message.utrecht;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.component_visibility.HideWhenModelIsNullBehavior;
import org.apache.wicket.Component;

public class UtrechtFormFieldErrorMessageBehavior extends TagNameClassComponentBehavior<Component> {

    public static final UtrechtFormFieldErrorMessageBehavior INSTANCE = new UtrechtFormFieldErrorMessageBehavior();

    @Override
    public void bind(Component component) {
        component.add(HideWhenModelIsNullBehavior.INSTANCE);
    }

    private UtrechtFormFieldErrorMessageBehavior() {
        super("div", UtrechtFormFieldErrorCss.DEFAULT);
        addHeaderItem(
            cssReferenceHeaderItem(
                UtrechtFormFieldErrorMessageBehavior.class,
                "@utrecht/form-field-error-message-css/dist/index.css"
            )
        );
    }
}
