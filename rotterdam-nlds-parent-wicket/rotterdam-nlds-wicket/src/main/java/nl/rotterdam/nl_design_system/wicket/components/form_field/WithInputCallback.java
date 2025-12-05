package nl.rotterdam.nl_design_system.wicket.components.form_field;

import org.apache.wicket.markup.html.form.FormComponent;
import org.jspecify.annotations.Nullable;

/**
 * Implement (with lambda) to execute logic to initialize the texInput or formField.
 * @param <T> the model type
 */
@FunctionalInterface
public interface WithInputCallback<T extends @Nullable Object> {

    /**
     * Initialize the input and/or form field. For example add additional validators or behaviors.
     * @param input to initialize
     * @param formField to initialize
     */
    void doWithInput(FormComponent<T> input, RdFormFieldBorder<T> formField);
}
