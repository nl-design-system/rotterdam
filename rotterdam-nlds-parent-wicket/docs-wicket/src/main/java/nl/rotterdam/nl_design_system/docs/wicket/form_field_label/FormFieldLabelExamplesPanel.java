package nl.rotterdam.nl_design_system.docs.wicket.form_field_label;

import nl.rotterdam.nl_design_system.wicket.components.form_label.RdFormLabel;
import nl.rotterdam.nl_design_system.wicket.components.form_label.RdFormLabelBehavior;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import org.apache.wicket.model.Model;

public class FormFieldLabelExamplesPanel extends ExamplesPanel {
    public FormFieldLabelExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdFormLabel.class;
    }

    @ComponentExample
    private static RdFormLabel exampleFormFieldLabel() {
        return new RdFormLabel("formFieldLabel", Model.of("Voornaam"));
    }

    @ComponentExample
    private static RdFormLabel exampleFormFieldLabelCheckbox() {
        return new RdFormLabel(
            "formFieldLabelCheckbox",
            Model.of("Optie 1"),
            RdFormLabelBehavior.INSTANCE_CHECKBOX
        );
    }

    @ComponentExample
    private static RdFormLabel exampleFormFieldLabelRadio() {
        return new RdFormLabel(
            "formFieldLabelRadio",
            Model.of("Optie 1"),
            RdFormLabelBehavior.INSTANCE_RADIO
        );
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleFormFieldLabel(), exampleFormFieldLabelCheckbox(), exampleFormFieldLabelRadio());
    }
}
