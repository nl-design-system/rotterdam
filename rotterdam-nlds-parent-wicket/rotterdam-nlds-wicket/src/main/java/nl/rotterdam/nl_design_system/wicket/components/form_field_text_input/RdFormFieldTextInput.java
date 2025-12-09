package nl.rotterdam.nl_design_system.wicket.components.form_field_text_input;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormField;
import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldBehavior;
import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldErrorMessageFactory;
import nl.rotterdam.nl_design_system.wicket.components.form_field_description.RdFormFieldDescriptionBehavior;
import nl.rotterdam.nl_design_system.wicket.components.form_field_label.RdFormFieldLabelBehavior;
import nl.rotterdam.nl_design_system.wicket.components.text_input.RdTextInput;
import nl.rotterdam.nl_design_system.wicket.html.TokenSetBuilder;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.string.Strings;
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
import static nl.rotterdam.nl_design_system.wicket.components.models.DefaultModels.EMPTY_STRING_MODEL;
import static nl.rotterdam.nl_design_system.wicket.components.output_tag.ComponentTagAssertions.assertIsRegularHtmlTag;

/**
 * <a href="https://nldesignsystem.nl/form-field/">Form Field</a>
 * <a href="https://nldesignsystem.nl/text-input/">Text Input</a> NL Design System implementation.
 *
 * <p>Uses the <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-textbox--docs">
 *     Utrecht Textbox</a>  community implementation.
 * </p>
 *
 * @param <T> the model object type
 */
@NlComponentState(wicketState = BETA, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdFormFieldTextInput<T extends @Nullable Object> extends GenericPanel<T> implements RdFormField {

    private String inputType = "text";

    private final Component labelComponent;

    private final Component descriptionComponent;

    private final Component errorMessageComponent;

    private final Component inputComponent;

    private final FormFieldTextInput textInput;

    /**
     * Create instance with label, without description.
     * @param id the Wicket ID
     * @param model writable model
     * @param labelModel label to be shown
     */
    public RdFormFieldTextInput(String id, IModel<T> model, IModel<@Nullable String> labelModel) {
        this(id, model, labelModel, EMPTY_STRING_MODEL);
    }

    /**
     * Create instance with label, without description.
     * @param id the Wicket ID
     * @param model writable model
     * @param labelModel label to be shown
     * @param descriptionModel description text to be rendered, when label is not enough to explain purpose
     */
    public RdFormFieldTextInput(
        String id,
        IModel<T> model,
        IModel<@Nullable String> labelModel,
        IModel<@Nullable String> descriptionModel

    ) {
        super(id, model);
        requireNonNull(labelModel);
        requireNonNull(descriptionModel);

        textInput = new FormFieldTextInput(model, descriptionModel);
        textInput.setLabel(labelModel);

        // Create the text input
        labelComponent = newLabelComponent();
        descriptionComponent = newDescriptionComponent(descriptionModel);
        inputComponent = newInputComponent(textInput);
        errorMessageComponent = newErrorMessageComponent();
    }

    /**
     * <p>
     * Modify the Text Input using the given consumer. This Form Field will also be passed to the consumer.
     * </p>
     * <p>
     * By using this method you can modify the Text Input in a fluent API style, without needing intermediary
     * assignments.
     * </p>
     *
     * @param consumer modifies the Text Input in this Form Field.
     *
     * @return self for chaining.
     */
    public RdFormFieldTextInput<T> withTextInput(WithTextInputConsumer<T> consumer) {
        consumer.doWithTextInput(textInput, this);

        return this;
    }

    private static Component newInputComponent(TextField<?> textInput) {
        return new WebMarkupContainer("input-container").add(textInput).add(INPUT_ELEMENT.asBehavior());
    }

    private Component newErrorMessageComponent() {
        return RdFormFieldErrorMessageFactory.createErrorMessageLabel("error", textInput).add(
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
            .add(new TextInputLabel())
            .add(LABEL_ELEMENT.asBehavior());
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);

        add(RdFormFieldBehavior.INSTANCE, RdFormFieldTextInputBehavior.INSTANCE);

        add(inputComponent, labelComponent, descriptionComponent, errorMessageComponent);
    }

    private boolean isInvalid() {
        return textInput.hasErrorMessage();
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
     * Marks {@link TextField<T>} as required
     * @param required if it should be required.
     * @return self for chaining.
     */
    public RdFormFieldTextInput<T> setRequired(boolean required) {
        textInput.setRequired(required);
        return this;
    }

    /**
     * Get reference to underlying {@link TextField}
     * @return the instance
     */
    public final TextField<T> getTextField() {
        return textInput;
    }

    public RdFormFieldTextInput<T> setInputType(String type) {
        inputType = type;

        return this;
    }

    @Override
    public Component getDescriptionComponent() {
        return descriptionComponent;
    }

    @Override
    public RdFormFieldTextInput<T> add(Behavior... behaviors) {
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

    private class FormFieldTextInput extends RdTextInput<T> {

        private final IModel<@Nullable String> descriptionModel;

        private FormFieldTextInput(IModel<T> model, IModel<@Nullable String> descriptionModel) {
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

            if (!Strings.isEmpty(inputType)) {
                tag.put("type", inputType);
            }
        }
    }

    private class TextInputLabel extends WebMarkupContainer {

        private TextInputLabel() {
            super("label");
        }

        @Override
        protected void onInitialize() {
            super.onInitialize();

            var labelBehavior = new RdFormFieldLabelBehavior();
            labelBehavior.setComponentLabelIsFor(textInput);
            add(labelBehavior);
        }
    }
}
