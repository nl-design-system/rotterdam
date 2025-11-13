package nl.rotterdam.nl_design_system.wicket.components.form_field_checkbox;

import static java.util.Objects.requireNonNull;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.BETA;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.FORM_FIELD_NESTED_BLOCK_DESCRIPTION;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.FORM_FIELD_NESTED_BLOCK_ERROR_MESSAGE;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.FORM_FIELD_NESTED_BLOCK_INPUT;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.FORM_FIELD_NESTED_BLOCK_LABEL;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.INVALID;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldErrorMessageFactory.createErrorMessageLabel;
import static nl.rotterdam.nl_design_system.wicket.components.form_field_checkbox.RdFormFieldCheckboxCss.FORM_FIELD_LABEL_CHECKBOX;
import static nl.rotterdam.nl_design_system.wicket.components.models.DefaultModels.EMPTY_STRING_MODEL;
import static nl.rotterdam.nl_design_system.wicket.components.output_tag.ComponentTagAssertions.assertIsRegularHtmlTag;

import nl.rotterdam.nl_design_system.wicket.components.checkbox.RdCheckbox;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormField;
import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldBehavior;
import nl.rotterdam.nl_design_system.wicket.components.form_field_description.RdFormFieldDescriptionBehavior;
import nl.rotterdam.nl_design_system.wicket.components.form_label.RdFormLabelBehavior;
import nl.rotterdam.nl_design_system.wicket.html.TokenSetBuilder;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.NonNull;

/**
 * <a href="https://nldesignsystem.nl/form-field/">Form Field</a>
 * <a href="https://nldesignsystem.nl/checkbox/">Checkbox</a> NL Design System implementation.
 */
@NlComponentState(wicketState = BETA, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdFormFieldCheckbox extends GenericPanel<Boolean> implements RdFormField {

    @NonNull
    private final RdCheckbox inputComponent;

    @NonNull
    private final Component descriptionComponent;

    @NonNull
    private final Component errorMessageComponent;

    @NonNull
    private final Component labelComponent;

    /**
     * Creates instance with label, without description.
     * @param id wicket id
     * @param model writable model
     * @param labelModel label for checkbox
     */
    public RdFormFieldCheckbox(String id, IModel<Boolean> model, IModel<String> labelModel) {
        this(id, model, labelModel, EMPTY_STRING_MODEL);
    }

    /**
     * Creates instance with label and description.
     *
     * @param id wicket id
     * @param model writable model
     * @param labelModel for the checkbox
     * @param descriptionModel detailed description, additional to label. If it is an empty string, will not be rendered.
     */
    public RdFormFieldCheckbox(
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
            .add(FORM_FIELD_LABEL_CHECKBOX.asBehavior());
    }

    private Component newErrorMessageComponent() {
        return createErrorMessageLabel("error").add(FORM_FIELD_NESTED_BLOCK_ERROR_MESSAGE.asBehavior());
    }

    private static Component newDescriptionComponent(IModel<String> descriptionModel) {
        return new Label("description", descriptionModel)
            .add(RdFormFieldDescriptionBehavior.INSTANCE)
            .add(FORM_FIELD_NESTED_BLOCK_DESCRIPTION.asBehavior());
    }

    private RdCheckbox newInputComponent(IModel<Boolean> model, IModel<String> descriptionModel) {
        final RdCheckbox control = new FormFieldCheckbox(model, descriptionModel);
        control.add(FORM_FIELD_NESTED_BLOCK_INPUT.asBehavior());
        return control;
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        assertIsRegularHtmlTag(tag);

        if (inputComponent.hasErrorMessage()) {
            INVALID.appendTo(tag);
        }
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);

        add(RdFormFieldBehavior.INSTANCE, RdCheckboxFormFieldBehavior.INSTANCE);

        add(labelComponent, descriptionComponent, errorMessageComponent);
    }

    /**
     * Mark checking the checkbox required.
     * @param required true if it should be required
     * @return self for chaining
     */
    public RdFormFieldCheckbox setRequired(boolean required) {
        inputComponent.setRequired(required);
        return this;
    }

    @Override
    public RdFormFieldCheckbox add(Behavior... behaviors) {
        super.add(behaviors);
        return this;
    }

    /**
     * Get the actual {@link CheckBox}. Can be used to customize it.
     * @return the checkbox instance
     */
    public CheckBox getControl() {
        return inputComponent;
    }

    @Override
    public @NonNull Component getDescriptionComponent() {
        return descriptionComponent;
    }

    @Override
    public @NonNull Component getLabelComponent() {
        return labelComponent;
    }

    @Override
    public @NonNull Component getErrorMessageComponent() {
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

            add(RdFormLabelBehavior.INSTANCE_CHECKBOX);

            add(inputComponent);
        }

        @Override
        protected void onComponentTag(ComponentTag tag) {
            super.onComponentTag(tag);
            tag.put("for", inputComponent.getMarkupId());
        }
    }

    class FormFieldCheckbox extends RdCheckbox {

        private final IModel<String> descriptionModel;

        public FormFieldCheckbox(IModel<Boolean> model, IModel<String> descriptionModel) {
            super("checkbox", model);
            this.descriptionModel = descriptionModel;
        }

        @Override
        protected void onComponentTag(ComponentTag tag) {
            super.onComponentTag(tag);

            new TokenSetBuilder()
                .append(descriptionModel.getObject() != null, descriptionComponent::getMarkupId)
                .append(hasErrorMessage(), errorMessageComponent::getMarkupId)
                .use(ariaDescribedBy -> tag.put("aria-describedby", ariaDescribedBy));
        }
    }
}
