package nl.rotterdam.design_system.wicket.components.form_field_textbox.utrecht;

import css.HTMLUtil;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormField;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldContainerBehavior;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldErrorMessageFactory;
import nl.rotterdam.design_system.wicket.components.form_field_description.utrecht.UtrechtFormFieldDescriptionBehavior;
import nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelBehavior;
import nl.rotterdam.design_system.wicket.components.textbox.utrecht.UtrechtTextboxFormFieldBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.string.Strings;

import static java.util.Objects.requireNonNull;
import static nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldCssClasses.*;
import static nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCssClasses.FORM_LABEL_STATE_DISABLED_CLASSNAME;
import static nl.rotterdam.design_system.wicket.components.models.DefaultModels.EMPTY_STRING_MODEL;
import static nl.rotterdam.design_system.wicket.components.output_tag.ComponentTagAssertions.assertIsRegularHtmlTag;

public class UtrechtFormFieldTextbox<T> extends GenericPanel<T> implements UtrechtFormField {

    private String inputType = "text";
    private final Component labelComponent;
    private final Component descriptionComponent;
    private final Component errorMessageComponent;
    private final Component inputComponent;
    private final UtrechtTextbox textbox;

    public UtrechtFormFieldTextbox(String id, IModel<T> model, IModel<String> labelText) {
        this(id, model, labelText, EMPTY_STRING_MODEL);
    }

    public UtrechtFormFieldTextbox(
        String id,
        IModel<T> model,
        IModel<String> labelModel,
        IModel<String> descriptionModel
    ) {
        super(id);
        requireNonNull(labelModel);
        requireNonNull(descriptionModel);

        textbox = new UtrechtTextbox(model, descriptionModel);
        // Create the text input
        labelComponent = newLabelComponent(labelModel);
        descriptionComponent = newDescriptionComponent(descriptionModel);
        inputComponent = newInputComponent(textbox);
        errorMessageComponent = newErrorMessageComponent();
    }

    private static Component newInputComponent(TextField<?> inputTextbox) {
        return new WebMarkupContainer("input-container")
            .add(inputTextbox)
            .add(AttributeAppender.append("class", FORM_FIELD_NESTED_BLOCK_INPUT_CLASSNAME));
    }

    private Component newErrorMessageComponent() {
        return UtrechtFormFieldErrorMessageFactory.createErrorMessageLabel("error", inputComponent)
            .add(AttributeAppender.append("class", FORM_FIELD_NESTED_BLOCK_ERROR_MESSAGE_CLASSNAME));
    }

    private static Component newDescriptionComponent(IModel<String> descriptionModel) {
        return new Label("description", descriptionModel)
            .add(UtrechtFormFieldDescriptionBehavior.INSTANCE)
            .add(AttributeAppender.append("class", FORM_FIELD_NESTED_BLOCK_DESCRIPTION_CLASSNAME));
    }

    private Component newLabelComponent(IModel<String> labelModel) {
        return new WebMarkupContainer("label-container")
            .add(new TextboxLabel(labelModel))
            .add(AttributeAppender.append("class", FORM_FIELD_NESTED_BLOCK_LABEL_CLASSNAME));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);

        add(
            UtrechtFormFieldContainerBehavior.INSTANCE,
            UtrechtTextboxFormFieldBehavior.INSTANCE
        );

        add(
            inputComponent,
            labelComponent,
            descriptionComponent,
            errorMessageComponent
        );
    }

    private boolean isInvalid() {
        return textbox.hasErrorMessage();
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        assertIsRegularHtmlTag(tag);

        tag.put("class", HTMLUtil.className(isInvalid() ? FORM_FIELD_STATE_INVALID_CLASSNAME : null));
    }

    public UtrechtFormFieldTextbox<T> setRequired(boolean required) {
        getTextField().setRequired(required);
        return this;
    }

    public TextField<T> getTextField() {
        return textbox;
    }

    public UtrechtFormFieldTextbox<T> setInputType(String type) {
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

    class UtrechtTextbox extends TextField<T> {

        public static final String CLASSNAME = "utrecht-textbox utrecht-textbox--html-input";

        public static final String INVALID_CLASSNAME = "utrecht-textbox--invalid";

        public static final String DISABLED_CLASSNAME = "utrecht-textbox--disabled";

        private final IModel<String> descriptionModel;

        public UtrechtTextbox(IModel<T> model, IModel<String> descriptionModel) {
            super("control", model);
            this.descriptionModel = descriptionModel;
        }

        @Override
        protected void onComponentTag(ComponentTag tag) {
            super.onComponentTag(tag);
            tag.put(
                "class",
                HTMLUtil.className(
                    CLASSNAME,
                    isEnabledInHierarchy() ? null :  DISABLED_CLASSNAME,
                    hasErrorMessage() ? INVALID_CLASSNAME : null
                )
            );

            String ariaDescribedBy = HTMLUtil.idRefs(
                descriptionModel != null && descriptionModel.getObject() != null ? descriptionComponent.getMarkupId() : null,
                isInvalid() ? errorMessageComponent.getMarkupId() : null
            );

            // Do not render an empty `aria-describedby` attribute.
            if (!ariaDescribedBy.isEmpty()) {
                tag.put("aria-describedby", ariaDescribedBy);
            }

            if (isRequired()) {
                tag.put("aria-required", "true");
            }
            if (isInvalid()) {
                tag.put("aria-invalid", "true");
            }
            if (!Strings.isEmpty(inputType)) {
                tag.put("type", inputType);
            }
        }
    }

    private class TextboxLabel extends Label {

        public TextboxLabel(IModel<String> labelModel) {
            super("label", labelModel);
        }

        @Override
        protected void onInitialize() {
            super.onInitialize();

            add(UtrechtFormLabelBehavior.INSTANCE_DEFAULT);
        }

        @Override
        protected void onComponentTag(ComponentTag tag) {
            super.onComponentTag(tag);
            tag.put("for", textbox.getMarkupId());
            tag.put(
                "class",
                HTMLUtil.className(
                    textbox.isEnabledInHierarchy() ? null :  FORM_LABEL_STATE_DISABLED_CLASSNAME
                )
            );
        }
    }
}
