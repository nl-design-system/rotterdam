package nl.rotterdam.wicket.docs.form_field_checkbox;

import nl.rotterdam.design_system.wicket.components.form_field_checkbox.NlFormFieldCheckbox;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class FormFieldCheckboxExamplesPanel extends Panel {

    public FormFieldCheckboxExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleFormFieldCheckbox() {
        return new NlFormFieldCheckbox(
            "nlFormFieldCheckbox",
            Model.of(false),
            Model.of("Ik ga akkoord met de algemene voorwaarden"),
            Model.of()
        );
    }

    @ComponentExample
    private static Component exampleFormFieldCheckboxInvalid() {
        NlFormFieldCheckbox component = new NlFormFieldCheckbox(
            "nlFormFieldCheckboxInvalid",
            Model.of(false),
            Model.of("Ik ga akkoord met de algemene voorwaarden"),
            Model.of("U kunt ons echt vertrouwen!")
        );
        component.getControl().error("U moet akkoord gaan met de algemene voorwaarden, anders kunt u niet verder.");
        return component;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(
            exampleFormFieldCheckbox(),
            exampleFormFieldCheckboxInvalid()
        );
    }
}
