package nl.rotterdam.nl_design_system.docs.wicket.checkbox_group;

import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.wicket.components.checkbox.RdCheckboxBehavior;
import nl.rotterdam.nl_design_system.wicket.components.checkbox_group.RdCheckboxGroup;
import nl.rotterdam.nl_design_system.wicket.components.form_field_label.RdFormFieldLabelBehavior;
import org.apache.wicket.ajax.form.AjaxFormChoiceComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
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

import static nl.rotterdam.nl_design_system.wicket.components.form_field_label.RdFormFieldLabelCheckableInputType.CHECKBOX;

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

        IModel<Collection<ContactOption>> selectedModel = Model.of(List.of(ContactOption.PHONE));

        RdCheckboxGroup<ContactOption> component = new RdCheckboxGroup<>(
            "checkboxGroup",
            selectedModel,
            new StringResourceModel("ContactOptionCaption"));

        component.getCheckGroup()
            .setOutputMarkupId(true)
            .add(AjaxFormChoiceComponentUpdatingBehavior
                .onUpdateChoice(target -> target.add(component.getCheckGroup()))
            );

        component
            .add(
                new WebMarkupContainer("checkPhone")
                    .add(new Check<>("check", Model.of(ContactOption.PHONE)).add(RdCheckboxBehavior.INSTANCE))
                    .add(new RdFormFieldLabelBehavior(CHECKBOX, selectedModel.map(selected -> selected.contains(ContactOption.PHONE)))),

                new WebMarkupContainer("checkEmail")
                    .add(new Check<>("check", Model.of(ContactOption.EMAIL)).add(RdCheckboxBehavior.INSTANCE))
                    .add(new RdFormFieldLabelBehavior(CHECKBOX, selectedModel.map(selected -> selected.contains(ContactOption.EMAIL)))),

                new WebMarkupContainer("checkWhatsapp")
                    .add(new Check<>("check", Model.of(ContactOption.WHATSAPP)).add(RdCheckboxBehavior.INSTANCE))
                    .add(new RdFormFieldLabelBehavior(CHECKBOX, selectedModel.map(selected -> selected.contains(ContactOption.WHATSAPP)))),

                new WebMarkupContainer("checkTelegram")
                    .add(new Check<>("check", Model.of(ContactOption.TELEGRAM)).add(RdCheckboxBehavior.INSTANCE))
                    .add(new RdFormFieldLabelBehavior(CHECKBOX, selectedModel.map(selected -> selected.contains(ContactOption.TELEGRAM))))
            );

        return component;
    }

    @ComponentExample
    public static RdCheckboxGroup<DayOfWeek> checkboxGroupSelectDays() {
        IModel<Collection<DayOfWeek>> selectedItems = Model.of(List.of(DayOfWeek.MONDAY, DayOfWeek.THURSDAY));

        return new DayOfWeekCheckboxGroup("checkboxGroupSelectDays", selectedItems, new StringResourceModel("AvailableDaysOptionCaption"));
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

    private static class DayOfWeekCheckboxGroup extends RdCheckboxGroup<DayOfWeek> {

        private final IModel<Collection<DayOfWeek>> selectedItems;

        private DayOfWeekCheckboxGroup(String id, IModel<Collection<DayOfWeek>> selectedItems, StringResourceModel labelModel) {
            super(id, selectedItems, labelModel);
            this.selectedItems = selectedItems;
        }

        @Override
        protected void onInitialize() {
            super.onInitialize();

            getCheckGroup()
                .setOutputMarkupId(true)
                .add(AjaxFormChoiceComponentUpdatingBehavior
                    .onUpdateChoice(target -> target.add(getCheckGroup()))
                );

            add(new ListView<>("day", Arrays.asList(DayOfWeek.values())) {
                {
                    setReuseItems(true);
                }

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

                    item.add(new RdFormFieldLabelBehavior(CHECKBOX,
                        selectedItems.map(selected -> selected.contains(item.getModelObject()))));
                }
            });

        }
    }
}
