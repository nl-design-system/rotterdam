package nl.rotterdam.nl_design_system.wicket.components.form_field;

import org.apache.wicket.markup.html.form.LabeledWebMarkupContainer;
import org.jspecify.annotations.Nullable;

/**
 * <p>
 * Implement (with lambda) to execute logic to modify the form component and/or Form Field.
 * </p>
 * 
 * @param <T> the model object type.
 */
@FunctionalInterface
public interface WithInputConsumer<T extends @Nullable Object, C extends LabeledWebMarkupContainer> {

    /**
     * <p>
     * Modify the input and/or Form Field. For example: add additional validators or behaviors.
     * </p>
     * 
     * @param input the input in the Form Field.
     * @param formField the Form Field.
     */
    void doWithInput(C input, RdFormFieldBorder<T, C> formField);
}
