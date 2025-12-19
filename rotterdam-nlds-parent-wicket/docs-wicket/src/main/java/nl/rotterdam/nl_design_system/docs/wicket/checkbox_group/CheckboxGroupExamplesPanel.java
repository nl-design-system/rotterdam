package nl.rotterdam.nl_design_system.docs.wicket.checkbox_group;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.components.checkbox.RdCheckboxBehavior;
import nl.rotterdam.nl_design_system.wicket.components.checkbox_group.RdCheckboxGroup;
import org.apache.wicket.markup.html.form.Check;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;

import java.util.Collections;

public class CheckboxGroupExamplesPanel extends ExamplesPanel {
    public CheckboxGroupExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdCheckboxGroup.class;
    }

    @ComponentExample
    private static RdCheckboxGroup<? extends Enum<?>> exampleCheckboxGroup() {
        enum ContactOption {
            PHONE,
            EMAIL,
            WHATSAPP,
            TELEGRAM
        }

        RdCheckboxGroup<ContactOption> component = new RdCheckboxGroup<>(
            "checkboxGroup",
            Model.of(Collections.emptyList()),
            new StringResourceModel("ContactOptionCaption"));

        component
            .add(
                new Check<>("checkPhone", Model.of(ContactOption.PHONE)).add(RdCheckboxBehavior.INSTANCE),
                new Check<>("checkEmail", Model.of(ContactOption.EMAIL)).add(RdCheckboxBehavior.INSTANCE),
                new Check<>("checkWhatsapp", Model.of(ContactOption.WHATSAPP)).add(RdCheckboxBehavior.INSTANCE),
                new Check<>("checkTelegram", Model.of(ContactOption.TELEGRAM)).add(RdCheckboxBehavior.INSTANCE)
            );

        return component;
    }



    @ComponentExample
    private static RdCheckboxGroup<String> exampleCheckboxGroupWithDescription() {
        return new RdCheckboxGroup<>(
            "checkboxGroupWithDescription",
            Model.of(Collections.emptyList()),
            new StringResourceModel("TheCaption"),
            new StringResourceModel("TheDescription"));
    }

    @ComponentExample
    private static RdCheckboxGroup<String> exampleCheckboxGroupDisabled() {
        var component = new RdCheckboxGroup<>(
            "checkboxGroupDisabled",
            Model.of(Collections.<String>emptyList()),
            new StringResourceModel("TheCaption"));
        component.setEnabled(false);
        return component;
    }

    @ComponentExample
    private static RdCheckboxGroup<String> exampleCheckboxGroupInvalid() {
        var component = new RdCheckboxGroup<>(
            "checkboxGroupInvalid",
            Model.of(Collections.<String>emptyList()),
            new StringResourceModel("TheCaption"));
        component.getFieldsetComponent().error("Some error");
        return component;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        
        add(exampleCheckboxGroup(), exampleCheckboxGroupWithDescription(), exampleCheckboxGroupDisabled(), exampleCheckboxGroupInvalid());
    }
}
