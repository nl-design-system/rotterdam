package nl.rotterdam.nl_design_system.wicket.components.form_field_date_picker;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.date_picker.RdDatePicker;
import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormField;
import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldBehavior;
import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldErrorMessageFactory;
import nl.rotterdam.nl_design_system.wicket.components.form_field_description.RdFormFieldDescriptionBehavior;
import nl.rotterdam.nl_design_system.wicket.components.form_field_label.RdFormFieldLabelBehavior;
import nl.rotterdam.nl_design_system.wicket.html.TokenSetBuilder;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.AbstractTextComponent;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

import java.time.LocalDateTime;

import static java.util.Objects.requireNonNull;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.ROTTERDAM;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.CANDIDATE;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.BETA;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.DESCRIPTION_ELEMENT;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.ERROR_MESSAGE_ELEMENT;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.INPUT_ELEMENT;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.INVALID;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.LABEL_ELEMENT;
import static nl.rotterdam.nl_design_system.wicket.components.models.DefaultModels.NULL_STRING_MODEL;
import static nl.rotterdam.nl_design_system.wicket.components.output_tag.ComponentTagAssertions.assertIsRegularHtmlTag;

/**
 * <a href="https://nldesignsystem.nl/form-field/">Form Field</a>
 * Date Picker NL Design System implementation.
 *
 * <p>Uses the {@code <rods-date-picker>} web component from the
 * {@code @gemeente-rotterdam/date-picker-element} package.
 * </p>
 */
@NlComponentState(wicketState = BETA, estafetteState = CANDIDATE, htmlCssImplementedBy = ROTTERDAM)
public class RdFormFieldDatePicker extends GenericPanel<@Nullable LocalDateTime> implements RdFormField {

    private final Component labelComponent;
    private final Component descriptionComponent;
    private final Component errorMessageComponent;
    private final Component inputComponent;
    private final FormFieldDatePicker datePicker;

    /**
     * Create instance with label, without description.
     *
     * @param id the Wicket ID
     * @param model writable model
     * @param labelModel label to be shown
     */
    public RdFormFieldDatePicker(String id, IModel<@Nullable LocalDateTime> model, IModel<@Nullable String> labelModel) {
        this(id, model, labelModel, NULL_STRING_MODEL);
    }

    /**
     * Create instance with label and description.
     *
     * @param id the Wicket ID
     * @param model writable model
     * @param labelModel label to be shown
     * @param descriptionModel description text to be rendered, when label is not enough to explain purpose
     */
    public RdFormFieldDatePicker(
        String id,
        IModel<@Nullable LocalDateTime> model,
        IModel<@Nullable String> labelModel,
        IModel<@Nullable String> descriptionModel
    ) {
        super(id, model);
        requireNonNull(labelModel);
        requireNonNull(descriptionModel);

        datePicker = new FormFieldDatePicker(model, descriptionModel);

        // Create the date picker input
        labelComponent = newLabelComponent(labelModel);
        descriptionComponent = newDescriptionComponent(descriptionModel);
        inputComponent = newInputComponent(datePicker);
        errorMessageComponent = newErrorMessageComponent();
    }

    private static Component newInputComponent(RdDatePicker datePicker) {
        return new WebMarkupContainer("input-container").add(datePicker).add(INPUT_ELEMENT.asBehavior());
    }

    private Component newErrorMessageComponent() {
        return RdFormFieldErrorMessageFactory.createErrorMessageLabel("error", datePicker).add(
            ERROR_MESSAGE_ELEMENT.asBehavior()
        );
    }

    private static Component newDescriptionComponent(IModel<@Nullable String> descriptionModel) {
        return new Label("description", descriptionModel)
            .add(RdFormFieldDescriptionBehavior.INSTANCE)
            .add(DESCRIPTION_ELEMENT.asBehavior());
    }

    private Component newLabelComponent(IModel<@Nullable String> labelModel) {
        return new WebMarkupContainer("label-container")
            .add(new DatePickerLabel(labelModel))
            .add(LABEL_ELEMENT.asBehavior());
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);

        add(RdFormFieldBehavior.INSTANCE, RdFormFieldDatePickerBehavior.INSTANCE);

        add(inputComponent, labelComponent, descriptionComponent, errorMessageComponent);
    }

    private boolean isInvalid() {
        return datePicker.hasErrorMessage();
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        assertIsRegularHtmlTag(tag);

        if (isInvalid()) {
            INVALID.appendTo(tag);
        }
    }

    /**
     * Get reference to underlying {@link RdDatePicker}
     *
     * @return the instance
     */
    public final RdDatePicker getDatePicker() {
        return datePicker;
    }

    /**
     * Get reference to underlying {@link TextField}
     *
     * @return the instance
     */
    public final AbstractTextComponent<LocalDateTime> getTextComponent() {
        return datePicker;
    }

    /**
     * Marks {@link FormComponent<LocalDateTime>} as required
     *
     * @param required if it should be required.
     * @return self for chaining.
     */
    public RdFormFieldDatePicker setRequired(boolean required) {
        datePicker.setRequired(required);
        return this;
    }

    @Override
    public Component getDescriptionComponent() {
        return descriptionComponent;
    }

    @Override
    public RdFormFieldDatePicker add(Behavior... behaviors) {
        super.add(behaviors);
        return this;
    }

    @Override
    public Component getErrorMessageComponent() {
        return errorMessageComponent;
    }

    @Override
    public Component getInputComponent() {
        return inputComponent;
    }

    @Override
    public Component getLabelComponent() {
        return labelComponent;
    }

    private class FormFieldDatePicker extends RdDatePicker {

        private final IModel<@Nullable String> descriptionModel;

        private FormFieldDatePicker(IModel<@Nullable LocalDateTime> model, IModel<@Nullable String> descriptionModel) {
            super("control", model);
            this.descriptionModel = descriptionModel;
        }

        @Override
        protected void onComponentTag(ComponentTag tag) {
            super.onComponentTag(tag);

            new TokenSetBuilder()
                .append(descriptionModel.getObject() != null, descriptionComponent::getMarkupId)
                .append(isInvalid(), errorMessageComponent::getMarkupId)
                .use(ariaDescribedBy -> tag.put("aria-describedby", ariaDescribedBy));
        }
    }

    private class DatePickerLabel extends WebMarkupContainer {

        private DatePickerLabel(IModel<@Nullable String> labelModel) {
            super("label", labelModel);
        }

        @Override
        protected void onInitialize() {
            super.onInitialize();

            var labelBehavior = new RdFormFieldLabelBehavior();
            labelBehavior.setComponentLabelIsFor(datePicker);
            add(labelBehavior);
        }
    }
}
