package nl.rotterdam.nl_design_system.docs.wicket.checkbox;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.components.checkbox.RdCheckbox;
import org.apache.wicket.model.Model;

public class CheckboxExamplesPanel extends ExamplesPanel {
    public CheckboxExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdCheckbox.class;
    }

    @ComponentExample
    private static RdCheckbox exampleCheckbox() {
        return new RdCheckbox("checkbox", Model.of(false));
    }

    @ComponentExample
    private static RdCheckbox exampleCheckboxInvalid() {
        RdCheckbox component = new RdCheckbox("checkboxInvalid", Model.of(false));
        component.error("Melding, wordt bij standalone Checkbox niet getoond, wel is het veld rood");
        return component;
    }

    @ComponentExample
    private static RdCheckbox exampleCheckboxDisabled() {
        RdCheckbox component = new RdCheckbox("checkboxDisabled", Model.of(false));
        component.setEnabled(false);
        return component;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleCheckbox(), exampleCheckboxInvalid(), exampleCheckboxDisabled());
    }
}
