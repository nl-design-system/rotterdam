package nl.rotterdam.nl_design_system.docs.wicket.form_fieldset;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.components.form_fieldset.RdFormFieldset;
import org.apache.wicket.model.StringResourceModel;

public class FormFieldsetExamplesPanel extends ExamplesPanel {
    public FormFieldsetExamplesPanel(String id) {
        super(id);
    }

    public Class<?> getImplementationClass() {
        return RdFormFieldset.class;
    }

    @ComponentExample
    private static RdFormFieldset exampleFormFieldset() {
        return new RdFormFieldset("formFieldset", new StringResourceModel("TheCaption"));
    }

    @ComponentExample
    private static RdFormFieldset exampleFormFieldsetDisabled() {
        var component = new RdFormFieldset("formFieldsetDisabled", new StringResourceModel("TheCaption"));
        component.setEnabled(false);
        return component;
    }

    @ComponentExample
    private static RdFormFieldset exampleFormFieldsetInvalid() {
        var component = new RdFormFieldset("formFieldsetInvalid", new StringResourceModel("TheCaption"));
        component.setIsInvalid(true);
        return component;
    }

    @ComponentExample
    private static RdFormFieldset exampleFormFieldsetSection() {
        var component = new RdFormFieldset("formFieldsetSection", new StringResourceModel("TheCaption"));
        component.setIsSection(true);
        return component;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleFormFieldset(), exampleFormFieldsetDisabled(), exampleFormFieldsetInvalid(), exampleFormFieldsetSection());
    }
}
