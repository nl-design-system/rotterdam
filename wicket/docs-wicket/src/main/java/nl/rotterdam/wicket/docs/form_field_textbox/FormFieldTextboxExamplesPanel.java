package nl.rotterdam.wicket.docs.form_field_textbox;

import nl.rotterdam.design_system.wicket.components.form_field_textbox.NlFormFieldTextbox;
import nl.rotterdam.design_system.wicket.components.models.DefaultModels;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class FormFieldTextboxExamplesPanel extends Panel {

    public FormFieldTextboxExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleFormFieldTextbox() {
        return new NlFormFieldTextbox<>(
            "nlFormFieldTextbox",
            Model.of("Koen"),
            Model.of("Voornaam"),
            Model.of("Vul je voornaam in.")
        );
    }

    @ComponentExample
    private static Component exampleFormFieldTextboxRequired() {
        return new NlFormFieldTextbox<>(
            "nlFormFieldTextboxRequired",
            DefaultModels.EMPTY_STRING_MODEL,
            Model.of("Email")
        )
        .setInputType("email")
        .setRequired(true);
    }

    @ComponentExample
    private static Component exampleFormFieldTextboxDisabled() {
        return new NlFormFieldTextbox<>(
            "nlFormFieldTextboxDisabled",
            Model.of("Hello world!"),
            Model.of("I agree"),
            Model.of("Description")
        )
            .setEnabled(false);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleFormFieldTextbox());
        add(exampleFormFieldTextboxRequired());
        add(exampleFormFieldTextboxDisabled());
    }
}
