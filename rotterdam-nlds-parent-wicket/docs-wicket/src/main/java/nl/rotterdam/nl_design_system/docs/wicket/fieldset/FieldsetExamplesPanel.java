package nl.rotterdam.nl_design_system.docs.wicket.fieldset;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.components.fieldset.RdFieldset;
import org.apache.wicket.model.StringResourceModel;
import org.jspecify.annotations.Nullable;

import static nl.rotterdam.nl_design_system.wicket.components.models.DefaultModels.NULL_STRING_MODEL;

public class FieldsetExamplesPanel extends ExamplesPanel {
    public FieldsetExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdFieldset.class;
    }

    @ComponentExample
    private static RdFieldset<@Nullable String> exampleFieldset() {
        return new RdFieldset<@Nullable String>("fieldset", NULL_STRING_MODEL, new StringResourceModel("TheCaption"));
    }

    @ComponentExample
    private static RdFieldset<@Nullable String> exampleFieldsetDisabled() {
        var component = new RdFieldset<@Nullable String>("fieldsetDisabled", NULL_STRING_MODEL, new StringResourceModel("TheCaption"));
        component.setEnabled(false);
        return component;
    }

    @ComponentExample
    private static RdFieldset<@Nullable String> exampleFieldsetInvalid() {
        var component = new RdFieldset<@Nullable String>("fieldsetInvalid", NULL_STRING_MODEL, new StringResourceModel("TheCaption"));
        component.setIsInvalid(true);
        return component;
    }

    @ComponentExample
    private static RdFieldset<@Nullable String> exampleFieldsetSection() {
        var component = new RdFieldset<@Nullable String>("fieldsetSection", NULL_STRING_MODEL, new StringResourceModel("TheCaption"));
        component.setIsSection(true);
        return component;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleFieldset(), exampleFieldsetDisabled(), exampleFieldsetInvalid(), exampleFieldsetSection());
    }
}
