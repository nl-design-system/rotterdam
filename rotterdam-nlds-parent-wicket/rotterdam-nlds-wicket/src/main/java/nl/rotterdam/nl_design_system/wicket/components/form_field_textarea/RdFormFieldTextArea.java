package nl.rotterdam.nl_design_system.wicket.components.form_field_textarea;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormField;
import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldBehavior;
import nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldErrorMessageFactory;
import nl.rotterdam.nl_design_system.wicket.components.form_field_description.RdFormFieldDescriptionBehavior;
import nl.rotterdam.nl_design_system.wicket.components.form_field_label.RdFormFieldLabelBehavior;
import nl.rotterdam.nl_design_system.wicket.components.text_area.RdTextArea;
import nl.rotterdam.nl_design_system.wicket.html.TokenSetBuilder;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

import static java.util.Objects.requireNonNull;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.BETA;
import static nl.rotterdam.nl_design_system.wicket.components.form_field.RdFormFieldCss.*;
import static nl.rotterdam.nl_design_system.wicket.components.models.DefaultModels.NULL_STRING_MODEL;
import static nl.rotterdam.nl_design_system.wicket.components.output_tag.ComponentTagAssertions.assertIsRegularHtmlTag;

/**
 * <a href="https://nldesignsystem.nl/form-field/">Form Field</a>
 * <a href="https://nldesignsystem.nl/text-area/">Text Area</a> NL Design System implementation.
 *
 * <p>Uses the <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-textarea--docs">
 *     Utrecht Textarea</a>  community implementation.
 * </p>
 *
 * @param <T> the model object type
 */
@NlComponentState(wicketState = BETA, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdFormFieldTextArea<T extends @Nullable Object> extends GenericPanel<T> implements RdFormField {

    private final Component labelComponent;

    private final Component descriptionComponent;

    private final Component errorMessageComponent;

    private final Component inputComponent;

    private final FormFieldTextArea textArea;

    /**
     * Create instance with label, without description.
     * @param id the Wicket ID
     * @param model writable model
     * @param labelModel label to be shown
     */
    public RdFormFieldTextArea(String id, IModel<T> model, IModel<@Nullable String> labelModel) {
        this(id, model, labelModel, NULL_STRING_MODEL);
    }

    /**
     * Create instance with label and description.
     * @param id the Wicket ID
     * @param model writable model
     * @param labelModel label to be shown
     * @param descriptionModel description text to be rendered, when label is not enough to explain purpose
     */
    public RdFormFieldTextArea(
        String id,
        IModel<T> model,
        IModel<@Nullable String> labelModel,
        IModel<@Nullable String> descriptionModel

    ) {
        super(id, model);
        requireNonNull(labelModel);
        requireNonNull(descriptionModel);

        textArea = new FormFieldTextArea(model, descriptionModel);
        textArea.setLabel(labelModel);

        // Create the text area
        labelComponent = newLabelComponent();
        descriptionComponent = newDescriptionComponent(descriptionModel);
        inputComponent = newInputComponent(textArea);
        errorMessageComponent = newErrorMessageComponent();
    }

    /**
     * Initialize the text area in the callback. TextArea and FormField are in scope.
     *
     * <p>By using this callback you can initialize the Component in a fluent api style, without intermediary
     * assignments.</p>
     * @param callback with custom logic for the current instance
     *
     * @return self for chaining
     */
    public RdFormFieldTextArea<T> withTextArea(WithTextAreaCallback<T> callback) {
        // TODO: consider postponing actual callback calling to onInitialize(). with that, we would have to store callbacks
        //  as serializable attributes but leads to slightly better Wicket lifecycle.
        callback.doWithTextArea(textArea, this);

        return this;
    }

    private static Component newInputComponent(TextArea<?> textArea) {
        return new WebMarkupContainer("input-container").add(textArea).add(INPUT_ELEMENT.asBehavior());
    }

    private Component newErrorMessageComponent() {
        return RdFormFieldErrorMessageFactory.createErrorMessageLabel("error", textArea).add(
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
            .add(new TextAreaLabel())
            .add(LABEL_ELEMENT.asBehavior());
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);

        add(RdFormFieldBehavior.INSTANCE, RdFormFieldTextAreaBehavior.INSTANCE);

        add(inputComponent, labelComponent, descriptionComponent, errorMessageComponent);
    }

    private boolean isInvalid() {
        return textArea.hasErrorMessage();
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
     * Marks {@link TextArea<T>} as required
     * @param required if it should be required.
     * @return self for chaining.
     */
    public RdFormFieldTextArea<T> setRequired(boolean required) {
        textArea.setRequired(required);
        return this;
    }

    /**
     * Get reference to underlying {@link TextArea}
     * @return the instance
     */
    public final TextArea<T> getTextArea() {
        return textArea;
    }

    @Override
    public Component getDescriptionComponent() {
        return descriptionComponent;
    }

    @Override
    public RdFormFieldTextArea<T> add(Behavior... behaviors) {
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

    private class FormFieldTextArea extends RdTextArea<T> {

        private final IModel<@Nullable String> descriptionModel;

        private FormFieldTextArea(IModel<T> model, IModel<@Nullable String> descriptionModel) {
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

    private class TextAreaLabel extends WebMarkupContainer {

        private TextAreaLabel() {
            super("label");
        }

        @Override
        protected void onInitialize() {
            super.onInitialize();

            var labelBehavior = new RdFormFieldLabelBehavior();
            labelBehavior.setComponentLabelIsFor(textArea);
            add(labelBehavior);
        }
    }
}
