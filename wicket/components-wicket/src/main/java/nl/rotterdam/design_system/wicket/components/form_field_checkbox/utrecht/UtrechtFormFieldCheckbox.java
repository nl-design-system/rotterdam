package nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht;

import css.HTMLUtil;
import nl.rotterdam.design_system.wicket.components.checkbox.utrecht.UtrechtCheckboxContainerBehavior;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormField;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldContainerBehavior;
import nl.rotterdam.design_system.wicket.components.form_field_description.utrecht.UtrechtFormFieldDescriptionBehavior;
import nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.WicketTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

import static java.util.Objects.requireNonNull;
import static nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldCssClasses.*;
import static nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldCssClasses.FORM_FIELD_NESTED_BLOCK_INPUT_CLASSNAME;
import static nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldErrorMessageFactory.createErrorMessageLabel;
import static nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCssClasses.FORM_LABEL_STATE_DISABLED_CLASSNAME;
import static nl.rotterdam.design_system.wicket.components.models.DefaultModels.EMPTY_STRING_MODEL;

public class UtrechtFormFieldCheckbox extends GenericPanel<Boolean> implements UtrechtFormField {

    private static final String LABEL_CHECKBOX_CLASSNAME = "utrecht-form-field__label--checkbox";

    private final CheckBox inputComponent;
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

        inputComponent = createInputComponent(model, descriptionModel);
        labelComponent = createLabelComponent(labelModel);
        descriptionComponent = createDescriptionComponent(descriptionModel);
        errorMessageComponent = createErrorMessageComponent();
    }

    private Component createLabelComponent(IModel<String> labelModel) {
        return new WebMarkupContainer("label-container")
            .add(new LabelAndCheckboxContainer(labelModel))
            .add(AttributeAppender.append("class", FORM_FIELD_NESTED_BLOCK_LABEL_CLASSNAME))
            .add(AttributeAppender.append("class", LABEL_CHECKBOX_CLASSNAME));
    }

    private Component createErrorMessageComponent() {
        return createErrorMessageLabel("error", inputComponent)
            .add(AttributeAppender.append("class", FORM_FIELD_NESTED_BLOCK_ERROR_MESSAGE_CLASSNAME));
    }

    private static Component createDescriptionComponent(IModel<String> descriptionModel) {
        return new Label("description", descriptionModel)
            .add(UtrechtFormFieldDescriptionBehavior.INSTANCE)
            .add(AttributeAppender.append("class", FORM_FIELD_NESTED_BLOCK_DESCRIPTION_CLASSNAME));
    }

    private CheckBox createInputComponent(IModel<Boolean> model, IModel<String> descriptionModel) {
        final CheckBox control = new UtrechtCheckBox(model, descriptionModel);
        control.add(AttributeAppender.append("class", FORM_FIELD_NESTED_BLOCK_INPUT_CLASSNAME));
        return control;
    }

    protected boolean isInvalid() {
        return inputComponent.hasErrorMessage();
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        if (tag instanceof WicketTag wicketTag) {
            throw new IllegalStateException("utrecht-form-field must be a normal HTML element, not a Wicket tag: " + wicketTag);
        }

        tag.put(
            "class",
            HTMLUtil.className(
                isInvalid() ? FORM_FIELD_STATE_INVALID_CLASSNAME : null
            )
        );
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);

        add(
            UtrechtFormFieldContainerBehavior.INSTANCE,
            UtrechtCheckboxContainerBehavior.INSTANCE
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

    public Component getDescriptionComponent() {
        return descriptionComponent;
    }

    public Component getErrorMessageComponent() {
        return errorMessageComponent;
    }

    private class UtrechtCheckBox extends CheckBox {

        private static final String DEFAULT_CLASS_NAMES =
            "utrecht-checkbox utrecht-checkbox--html-input utrecht-checkbox--custom";
        private static final String DISABLED_CLASSNAME = "utrecht-checkbox--disabled";
        private static final String INVALID_CLASSNAME = "utrecht-checkbox--invalid";

        private final IModel<String> descriptionModel;

        public UtrechtCheckBox(IModel<Boolean> model, IModel<String> descriptionModel) {
            super("checkbox", model);
            this.descriptionModel = descriptionModel;
            setOutputMarkupId(true);
        }

        @Override
        protected void onComponentTag(ComponentTag tag) {
            super.onComponentTag(tag);

            String className = HTMLUtil.className(
                DEFAULT_CLASS_NAMES,
                isEnabledInHierarchy() ? null : DISABLED_CLASSNAME,
                hasErrorMessage() ? INVALID_CLASSNAME : null
            );

            tag.put("class",  className);

            String ariaDescribedBy = HTMLUtil.idRefs(
                descriptionModel.getObject() != null ? descriptionComponent.getMarkupId() : null,
                hasErrorMessage() ? errorMessageComponent.getMarkupId() : null
            );

            // Do not render an empty `aria-describedby` attribute.
            if (!ariaDescribedBy.isEmpty()) {
                tag.put("aria-describedby", ariaDescribedBy);
            }

            if (isRequired()) {
                tag.put("aria-required", "true");
            }
            if (hasErrorMessage()) {
                tag.put("aria-invalid", "true");
            }
        }
    }

    private class LabelAndCheckboxContainer extends WebMarkupContainer {

        private final IModel<String> labelModel;

        public LabelAndCheckboxContainer(IModel<String> labelModel) {
            super("label");
            this.labelModel = labelModel;
        }

        @Override
        protected void onInitialize() {
            super.onInitialize();

            add(UtrechtFormLabelBehavior.INSTANCE_CHECKBOX);

            add(
                new Label("label-text", labelModel),
                inputComponent
            );
        }

        @Override
        protected void onComponentTag(ComponentTag tag) {
            super.onComponentTag(tag);
            tag.put("for", inputComponent.getMarkupId());
            tag.put(
                "class",
                HTMLUtil.className(
                    inputComponent.isEnabledInHierarchy() ? null : FORM_LABEL_STATE_DISABLED_CLASSNAME
                )
            );
        }
    }
}
