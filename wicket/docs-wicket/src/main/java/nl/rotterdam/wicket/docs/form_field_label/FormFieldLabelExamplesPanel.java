package nl.rotterdam.wicket.docs.form_field_label;

import nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabel;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class FormFieldLabelExamplesPanel extends Panel {

    public FormFieldLabelExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleFormFieldLabel() {
        return new UtrechtFormLabel("utrechtFormFieldLabel", Model.of("Voornaam"));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleFormFieldLabel());
    }
}
