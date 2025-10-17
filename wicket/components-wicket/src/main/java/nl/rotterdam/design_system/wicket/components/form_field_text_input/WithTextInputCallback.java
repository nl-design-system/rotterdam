package nl.rotterdam.design_system.wicket.components.form_field_text_input;

import nl.rotterdam.design_system.wicket.components.text_input.RdTextInput;

@FunctionalInterface
public interface WithTextInputCallback<T> {
    void doWithTextInput(RdTextInput<T> textInput, RdFormFieldTextInput<T> formField);
}
