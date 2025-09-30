package nl.rotterdam.wicket.docs.checkbox;

import nl.rotterdam.design_system.wicket.components.checkbox.NlCheckbox;
import nl.rotterdam.wicket.docs.ComponentExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class CheckboxExamplesPanel extends Panel {

    public CheckboxExamplesPanel(String id) {
        super(id);
    }

    @ComponentExample
    private static Component exampleCheckbox() {
        return new NlCheckbox(
            "checkbox",
            Model.of(false)
        );
    }

    @ComponentExample
    private static Component exampleCheckboxInvalid() {
        CheckBox component = new NlCheckbox(
            "checkboxInvalid",
            Model.of(false)
        );
        component.error("Melding, wordt bij standalone Checkbox niet getoond, wel is het veld rood");
        return component;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(
            exampleCheckbox(),
            exampleCheckboxInvalid()
        );
    }
}
