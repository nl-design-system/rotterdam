package nl.rotterdam.nl_design_system.wicket.components.form_field_error_message;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.component_visibility.HideWhenModelIsNullBehavior;
import org.apache.wicket.Component;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

/**
 * Apply error message behavior to an HTML markup element.
 */
public class RdFormFieldErrorMessageBehavior extends TagNameClassComponentBehavior<Component> {

    /**
     * Singleton instance.
     */
    public static final RdFormFieldErrorMessageBehavior INSTANCE = new RdFormFieldErrorMessageBehavior();

    @Override
    public void bind(Component component) {
        component.add(HideWhenModelIsNullBehavior.INSTANCE);
    }

    private RdFormFieldErrorMessageBehavior() {
        super("div", RdFormFieldErrorCss.BASE);
        addHeaderItem(
            cssReferenceHeaderItem(
                RdFormFieldErrorMessageBehavior.class,
                "@utrecht/form-field-error-message-css/dist/index.min.css"
            )
        );
    }
}
