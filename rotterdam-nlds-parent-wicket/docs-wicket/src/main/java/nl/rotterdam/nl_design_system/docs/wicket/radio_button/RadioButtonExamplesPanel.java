package nl.rotterdam.nl_design_system.docs.wicket.radio_button;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.components.radio_button.RdRadioButton;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.model.Model;

public class RadioButtonExamplesPanel extends ExamplesPanel {
    public RadioButtonExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdRadioButton.class;
    }

    @ComponentExample
    private static RadioGroup<String> exampleUnchecked() {
        var group = new RadioGroup<>("unchecked", Model.of("not option1"));
        group.add(new RdRadioButton<>("radio", Model.of("option1")));
        return group;
    }

    @ComponentExample
    private static RadioGroup<String> exampleChecked() {
        var group = new RadioGroup<>("checked", Model.of("option1"));
        group.add(new RdRadioButton<>("radio", Model.of("option1")));
        return group;
    }

    @ComponentExample
    private static RadioGroup<String> exampleInvalid() {
        var group = new RadioGroup<>("invalid", Model.of("not option1"));
        var radioButton = new RdRadioButton<>("radio", Model.of("option1"));
        radioButton.error("some error");
        group.add(radioButton);
        return group;
    }

    @ComponentExample
    private static RadioGroup<String> exampleDisabled() {
        var group = new RadioGroup<>("disabled", Model.of("not option1"));
        group.add(new RdRadioButton<>("radio", Model.of("option1")).setEnabled(false));
        return group;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        
        add(exampleUnchecked(), exampleChecked(), exampleInvalid(), exampleDisabled());
    }
}
