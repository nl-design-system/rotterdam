package nl.rotterdam.nl_design_system.wicket.components.form_field_text_input;

import nl.rotterdam.nl_design_system.wicket.components.text_input.RdTextInput;

/**
 * Implement (with lambda) to execute logic to initialize the texInput or formField.
 * @param <T> the model type
 */
@FunctionalInterface
public interface WithTextInputCallback<T> {

    /**
     * Initialize the textInput and/or form field. For example add additional validators or behaviors.
     * @param textInput to initialize
     * @param formField to initialize
     */
    void doWithTextInput(RdTextInput<T> textInput, RdFormFieldTextInput<T> formField);
}
