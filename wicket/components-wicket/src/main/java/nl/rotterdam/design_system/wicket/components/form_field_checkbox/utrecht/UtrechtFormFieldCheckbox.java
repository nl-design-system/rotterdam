package nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht;

import css.HTMLUtil;
import nl.rotterdam.design_system.wicket.components.checkbox.utrecht.UtrechtCheckbox;
import nl.rotterdam.design_system.wicket.components.component_state.EstafetteState;
import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
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
import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.BETA;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;
import static nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldCss.*;
import static nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldCss.FORM_FIELD_NESTED_BLOCK_INPUT;
import static nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldErrorMessageFactory.createErrorMessageLabel;
import static nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht.UtrechtFormFieldCheckboxCss.UTRECHT_FORM_FIELD_LABEL_CHECKBOX;
import static nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCss.FORM_LABEL_STATE_DISABLED;
import static nl.rotterdam.design_system.wicket.components.models.DefaultModels.EMPTY_STRING_MODEL;
import static nl.rotterdam.design_system.wicket.components.output_tag.ComponentTagAssertions.assertIsRegularHtmlTag;


@NlComponentState(wicketState = BETA, estafetteState = COMMUNITY)
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
            .add(FORM_FIELD_NESTED_BLOCK_LABEL.asBehavior())
            .add(UTRECHT_FORM_FIELD_LABEL_CHECKBOX.asBehavior());
    }

    private Component newErrorMessageComponent() {
        return createErrorMessageLabel("error")
            .add(FORM_FIELD_NESTED_BLOCK_ERROR_MESSAGE.asBehavior());
    }

    private static Component newDescriptionComponent(IModel<String> descriptionModel) {
        return new Label("description", descriptionModel)
            .add(UtrechtFormFieldDescriptionBehavior.INSTANCE)
            .add(FORM_FIELD_NESTED_BLOCK_DESCRIPTION.asBehavior());
    }

    private UtrechtCheckbox newInputComponent(IModel<Boolean> model, IModel<String> descriptionModel) {
        final UtrechtCheckbox control = new FormFieldCheckbox( model, descriptionModel);
        control.add(FORM_FIELD_NESTED_BLOCK_INPUT.asBehavior());
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
            INVALID.appendTo(tag);
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
            tag.put("for", inputComponent.getMarkupId());

            if (!inputComponent.isEnabledInHierarchy()) {
                FORM_LABEL_STATE_DISABLED.appendTo(tag);
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
