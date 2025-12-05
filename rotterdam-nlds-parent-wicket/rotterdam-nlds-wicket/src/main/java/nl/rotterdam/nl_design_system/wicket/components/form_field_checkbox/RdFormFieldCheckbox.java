package nl.rotterdam.nl_design_system.wicket.components.form_field_checkbox;

import nl.rotterdam.nl_design_system.wicket.components.checkbox.RdCheckbox;
import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormField;
import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldBehavior;
import nl.rotterdam.nl_design_system.wicket.components.form_field_description.RdFormFieldDescriptionBehavior;
import nl.rotterdam.nl_design_system.wicket.components.form_field_label.RdFormFieldLabelBehavior;
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
import org.jspecify.annotations.Nullable;

import static java.util.Objects.requireNonNull;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.BETA;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.DESCRIPTION_ELEMENT;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.ERROR_MESSAGE_ELEMENT;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.INPUT_ELEMENT;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.LABEL_ELEMENT;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.INVALID;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldErrorMessageFactory.createErrorMessageLabel;
import static nl.rotterdam.nl_design_system.wicket.components.form_field_checkbox.RdFormFieldCheckboxCss.FORM_FIELD_LABEL_CHECKBOX;
import static nl.rotterdam.nl_design_system.wicket.components.form_field_label.RdFormFieldLabelCheckableInputType.CHECKBOX;
import static nl.rotterdam.nl_design_system.wicket.components.models.DefaultModels.EMPTY_STRING_MODEL;
import static nl.rotterdam.nl_design_system.wicket.components.output_tag.ComponentTagAssertions.assertIsRegularHtmlTag;

/**
 * <a href="https://nldesignsystem.nl/form-field/">Form Field</a>
 * <a href="https://nldesignsystem.nl/checkbox/">Checkbox</a> NL Design System implementation.
 */
@NlComponentState(wicketState = BETA, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdFormFieldCheckbox extends GenericPanel<Boolean> implements RdFormField {

    private final RdCheckbox inputComponent;

    private final Component descriptionComponent;

    private final Component errorMessageComponent;

    private final Component labelComponent;

    /**
     * Creates instance with label, without description.
     * @param id the Wicket ID
     * @param model writable model
     * @param labelModel label for checkbox
     */
    public RdFormFieldCheckbox(String id, IModel<Boolean> model, IModel<String> labelModel) {
        this(id, model, labelModel, EMPTY_STRING_MODEL);
    }

    /**
     * Creates instance with label and description.
     *
     * @param id the Wicket ID
     * @param model writable model
     * @param labelModel for the checkbox
     * @param descriptionModel detailed description, additional to label. If it is an empty string, will not be rendered.
     */
    public RdFormFieldCheckbox(
        String id,
        IModel<Boolean> model,
        IModel<String> labelModel,
        IModel<@Nullable String> descriptionModel
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
            .add(LABEL_ELEMENT.asBehavior())
            .add(FORM_FIELD_LABEL_CHECKBOX.asBehavior());
    }

    private Component newErrorMessageComponent() {
        return createErrorMessageLabel("error").add(ERROR_MESSAGE_ELEMENT.asBehavior());
    }

    private static Component newDescriptionComponent(IModel<@Nullable String> descriptionModel) {
        return new Label("description", descriptionModel)
            .add(RdFormFieldDescriptionBehavior.INSTANCE)
            .add(DESCRIPTION_ELEMENT.asBehavior());
    }

    private RdCheckbox newInputComponent(IModel<Boolean> model, IModel<String> descriptionModel) {
        final RdCheckbox control = new FormFieldCheckbox(model, descriptionModel);
        control.add(INPUT_ELEMENT.asBehavior());
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

    /**
     * Add behaviors to this form field and return specific type of self.
     * @param behaviors
     *            The behavior modifier(s) to be added
     * @return self for chaining
     */
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

        private LabelAndCheckboxContainer() {
            super("label");
        }

        @Override
        protected void onInitialize() {
            super.onInitialize();

            var labelBehavior = new RdFormFieldLabelBehavior(CHECKBOX, inputComponent.getModel());
            labelBehavior.setComponentLabelIsFor(inputComponent);
            add(labelBehavior);

            add(inputComponent);
        }
    }

    class FormFieldCheckbox extends RdCheckbox {

        private final IModel<@Nullable String> descriptionModel;

        private FormFieldCheckbox(IModel<Boolean> model, IModel<String> descriptionModel) {
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
