package nl.rotterdam.nl_design_system.wicket.components.form_field;

import nl.rotterdam.nl_design_system.wicket.components.component_state.Community;
import nl.rotterdam.nl_design_system.wicket.components.form_field_error_message.RdFormFieldErrorMessageBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

/**
 * It has public visibility, can be used by library users, and should only be used for Form Fields implemented by
 * {@link Community} Utrecht.
 */
public enum RdFormFieldErrorMessageFactory {
    ;

    /**
     * Creates error message label
     * @param id the Wicket ID
     * @param componentWithFeedback component which can have feedback messages
     * @return error message label, properly styled according to NL Design System error message style.
     */
    public static Component createErrorMessageLabel(String id, Component componentWithFeedback) {
        // TODO a form component can have multiple error messages. Currently only shows the first feedback message.
        //  Is multiple messages desired by first applications?
        // See: https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-form-field--docs#invalid
        IModel<String> model = () -> {
            FeedbackMessage first = componentWithFeedback.getFeedbackMessages().first(FeedbackMessage.ERROR);
            return first != null ? first.getMessage().toString() : null;
        };

        return new Label(id, model).setOutputMarkupId(true).add(RdFormFieldErrorMessageBehavior.INSTANCE);
    }

    /**
     * Create error message label
     * @param id the Wicket ID
     * @return error message label, properly styled according to NL Design System error message style.
     */
    public static Component createErrorMessageLabel(String id) {
        return new Label(id).setOutputMarkupId(true).add(RdFormFieldErrorMessageBehavior.INSTANCE);
    }
}
