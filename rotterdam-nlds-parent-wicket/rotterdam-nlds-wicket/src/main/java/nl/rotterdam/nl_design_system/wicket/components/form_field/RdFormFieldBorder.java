package nl.rotterdam.nl_design_system.wicket.components.form_field;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.form_field_description.RdFormFieldDescriptionBehavior;
import nl.rotterdam.nl_design_system.wicket.components.form_field_label.RdFormFieldLabelBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.LabeledWebMarkupContainer;
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
import static nl.rotterdam.nl_design_system.wicket.components.models.DefaultModels.NULL_STRING_MODEL;
import static nl.rotterdam.nl_design_system.wicket.components.output_tag.ComponentTagAssertions.assertIsRegularHtmlTag;

/**
 * <p>
 * A {@link Border} implementation of  <a href="https://nldesignsystem.nl/form-field/">Form Field</a>, which can be used
 * for components with which it is more complex to work with. This border cannot be used for checkboxes or radio
 * buttons.
 * </p>
 * <p>
 * Based on the
 * <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-form-field--docs">CSS implementation of Utrect</a>.
 * </p>
 *
 * @param <T> the model object type
 */
@NlComponentState(wicketState = BETA, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public abstract class RdFormFieldBorder<T extends @Nullable Object> extends Border implements RdFormField {

    private final Component labelComponent;

    private final Component descriptionComponent;

    private final Component errorMessageComponent;

    private final Component inputComponent;

    private final FormComponent<T> input;
    /**
     * Create instance with label, without description.
     * @param id the Wicket ID
     * @param model writable model
     * @param labelModel label to be shown
     */
    public RdFormFieldBorder(String id, IModel<T> model, IModel<@Nullable String> labelModel) {
        this(id, model, labelModel, NULL_STRING_MODEL);
    }

    /**
     * Create instance with label, without description.
     * @param id the Wicket ID
     * @param model writable model
     * @param labelModel label to be shown
     * @param descriptionModel description text to be rendered, when label is not enough to explain purpose
     */
    public RdFormFieldBorder(
        String id,
        IModel<T> model,
        IModel<@Nullable String> labelModel,
        IModel<@Nullable String> descriptionModel

    ) {
        super(id);
        requireNonNull(labelModel);
        requireNonNull(descriptionModel);

        input = newInput(model);
        input.setLabel(labelModel);

        labelComponent = newLabelComponent();
        descriptionComponent = newDescriptionComponent(descriptionModel);
        inputComponent = newInputComponent();
        errorMessageComponent = newErrorMessageComponent(input);
    }

    /**
     * <p>
     * Modify the input element using the given consumer. This Form Field will also be passed to the consumer.
     * </p>
     * <p>
     * By using this method you can modify the form component in a fluent API style, without needing intermediary
     * assignments.
     * </p>
     * 
     * @param consumer modifies the input in this Form Field.
     *
     * @return self for chaining.
     */
    public RdFormFieldBorder<T> withInput(WithInputConsumer<T> consumer) {
        consumer.doWithInput(input, this);

        return this;
    }

    /**
     * <p>
     * Create the form component. It must have Wicket ID <code>input</code>, so the label of the input will be correctly
     * copied to <code>label</code>.
     * </p>
     * 
     * @param model the model for the form component.
     * @return the form component.
     */
    protected abstract FormComponent<T> newInput(IModel<T> model);

    private static Component newInputComponent() {
        return new WebMarkupContainer("input-container").add(INPUT_ELEMENT.asBehavior());
    }

    private Component newErrorMessageComponent(Component input) {
        return RdFormFieldErrorMessageFactory.createErrorMessageLabel("error", input).add(
            ERROR_MESSAGE_ELEMENT.asBehavior()
        );
    }

    private static Component newDescriptionComponent(IModel<@Nullable String> descriptionModel) {
        return new Label("description", descriptionModel)
            .add(RdFormFieldDescriptionBehavior.INSTANCE)
            .add(DESCRIPTION_ELEMENT.asBehavior());
    }

    private Component newLabelComponent() {
        return new WebMarkupContainer("label-container")
            .add(new InputLabel(input, getBodyContainer().getId()))
            .add(LABEL_ELEMENT.asBehavior());
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);

        // TODO: additional instance for the type of input
        add(RdFormFieldBehavior.INSTANCE);

        addToBorder(inputComponent, labelComponent, descriptionComponent, errorMessageComponent);
        add(input);
    }

    private boolean isInvalid() {
        return input.hasErrorMessage();
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
     * Marks the input as required
     * @param required if it should be required.
     * @return self for chaining.
     */
    public RdFormFieldBorder<T> setRequired(boolean required) {
        input.setRequired(required);
        return this;
    }

    /**
     * Get reference to underlying input.
     * @return the instance
     */
    public final FormComponent<T> getInput() {
        return input;
    }

    @Override
    public Component getDescriptionComponent() {
        return descriptionComponent;
    }

    @Override
    public RdFormFieldBorder<T> add(Behavior... behaviors) {
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
    
    private static class InputLabel extends WebMarkupContainer {

        private final LabeledWebMarkupContainer input;

        private InputLabel(LabeledWebMarkupContainer input, String bodyContainerId) {
            super("label");
            this.input = input;

            // Use markup with a direct path to the input to prevent having to search multiple containers for `input`.
            setMarkup(Markup.of("<label wicket:id='label'><wicket:label for='..:..:input-container:"
                + bodyContainerId
                + ":input'></wicket:label></label>"));
        }

        @Override
        protected void onInitialize() {
            super.onInitialize();

            var labelBehavior = new RdFormFieldLabelBehavior();
            labelBehavior.setComponentLabelIsFor(input);
            add(labelBehavior);
        }
    }
}
