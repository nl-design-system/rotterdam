package nl.rotterdam.nl_design_system.wicket.components.form_field_error_message;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.component_visibility.HideWhenModelIsNullBehavior;
import org.apache.wicket.Component;

public class RdFormFieldErrorMessageBehavior extends TagNameClassComponentBehavior<Component> {

    public static final RdFormFieldErrorMessageBehavior INSTANCE = new RdFormFieldErrorMessageBehavior();

    @Override
    public void bind(Component component) {
        component.add(HideWhenModelIsNullBehavior.INSTANCE);
    }

    private RdFormFieldErrorMessageBehavior() {
        super("div", RdFormFieldErrorCss.DEFAULT);
        addHeaderItem(
            cssReferenceHeaderItem(
                RdFormFieldErrorMessageBehavior.class,
                "@utrecht/form-field-error-message-css/dist/index.css"
            )
        );
    }
}
