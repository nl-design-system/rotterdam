package nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht;

import css.HTMLUtil;
import nl.rotterdam.design_system.wicket.components.checkbox.utrecht.UtrechtCheckboxContainerBehavior;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormField;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldContainerBehavior;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldCssClasses;
import nl.rotterdam.design_system.wicket.components.form_field_description.utrecht.UtrechtFormFieldDescriptionBehavior;
import nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

import static nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldCssClasses.*;
import static nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldErrorMessageFactory.createErrorMessageLabel;
import static nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelCssClasses.FORM_LABEL_STATE_DISABLED_CLASSNAME;

public class UtrechtFormFieldCheckbox extends GenericPanel<Boolean> implements UtrechtFormField {

    private final CheckBox control;
    private final Component descriptionLabel;
    private final Component errorMessageLabel;

    private static final String CHECKBOX_CUSTOM_CLASSNAME =
        "utrecht-checkbox utrecht-checkbox--html-input utrecht-checkbox--custom";
    private static final String CHECKBOX_DISABLED_CLASSNAME = "utrecht-checkbox--disabled";
    private static final String INVALID_CLASSNAME = "utrecht-checkbox--invalid";
    private static final IModel<String> EMPTY_DESCRIPTION_MODEL = () -> null;
    private final IModel<String> labelModel;

    public UtrechtFormFieldCheckbox(String id, IModel<Boolean> model, IModel<String> labelModel) {
        this(id, model, labelModel, EMPTY_DESCRIPTION_MODEL);
    }

    public UtrechtFormFieldCheckbox(
        String id,
        IModel<Boolean> model,
        IModel<String> labelModel,
        IModel<String> descriptionModel
    ) {
        super(id);
        this.labelModel = labelModel;

        control = new UtrechtCheckBox(model, descriptionModel);
        descriptionLabel = new Label("description", descriptionModel)
            .add(UtrechtFormFieldDescriptionBehavior.INSTANCE)
            .add(AttributeAppender.append("class", FORM_FIELD_NESTED_BLOCK_DESCRIPTION_CLASSNAME));

        errorMessageLabel = createErrorMessageLabel("error", control)
        .add(AttributeAppender.append("class", FORM_FIELD_NESTED_BLOCK_ERROR_MESSAGE_CLASSNAME));
    }

    protected boolean isInvalid() {
        return control.getFeedbackMessages().hasMessage(FeedbackMessage.ERROR);
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);
        tag.put(
            "class",
            HTMLUtil.className(
                isInvalid() ? UtrechtFormFieldCssClasses.FORM_FIELD_STATE_INVALID_CLASSNAME : null
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
            new LabelAndCheckboxContainer(labelModel),
            descriptionLabel,
            errorMessageLabel
        );

    }

    public UtrechtFormFieldCheckbox setRequired(boolean required) {
        control.setRequired(required);
        return this;
    }

    public CheckBox getControl() {
        return control;
    }

    public Component getDescriptionLabel() {
        return descriptionLabel;
    }

    public Component getErrorMessageLabel() {
        return errorMessageLabel;
    }

    private class UtrechtCheckBox extends CheckBox {

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
                UtrechtFormFieldCheckbox.CHECKBOX_CUSTOM_CLASSNAME,
                UtrechtFormFieldCssClasses.FORM_FIELD_NESTED_BLOCK_INPUT_CLASSNAME,
                isEnabledInHierarchy() ? null : UtrechtFormFieldCheckbox.CHECKBOX_DISABLED_CLASSNAME,
                isInvalid() ? UtrechtFormFieldCheckbox.INVALID_CLASSNAME : null
            );

            tag.put(
                "class",
                className
            );

            String ariaDescribedBy = HTMLUtil.idRefs(
                descriptionModel.getObject() != null ? descriptionLabel.getMarkupId() : null,
                isInvalid() ? errorMessageLabel.getMarkupId() : null
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
                new Label("labelText", labelModel),
                control
            );
        }

        @Override
        protected void onComponentTag(ComponentTag tag) {
            super.onComponentTag(tag);
            tag.put("for", control.getMarkupId());
            tag.put(
                "class",
                HTMLUtil.className(
                    isEnabledInHierarchy() ? null : FORM_LABEL_STATE_DISABLED_CLASSNAME
                )
            );
        }
    }
}
