package nl.rotterdam.nl_design_system.wicket.components.form_field_textarea;

import nl.rotterdam.nl_design_system.wicket.components.textarea.RdTextArea;
import org.jspecify.annotations.Nullable;

/**
 * Implement (with lambda) to execute logic to initialize the textArea or formField.
 * @param <T> the model type
 */
@FunctionalInterface
public interface WithTextAreaCallback<T extends @Nullable Object> {

    /**
     * Initialize the textArea and/or form field. For example add additional validators or behaviors.
     * @param textArea to initialize
     * @param formField to initialize
     */
    void doWithTextArea(RdTextArea<T> textArea, RdFormFieldTextArea<T> formField);
}
