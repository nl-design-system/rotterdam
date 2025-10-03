package nl.rotterdam.wicket.docs.form_field_text_input;

import nl.rotterdam.design_system.wicket.components.form_field_text_input.NlFormFieldTextInput;
import nl.rotterdam.design_system.wicket.components.models.DefaultModels;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class FormFieldTextInputExamplesPanel extends Panel {

    public FormFieldTextInputExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleFormFieldTextInput() {
        return new NlFormFieldTextInput<>(
            "formFieldTextInput",
            Model.of("Koen"),
            Model.of("Voornaam"),
            Model.of("Vul je voornaam in.")
        );
    }

    @ComponentExample
    private static Component exampleFormFieldTextInputRequired() {
        return new NlFormFieldTextInput<>(
            "formFieldTextInputRequired",
            DefaultModels.EMPTY_STRING_MODEL,
            Model.of("Email")
        )
        .setInputType("email")
        .setRequired(true);
    }

    @ComponentExample
    private static Component exampleFormFieldTextInputDisabled() {
        return new NlFormFieldTextInput<>(
            "formFieldTextInputDisabled",
            Model.of("Hello world!"),
            Model.of("I agree"),
            Model.of("Description")
        )
            .setEnabled(false);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleFormFieldTextInput());
        add(exampleFormFieldTextInputRequired());
        add(exampleFormFieldTextInputDisabled());
    }
}
