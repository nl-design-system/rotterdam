package nl.rotterdam.nl_design_system.docs.wicket.fieldset;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.components.fieldset.RdFieldset;
import org.apache.wicket.model.StringResourceModel;

public class FieldsetExamplesPanel extends ExamplesPanel {
    public FieldsetExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdFieldset.class;
    }

    @ComponentExample
    private static RdFieldset exampleFieldset() {
        return new RdFieldset("fieldset", new StringResourceModel("TheCaption"));
    }

    @ComponentExample
    private static RdFieldset exampleFieldsetDisabled() {
        var component = new RdFieldset("fieldsetDisabled", new StringResourceModel("TheCaption"));
        component.setEnabled(false);
        return component;
    }

    @ComponentExample
    private static RdFieldset exampleFieldsetInvalid() {
        var component = new RdFieldset("fieldsetInvalid", new StringResourceModel("TheCaption"));
        component.setIsInvalid(true);
        return component;
    }

    @ComponentExample
    private static RdFieldset exampleFieldsetSection() {
        var component = new RdFieldset("fieldsetSection", new StringResourceModel("TheCaption"));
        component.setIsSection(true);
        return component;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleFieldset(), exampleFieldsetDisabled(), exampleFieldsetInvalid(), exampleFieldsetSection());
    }
}
