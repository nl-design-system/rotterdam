package nl.rotterdam.nl_design_system.docs.wicket.form_field_text_input;

import nl.rotterdam.nl_design_system.wicket.components.form_field_text_input.RdFormFieldTextInput;
import nl.rotterdam.nl_design_system.wicket.components.models.DefaultModels;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.model.Model;

public class FormFieldTextInputExamplesPanel extends ExamplesPanel {
    public FormFieldTextInputExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdFormFieldTextInput.class;
    }

    @ComponentExample
    private static RdFormFieldTextInput<String> exampleFormFieldTextInput() {
        return new RdFormFieldTextInput<>(
            "formFieldTextInput",
            Model.of("Koen"),
            Model.of("Voornaam"),
            Model.of("Vul je voornaam in.")
        );
    }

    @ComponentExample
    private static RdFormFieldTextInput<String> exampleFormFieldTextInputRequired() {
        return new RdFormFieldTextInput<>(
            "formFieldTextInputRequired",
            DefaultModels.EMPTY_STRING_MODEL,
            Model.of("Email")
        )
            .setInputType("email")
            .setRequired(true);
    }

    @ComponentExample
    private static RdFormFieldTextInput<String> exampleFormFieldTextInputDisabled() {
        RdFormFieldTextInput<String> component = new RdFormFieldTextInput<>(
            "formFieldTextInputDisabled",
            Model.of("Willem-Alexander van Oranje-Nassau"),
            Model.of("Naam"),
            Model.of("Je volledig naam.")
        );
        component.setEnabled(false);
        return component;
    }

    @ComponentExample
    private static RdFormFieldTextInput<String> exampleFormFieldTextInputWithAutocompleteConfigured() {
        return new RdFormFieldTextInput<>(
            "formFieldTextInputWithAutocompleteConfigured",
            Model.of(""),
            Model.of("Voornaam"),
            Model.of("Vul je voornaam in.")
        ).withTextInput((input, formField) ->
            input.add(
                AttributeModifier.replace("autocomplete", "given-name"),
                AttributeModifier.replace("spellcheck", "false")
            )
        );
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(
            exampleFormFieldTextInput(),
            exampleFormFieldTextInputRequired(),
            exampleFormFieldTextInputDisabled(),
            exampleFormFieldTextInputWithAutocompleteConfigured()
        );
    }
}
