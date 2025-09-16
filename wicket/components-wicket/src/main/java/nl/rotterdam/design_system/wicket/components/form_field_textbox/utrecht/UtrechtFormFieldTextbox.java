package nl.rotterdam.design_system.wicket.components.form_field_textbox.utrecht;

import css.HTMLUtil;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormField;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldContainerBehavior;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldErrorMessageFactory;
import nl.rotterdam.design_system.wicket.components.form_field_description.utrecht.UtrechtFormFieldDescriptionBehavior;
import nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelBehavior;
import nl.rotterdam.design_system.wicket.components.textbox.utrecht.UtrechtTextboxContainerBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.Strings;

import static nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldCssClasses.*;

public class UtrechtFormFieldTextbox<T> extends GenericPanel<T> implements UtrechtFormField {

    private final TextField<T> control;
    private final Component descriptionLabel;
    private final Component errorMessageLabel;
    private String inputType;
    private final Component label;
    public static final String FORM_LABEL_DISABLED_CLASSNAME = "utrecht-form-label--disabled";

    public UtrechtFormFieldTextbox(String id, IModel<T> model, String labelText) {
        this(id, model, Model.of(labelText), null);
    }

    public UtrechtFormFieldTextbox(
        String id,
        IModel<T> model,
        IModel<String> labelModel,
        IModel<String> descriptionModel
    ) {
        super(id);

        // Create the text input
        control = new UtrechtTextbox(model, descriptionModel);
        label = createLabel(labelModel);
        descriptionLabel = new Label("description", descriptionModel)
            .add(UtrechtFormFieldDescriptionBehavior.INSTANCE)
            .add(AttributeAppender.append("class", FORM_FIELD_NESTED_BLOCK_DESCRIPTION_CLASSNAME));

        errorMessageLabel = UtrechtFormFieldErrorMessageFactory.createErrorMessageLabel("error", control)
            .add(AttributeAppender.append("class", FORM_FIELD_NESTED_BLOCK_ERROR_MESSAGE_CLASSNAME));
    }

    private Component createLabel(IModel<String> labelModel) {
        return new Label("label", labelModel) {

            @Override
            protected void onInitialize() {
                super.onInitialize();

                add(UtrechtFormLabelBehavior.INSTANCE_DEFAULT);
            }

            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("for", control.getMarkupId());
                tag.put(
                    "class",
                    HTMLUtil.className(
                        isDisabled() ? UtrechtFormFieldTextbox.FORM_LABEL_DISABLED_CLASSNAME : null
                    )
                );
            }
        };
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);

        add(
            UtrechtFormFieldContainerBehavior.INSTANCE,
            UtrechtTextboxContainerBehavior.INSTANCE
        );

        // Add all components
        add(
            control,
            label,
            descriptionLabel,
            errorMessageLabel
        );

    }

    private boolean isDisabled() {
        return !(isEnabled() && isEnableAllowed());
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
                isInvalid() ? FORM_FIELD_STATE_INVALID_CLASSNAME : null
            )
        );
    }

    public UtrechtFormFieldTextbox<T> setRequired(boolean required) {
        control.setRequired(required);
        return this;
    }

    public TextField<T> getTextField() {
        return control;
    }

    public UtrechtFormFieldTextbox<T> setInputType(String type) {
        inputType = type;

        return this;
    }

    public Component getDescriptionLabel() {
        return descriptionLabel;
    }

    public Component getErrorMessageLabel() {
        return errorMessageLabel;
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
                    isDisabled() ? DISABLED_CLASSNAME : null,
                    isInvalid() ? INVALID_CLASSNAME : null
                )
            );

            String ariaDescribedBy = HTMLUtil.idRefs(
                descriptionModel != null && descriptionModel.getObject() != null ? descriptionLabel.getMarkupId() : null,
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
            if (!Strings.isEmpty(inputType)) {
                tag.put("type", inputType);
            }
        }
    }
}
