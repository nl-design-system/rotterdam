package nl.rotterdam.wicket.docs.form_field_textbox;

import nl.rotterdam.design_system.wicket.components.form_field_textbox.utrecht.UtrechtFormFieldTextbox;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class UtrechtFormFieldTextboxExamplesPanel extends Panel {

    public UtrechtFormFieldTextboxExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleFormFieldTextbox() {
        return new UtrechtFormFieldTextbox<>(
            "utrechtFormFieldTextbox",
            Model.of("Hello world!"),
            Model.of("I agree"),
            Model.of("Description")
        );
    }

    @ComponentExample
    private static Component exampleFormFieldTextboxRequired() {
        return new UtrechtFormFieldTextbox<>(
            "utrechtFormFieldTextboxRequired",
            Model.of("Hello world!"),
            Model.of("I agree"),
            Model.of("Description")
        )
            .setRequired(true);
    }

    @ComponentExample
    private static Component exampleFormFieldTextboxDisabled() {
        return new UtrechtFormFieldTextbox<>(
            "utrechtFormFieldTextboxDisabled",
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
