package nl.rotterdam.nl_design_system.wicket.components.form_field;

import org.apache.wicket.markup.html.form.FormComponent;
import org.jspecify.annotations.Nullable;

/**
 * <p>
 * Implement (with lambda) to execute logic to modify the form component and/or Form Field.
 * </p>
 * 
 * @param <T> the model object type.
 */
@FunctionalInterface
public interface WithInputConsumer<T extends @Nullable Object> {

    /**
     * <p>
     * Modify the input and/or Form Field. For example: add additional validators or behaviors.
     * </p>
     * 
     * @param input the input in the Form Field.
     * @param formField the Form Field.
     */
    void doWithInput(FormComponent<T> input, RdFormFieldBorder<T> formField);
}
