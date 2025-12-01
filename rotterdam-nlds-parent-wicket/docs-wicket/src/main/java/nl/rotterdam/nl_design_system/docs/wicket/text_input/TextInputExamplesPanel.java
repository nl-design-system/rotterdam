package nl.rotterdam.nl_design_system.docs.wicket.text_input;

import nl.rotterdam.nl_design_system.wicket.components.text_input.RdTextInput;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import org.apache.wicket.model.Model;

public class TextInputExamplesPanel extends ExamplesPanel {
    public TextInputExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdTextInput.class;
    }

    @ComponentExample
    private static RdTextInput<String> exampleTextInput() {
        return new RdTextInput<>("textInput", Model.of(""));
    }

    @ComponentExample
    private static RdTextInput<String> exampleTextInputRequired() {
        RdTextInput<String> component = new RdTextInput<>("textInputRequired", Model.of(""));
        component.setRequired(true);
        return component;
    }

    @ComponentExample
    private static RdTextInput<String> exampleTextInputDisabled() {
        RdTextInput<String> component = new RdTextInput<>("textInputDisabled", Model.of(""));
        component.setEnabled(false);
        return component;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleTextInput(), exampleTextInputRequired(), exampleTextInputDisabled());
    }
}
