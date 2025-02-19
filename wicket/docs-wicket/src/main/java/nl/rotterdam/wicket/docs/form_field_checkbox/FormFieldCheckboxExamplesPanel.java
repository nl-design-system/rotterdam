package nl.rotterdam.wicket.docs.form_field_checkbox;

import nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht.UtrechtFormFieldCheckbox;
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
        return new UtrechtFormFieldCheckbox(
            "utrechtFormFieldCheckbox",
            Model.of(false),
            Model.of("I agree"),
            Model.of("Description"),
            Model.of("error")
        );
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleFormFieldCheckbox());
    }
}
