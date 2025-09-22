package nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht;

import css.HTMLUtil;
import nl.rotterdam.design_system.wicket.components.checkbox.utrecht.UtrechtCheckbox;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormField;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldBehavior;
import nl.rotterdam.design_system.wicket.components.form_field_description.utrecht.UtrechtFormFieldDescriptionBehavior;
import nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

import static java.util.Objects.requireNonNull;
import static nl.rotterdam.design_system.wicket.components.attribute_appender.AttributeAppenders.appendCssClassBehavior;
import static nl.rotterdam.design_system.wicket.components.component_tag.ComponentTagUtils.appendCssClassesTo;
import static nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldCssClassNames.*;
import static nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldCssClassNames.FORM_FIELD_NESTED_BLOCK_INPUT_CLASS_NAME;
import static nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldErrorMessageFactory.createErrorMessageLabel;
import static nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht.UtrechtFormFieldCheckboxClasses.UTRECHT_FORM_FIELD_LABEL_CHECKBOX_CLASS_NAME;
import static nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCssClassNames.FORM_LABEL_STATE_DISABLED_CLASS_NAME;
import static nl.rotterdam.design_system.wicket.components.models.DefaultModels.EMPTY_STRING_MODEL;
import static nl.rotterdam.design_system.wicket.components.output_tag.ComponentTagAssertions.assertIsRegularHtmlTag;

public class UtrechtFormFieldCheckbox extends GenericPanel<Boolean> implements UtrechtFormField {

    private final UtrechtCheckbox inputComponent;
    private final Component descriptionComponent;
    private final Component errorMessageComponent;
    private final Component labelComponent;

    public UtrechtFormFieldCheckbox(String id, IModel<Boolean> model, IModel<String> labelModel) {
        this(id, model, labelModel, EMPTY_STRING_MODEL);
    }

    public UtrechtFormFieldCheckbox(
        String id,
        IModel<Boolean> model,
        IModel<String> labelModel,
        IModel<String> descriptionModel
    ) {
        super(id);

        requireNonNull(labelModel);
        requireNonNull(descriptionModel);

        descriptionComponent = newDescriptionComponent(descriptionModel);
        errorMessageComponent = newErrorMessageComponent();
        inputComponent = newInputComponent(model, descriptionModel);
        inputComponent.setLabel(labelModel);
        bindErrorMessageModelToInputComponentFeedbackMessages();
        labelComponent = newLabelComponent();
    }

    private void bindErrorMessageModelToInputComponentFeedbackMessages() {
        // there is a bidirectional relationship between the input component and the error message component:
        // the input component holds the feedback messages, the error message component displays them.
        // Therefore, we need to bind the error message component's model to the input component's feedback messages.
        errorMessageComponent.setDefaultModel(() -> {
            FeedbackMessage first = inputComponent.getFeedbackMessages().first(FeedbackMessage.ERROR);
            return first != null ? first.getMessage().toString() : null;
        });
    }

    private Component newLabelComponent() {
        return new WebMarkupContainer("label-container")
            .add(new LabelAndCheckboxContainer())
            .add(appendCssClassBehavior(FORM_FIELD_NESTED_BLOCK_LABEL_CLASS_NAME))
            .add(appendCssClassBehavior(UTRECHT_FORM_FIELD_LABEL_CHECKBOX_CLASS_NAME));
    }

    private Component newErrorMessageComponent() {
        return createErrorMessageLabel("error")
            .add(appendCssClassBehavior(FORM_FIELD_NESTED_BLOCK_ERROR_MESSAGE_CLASS_NAME));
    }

    private static Component newDescriptionComponent(IModel<String> descriptionModel) {
        return new Label("description", descriptionModel)
            .add(UtrechtFormFieldDescriptionBehavior.INSTANCE)
            .add(appendCssClassBehavior(FORM_FIELD_NESTED_BLOCK_DESCRIPTION_CLASS_NAME));
    }

    private UtrechtCheckbox newInputComponent(IModel<Boolean> model, IModel<String> descriptionModel) {
        final UtrechtCheckbox control = new FormFieldCheckbox( model, descriptionModel);
        control.add(appendCssClassBehavior(FORM_FIELD_NESTED_BLOCK_INPUT_CLASS_NAME));
        return control;
    }

    protected boolean isInvalid() {
        return inputComponent.hasErrorMessage();
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        assertIsRegularHtmlTag(tag);

        if (isInvalid()) {
            appendCssClassesTo(tag, FORM_FIELD_STATE_INVALID_CLASS_NAME);
        }
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);

        add(
            UtrechtFormFieldBehavior.INSTANCE,
            UtrechtCheckboxFormFieldBehavior.INSTANCE
        );

        add(
            labelComponent,
            descriptionComponent,
            errorMessageComponent
        );
    }

    public UtrechtFormFieldCheckbox setRequired(boolean required) {
        inputComponent.setRequired(required);
        return this;
    }

    public CheckBox getControl() {
        return inputComponent;
    }

    @Override
    public Component getDescriptionComponent() {
        return descriptionComponent;
    }

    @Override
    public Component getLabelComponent() {
        return labelComponent;
    }

    @Override
    public Component getErrorMessageComponent() {
        return errorMessageComponent;
    }

    @Override
    public CheckBox getInputComponent() {
        return inputComponent;
    }

    private class LabelAndCheckboxContainer extends WebMarkupContainer {

        public LabelAndCheckboxContainer() {
            super("label");
        }

        @Override
        protected void onInitialize() {
            super.onInitialize();

            add(UtrechtFormLabelBehavior.INSTANCE_CHECKBOX);

            add(inputComponent);
        }

        @Override
        protected void onComponentTag(ComponentTag tag) {
            super.onComponentTag(tag);
            // TODO is for done by Wicket? Verify if works without too
            tag.put("for", inputComponent.getMarkupId());

            if (!inputComponent.isEnabledInHierarchy()) {
                appendCssClassesTo(tag, FORM_LABEL_STATE_DISABLED_CLASS_NAME);
            }
        }
    }

    class FormFieldCheckbox extends UtrechtCheckbox {

        private final IModel<String> descriptionModel;

        public FormFieldCheckbox(IModel<Boolean> model, IModel<String> descriptionModel) {
            super("checkbox", model);
            this.descriptionModel = descriptionModel;
        }

        @Override
        protected void onComponentTag(ComponentTag tag) {
            super.onComponentTag(tag);

            String ariaDescribedBy = HTMLUtil.idRefs(
                descriptionComponent != null && descriptionModel.getObject() != null ? descriptionComponent.getMarkupId() : null,
                errorMessageComponent != null && hasErrorMessage() ? errorMessageComponent.getMarkupId() : null
            );

            // Do not render an empty `aria-describedby` attribute.
            if (!ariaDescribedBy.isEmpty()) {
                tag.put("aria-describedby", ariaDescribedBy);
            }
        }
    }

}
