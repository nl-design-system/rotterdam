package nl.rotterdam.nl_design_system.docs.wicket.radio_group;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.components.radio_group.RdRadioGroup;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;

public class RadioGroupExamplesPanel extends ExamplesPanel {
    public RadioGroupExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdRadioGroup.class;
    }

    @ComponentExample
    private static RdRadioGroup<String> exampleRadioGroup() {
        return new RdRadioGroup<>(
            "radioGroup",
            Model.of("selectedOption"),
            new StringResourceModel("TheCaption"));
    }

    @ComponentExample
    private static RdRadioGroup<String> exampleRadioGroupWithDescription() {
        return new RdRadioGroup<>(
            "radioGroupWithDescription",
            Model.of("selectedOption"),
            new StringResourceModel("TheCaption"),
            new StringResourceModel("TheDescription"));
    }

    @ComponentExample
    private static RdRadioGroup<String> exampleRadioGroupDisabled() {
        var component = new RdRadioGroup<>(
            "radioGroupDisabled",
            Model.of("selectedOption"),
            new StringResourceModel("TheCaption"));
        component.setEnabled(false);
        return component;
    }

    @ComponentExample
    private static RdRadioGroup<String> exampleRadioGroupInvalid() {
        var component = new RdRadioGroup<>(
            "radioGroupInvalid",
            Model.of("selectedOption"),
            new StringResourceModel("TheCaption"));
        component.getFieldsetComponent().error("Some error");
        return component;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        
        add(exampleRadioGroup(), exampleRadioGroupWithDescription(), exampleRadioGroupDisabled(), exampleRadioGroupInvalid());
    }
}
