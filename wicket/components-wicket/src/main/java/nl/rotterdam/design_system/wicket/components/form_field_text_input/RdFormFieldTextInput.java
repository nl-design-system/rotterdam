package nl.rotterdam.design_system.wicket.components.form_field_text_input;

import css.HTMLUtil;
import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.design_system.wicket.components.form_field.RdFormField;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldBehavior;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldErrorMessageFactory;
import nl.rotterdam.design_system.wicket.components.form_field_description.utrecht.UtrechtFormFieldDescriptionBehavior;
import nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelBehavior;
import nl.rotterdam.design_system.wicket.components.text_input.NlTextInput;
import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.string.Strings;

import static java.util.Objects.requireNonNull;
import static nl.rotterdam.design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.BETA;
import static nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldCss.*;
import static nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCss.FORM_LABEL_STATE_DISABLED;
import static nl.rotterdam.design_system.wicket.components.models.DefaultModels.EMPTY_STRING_MODEL;
import static nl.rotterdam.design_system.wicket.components.output_tag.ComponentTagAssertions.assertIsRegularHtmlTag;

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
    private final FormFieldTexInput textInput;

    public RdFormFieldTextInput(String id, IModel<T> model, IModel<String> labelText) {
        this(id, model, labelText, EMPTY_STRING_MODEL);
    }

    public RdFormFieldTextInput(
        String id,
        IModel<T> model,
        IModel<String> labelModel,
        IModel<String> descriptionModel
    ) {
        super(id);
        requireNonNull(labelModel);
        requireNonNull(descriptionModel);

        textInput = new FormFieldTexInput(model, descriptionModel);
        textInput.setLabel(labelModel);

        // Create the text input
        labelComponent = newLabelComponent();
        descriptionComponent = newDescriptionComponent(descriptionModel);
        inputComponent = newInputComponent(textInput);
        errorMessageComponent = newErrorMessageComponent();
    }

    private static Component newInputComponent(TextField<?> textInput) {
        return new WebMarkupContainer("input-container")
            .add(textInput)
            .add(FORM_FIELD_NESTED_BLOCK_INPUT.asBehavior());
    }

    private Component newErrorMessageComponent() {
        return UtrechtFormFieldErrorMessageFactory.createErrorMessageLabel("error", textInput)
            .add(FORM_FIELD_NESTED_BLOCK_ERROR_MESSAGE.asBehavior());
    }

    private static Component newDescriptionComponent(IModel<String> descriptionModel) {
        return new Label("description", descriptionModel)
            .add(UtrechtFormFieldDescriptionBehavior.INSTANCE)
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

        add(
            UtrechtFormFieldBehavior.INSTANCE,
            RdFormFieldTextInputBehavior.INSTANCE
        );

        add(
            inputComponent,
            labelComponent,
            descriptionComponent,
            errorMessageComponent
        );
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

    public RdFormFieldTextInput<T> setRequired(boolean required) {
        getTextField().setRequired(required);
        return this;
    }

    public TextField<T> getTextField() {
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

    class FormFieldTexInput extends NlTextInput<T> {

        private final IModel<String> descriptionModel;

        public FormFieldTexInput(IModel<T> model, IModel<String> descriptionModel) {
            super("control", model);
            this.descriptionModel = descriptionModel;
        }

        @Override
        protected void onComponentTag(ComponentTag tag) {
            super.onComponentTag(tag);

            String ariaDescribedBy = HTMLUtil.idRefs(
                 descriptionModel.getObject() != null ? descriptionComponent.getMarkupId() : null,
                isInvalid() ? errorMessageComponent.getMarkupId() : null
            );

            // Do not render an empty `aria-describedby` attribute.
            if (!ariaDescribedBy.isEmpty()) {
                tag.put("aria-describedby", ariaDescribedBy);
            }

            if (!Strings.isEmpty(inputType)) {
                tag.put("type", inputType);
            }
        }
    }

    private class TextInputLabel extends WebMarkupContainer {

        public TextInputLabel() {
            super("label");
        }

        @Override
        protected void onInitialize() {
            super.onInitialize();

            add(UtrechtFormLabelBehavior.INSTANCE_DEFAULT);
        }

        @Override
        protected void onComponentTag(ComponentTag tag) {
            super.onComponentTag(tag);
            tag.put("for", textInput.getMarkupId());

            if (!textInput.isEnabledInHierarchy()) {
                FORM_LABEL_STATE_DISABLED.appendTo(tag);
            }
        }
    }
}
