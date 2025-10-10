package nl.rotterdam.design_system.wicket.components.form_field.utrecht;

import nl.rotterdam.design_system.wicket.components.component_state.Community;
import nl.rotterdam.design_system.wicket.components.form_field_error_message.utrecht.UtrechtFormFieldErrorMessageBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

/**
 * Intentionally did not rename to NL, kept Utrecht in it. It has public visibility, can be used by library users,
 * and should only be used for Form Fields implemented by {@link Community} Utrecht.
 */
public enum UtrechtFormFieldErrorMessageFactory {
    ;

    public static Component createErrorMessageLabel(String id, Component componentWithFeedback) {
        // TODO a form component can have multiple error messages. Currently only shows the first feedback message.
        //  Is multiple messages desired by first applications?
        // See: https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-form-field--docs#invalid
        IModel<String> model = () -> {
            FeedbackMessage first = componentWithFeedback.getFeedbackMessages().first(FeedbackMessage.ERROR);
            return first != null ? first.getMessage().toString() : null;
        };

        return new Label(id, model)
            .setOutputMarkupId(true)
            .add(UtrechtFormFieldErrorMessageBehavior.INSTANCE);
    }

    public static Component createErrorMessageLabel(String id) {
        return new Label(id)
            .setOutputMarkupId(true)
            .add(UtrechtFormFieldErrorMessageBehavior.INSTANCE);
    }
}
