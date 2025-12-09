package nl.rotterdam.nl_design_system.wicket.components.form_field_text_input;

import nl.rotterdam.nl_design_system.wicket.components.text_input.RdTextInput;
import org.jspecify.annotations.Nullable;

/**
 * <p>
 * Implement (with lambda) to execute logic to modify the Text Input and/or Form Field.
 * </p>
 *
 * @param <T> the model object type.
 */
@FunctionalInterface
public interface WithTextInputConsumer<T extends @Nullable Object> {

    /**
     * <p>
     * Modify the input and/or Form Field. For example: add additional validators or behaviors.
     * </p>
     *
     * @param textInput the Text Input in the Form Field.
     * @param formField the Form Field.
     */
    void doWithTextInput(RdTextInput<T> textInput, RdFormFieldTextInput<T> formField);
}
