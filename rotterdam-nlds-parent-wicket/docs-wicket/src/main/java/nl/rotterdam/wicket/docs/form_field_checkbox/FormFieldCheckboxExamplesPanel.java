package nl.rotterdam.wicket.docs.form_field_checkbox;

import nl.rotterdam.nl_design_system.wicket.components.form_field_checkbox.RdFormFieldCheckbox;
import nl.rotterdam.wicket.docs.ComponentExample;
import nl.rotterdam.wicket.docs.ExamplesPanel;
import org.apache.wicket.model.Model;

public class FormFieldCheckboxExamplesPanel extends ExamplesPanel {
    public FormFieldCheckboxExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdFormFieldCheckbox.class;
    }

    @ComponentExample
    private static RdFormFieldCheckbox exampleFormFieldCheckbox() {
        return new RdFormFieldCheckbox(
            "nlFormFieldCheckbox",
            Model.of(false),
            Model.of("Ik ga akkoord met de algemene voorwaarden"),
            Model.of()
        );
    }

    @ComponentExample
    private static RdFormFieldCheckbox exampleFormFieldCheckboxInvalid() {
        RdFormFieldCheckbox component = new RdFormFieldCheckbox(
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

        add(exampleFormFieldCheckbox(), exampleFormFieldCheckboxInvalid());
    }
}
