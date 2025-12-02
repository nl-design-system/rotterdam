package nl.rotterdam.nl_design_system.wicket.components.form_field_text_input;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormField;
import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldBehavior;
import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldErrorMessageFactory;
import nl.rotterdam.nl_design_system.wicket.components.form_field_description.RdFormFieldDescriptionBehavior;
import nl.rotterdam.nl_design_system.wicket.components.form_label.RdFormLabelBehavior;
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
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.FORM_FIELD_NESTED_BLOCK_DESCRIPTION;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.FORM_FIELD_NESTED_BLOCK_ERROR_MESSAGE;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.FORM_FIELD_NESTED_BLOCK_INPUT;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.FORM_FIELD_NESTED_BLOCK_LABEL;
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
public class RdFormFieldTextInput<T> extends GenericPanel<T> implements RdFormField {

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
     * @param labelText label to be shown
     */
    public RdFormFieldTextInput(String id, IModel<T> model, IModel<String> labelText) {
        this(id, model, labelText, EMPTY_STRING_MODEL);
    }

    /**
     * Create instance with label, without description.
     * @param id the Wicket ID
     * @param model writable model
     * @param labelText label to be shown
     * @param description description text to be rendered, when label is not enough to explain purpose
     */
    public RdFormFieldTextInput(
        String id,
        IModel<T> model,
        IModel<String> labelText,
        IModel<@Nullable String> description
    ) {
        super(id, model);
        requireNonNull(labelText);
        requireNonNull(description);

        textInput = new FormFieldTextInput(model, description);
        textInput.setLabel(labelText);

        // Create the text input
        labelComponent = newLabelComponent();
        descriptionComponent = newDescriptionComponent(description);
        inputComponent = newInputComponent(textInput);
        errorMessageComponent = newErrorMessageComponent();
    }

    /**
     * Initialize the text input in the callback. TextInput and FormField are in scope.
     *
     * <p>By using this callback you can initialize the Component in a fluent api style, without intermediary
     * assignments.</p>
     * @param callback with custom logic for the current instance
     *
     * @return self for chaining
     */
    public RdFormFieldTextInput<T> withTextInput(WithTextInputCallback<T> callback) {
        // TODO: consider postponing actual callback calling to onInitialize(). with that, we would have to store callbacks
        //  as serializable attributes but leads to slightly better Wicket livecycle.
        callback.doWithTextInput(textInput, this);

        return this;
    }

    private static Component newInputComponent(TextField<?> textInput) {
        return new WebMarkupContainer("input-container").add(textInput).add(FORM_FIELD_NESTED_BLOCK_INPUT.asBehavior());
    }

    private Component newErrorMessageComponent() {
        return RdFormFieldErrorMessageFactory.createErrorMessageLabel("error", textInput).add(
            FORM_FIELD_NESTED_BLOCK_ERROR_MESSAGE.asBehavior()
        );
    }

    private static Component newDescriptionComponent(IModel<@Nullable String> descriptionModel) {
        return new Label("description", descriptionModel)
            .add(RdFormFieldDescriptionBehavior.INSTANCE)
            .add(FORM_FIELD_NESTED_BLOCK_DESCRIPTION.asBehavior());
    }

    private Component newLabelComponent() {
        return new WebMarkupContainer("label-container")
            .add(new TextInputLabel())
            .add(FORM_FIELD_NESTED_BLOCK_LABEL.asBehavior());
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

            add(RdFormLabelBehavior.INSTANCE_DEFAULT);
        }

        @Override
        protected void onComponentTag(ComponentTag tag) {
            super.onComponentTag(tag);
            tag.put("for", textInput.getMarkupId());
        }
    }
}
