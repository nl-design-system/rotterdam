package nl.rotterdam.wicket.docs.form_field_label;

import nl.rotterdam.nl_design_system.wicket.components.form_label.utrecht.UtrechtFormLabel;
import nl.rotterdam.nl_design_system.wicket.components.form_label.utrecht.UtrechtFormLabelBehavior;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class FormFieldLabelExamplesPanel extends Panel {

    public FormFieldLabelExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static UtrechtFormLabel exampleFormFieldLabel() {
        return new UtrechtFormLabel("formFieldLabel", Model.of("Voornaam"));
    }

    @ComponentExample
    private static UtrechtFormLabel exampleFormFieldLabelCheckbox() {
        return new UtrechtFormLabel(
            "formFieldLabelCheckbox",
            Model.of("Optie 1"),
            UtrechtFormLabelBehavior.INSTANCE_CHECKBOX
        );
    }

    @ComponentExample
    private static UtrechtFormLabel exampleFormFieldLabelRadio() {
        return new UtrechtFormLabel(
            "formFieldLabelRadio",
            Model.of("Optie 1"),
            UtrechtFormLabelBehavior.INSTANCE_RADIO
        );
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleFormFieldLabel(), exampleFormFieldLabelCheckbox(), exampleFormFieldLabelRadio());
    }
}
