package nl.rotterdam.nl_design_system.docs.wicket.checkbox_group;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.components.checkbox.RdCheckboxBehavior;
import nl.rotterdam.nl_design_system.wicket.components.checkbox_group.RdCheckboxGroup;
import nl.rotterdam.nl_design_system.wicket.components.form_field_label.RdFormFieldLabelBehavior;
import nl.rotterdam.nl_design_system.wicket.components.form_field_label.RdFormFieldLabelCheckableInputType;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Check;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
    public static RdCheckboxGroup<DayOfWeek> checkboxGroupSelectDays() {
        IModel<Collection<DayOfWeek>> selectedItems = Model.of(List.of(DayOfWeek.MONDAY, DayOfWeek.THURSDAY));
        RdCheckboxGroup<DayOfWeek> component = new RdCheckboxGroup<>(
            "checkboxGroupSelectDays",
            selectedItems,
            new StringResourceModel("ContactOptionCaption"));

        component.add(new ListView<>("day", Arrays.asList(DayOfWeek.values())) {
            @Override
            protected void populateItem(ListItem<DayOfWeek> item) {

                IModel<String> labelModel = item.
                    getModel().map(day -> day.getDisplayName(TextStyle.FULL, getSession().getLocale()));

                item.add(
                    new Check<>("checkbox", item.getModel())
                        .setLabel(labelModel)
                        .add(RdCheckboxBehavior.INSTANCE),

                    new Label("label", labelModel)
                );

                item.add(new RdFormFieldLabelBehavior(RdFormFieldLabelCheckableInputType.CHECKBOX,
                    selectedItems.map(selected -> selected.contains(item.getModelObject()))));
            }
        });

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
        
        add(
            exampleCheckboxGroup(),
            checkboxGroupSelectDays(),
            exampleCheckboxGroupWithDescription(),
            exampleCheckboxGroupDisabled(),
            exampleCheckboxGroupInvalid()
        );
    }
}
