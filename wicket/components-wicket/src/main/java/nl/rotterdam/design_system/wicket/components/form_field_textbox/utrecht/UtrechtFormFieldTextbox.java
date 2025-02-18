package nl.rotterdam.design_system.wicket.components.form_field_textbox.utrecht;

import css.HTMLUtil;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldBehavior;
import nl.rotterdam.design_system.wicket.components.form_field_description.utrecht.UtrechtFormFieldDescriptionBehavior;
import nl.rotterdam.design_system.wicket.components.form_field_error_message.utrecht.UtrechtFormFieldErrorMessageBehavior;
import nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelBehavior;
import nl.rotterdam.design_system.wicket.components.textbox.utrecht.UtrechtTextboxBehavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.Strings;

import java.util.UUID;

public class UtrechtFormFieldTextbox extends Panel {

    private final TextField<String> control;
    private final Label description;
    private final IModel<String> errorMessageModel;
    private final Label errorMessage;
    private final String controlId;
    private final String fieldId;
    private final String descriptionId;
    private final String errorMessageId;
    private String inputType;

    public static final String FORM_FIELD_CLASSNAME = "utrecht-form-field";
    public static final String FORM_FIELD_INVALID_CLASSNAME = "utrecht-form-field--invalid";
    public static final String FORM_LABEL_CLASSNAME = "utrecht-form-label";
    public static final String FORM_LABEL_DISABLED_CLASSNAME = "utrecht-form-label--disabled";
    public static final String TEXTBOX_CLASSNAME = "utrecht-textbox utrecht-textbox--html-input";
    public static final String CHECKBOX_DISABLED_CLASSNAME = "utrecht-textbox--disabled";
    public static final String INVALID_CLASSNAME = "utrecht-textbox--invalid";
    public static final String FORM_FIELD_INPUT_CLASSNAME = "utrecht-form-field__input";

    public UtrechtFormFieldTextbox(String id, IModel<String> model, String labelText) {
        this(id, model, Model.of(labelText), null, null);
    }

    public UtrechtFormFieldTextbox(
        String id,
        IModel<String> model,
        IModel<String> labelModel,
        IModel<String> descriptionModel,
        IModel<String> errorModel
    ) {
        super(id);
        add(new UtrechtFormFieldBehavior());
        add(new UtrechtFormLabelBehavior());
        add(new UtrechtFormFieldDescriptionBehavior());
        add(new UtrechtFormFieldErrorMessageBehavior());
        add(new UtrechtTextboxBehavior());
        errorMessageModel = errorModel;

        // Generate unique IDs `for` and `aria-describedby` ID references
        fieldId = UUID.randomUUID().toString();

        setMarkupId(fieldId);

        controlId = UUID.randomUUID().toString();
        descriptionId = UUID.randomUUID().toString();
        errorMessageId = UUID.randomUUID().toString();

        // TODO: Implement indeterminate state, when someone needs it.

        // Create the text input
        control = new TextField<>("control", model) {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                control.setMarkupId(controlId);
                tag.put(
                    "class",
                    HTMLUtil.className(
                        UtrechtFormFieldTextbox.TEXTBOX_CLASSNAME,
                        UtrechtFormFieldTextbox.FORM_FIELD_INPUT_CLASSNAME,
                        isDisabled() ? UtrechtFormFieldTextbox.CHECKBOX_DISABLED_CLASSNAME : null,
                        isInvalid() ? UtrechtFormFieldTextbox.INVALID_CLASSNAME : null
                    )
                );

                String ariaDescribedBy = HTMLUtil.idRefs(
                    descriptionModel != null && descriptionModel.getObject() != null ? descriptionId : null,
                    isInvalid() ? errorMessageId : null
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

            protected void onDisabled(final ComponentTag tag) {
                tag.put("disabled", "disabled");
                // TODO: Add `CHECKBOX_DISABLED_CLASSNAME` class name
            }
        };

        Label labelText = new Label("labelText", labelModel) {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
            }
        };

        WebMarkupContainer label = new WebMarkupContainer("label") {
            @Override
            protected void onInitialize() {
                super.onInitialize();

                add(new UtrechtFormLabelBehavior());
                add(labelText);
            }

            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                // TODO: use 'wicket for' attribute
                tag.put("for", controlId);
                tag.put(
                    "class",
                    HTMLUtil.className(
                        UtrechtFormFieldTextbox.FORM_LABEL_CLASSNAME,
                        isDisabled() ? UtrechtFormFieldTextbox.FORM_LABEL_DISABLED_CLASSNAME : null
                    )
                );
            }
        };

        // Create description and error message
        description = new Label("description", descriptionModel) {
            {
                setMarkupId(descriptionId);
            }

            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
            }

            @Override
            public boolean isVisible() {
                return getDefaultModelObject() != null;
            }
        };

        errorMessage = new Label("error", errorModel) {
            {
                setMarkupId(errorMessageId);
            }

            @Override
            public boolean isVisible() {
                return getDefaultModelObject() != null;
            }
        };

        // Add all components
        add(
            control,
            label,
            labelText,
            description,
            errorMessage
        );
    }

    private boolean isDisabled() {
        return !(isEnabled() && isEnableAllowed());
    }

    protected boolean isInvalid() {
        return errorMessageModel != null && errorMessageModel.getObject() != null;
    }

    protected boolean isRequired() {
        return control.isRequired();
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);
        tag.put(
            "class",
            HTMLUtil.className(
                UtrechtFormFieldTextbox.FORM_FIELD_CLASSNAME,
                isInvalid() ? UtrechtFormFieldTextbox.FORM_FIELD_INVALID_CLASSNAME : null
            )
        );
    }

    public UtrechtFormFieldTextbox setRequired(boolean required) {
        control.setRequired(required);
        return this;
    }

    public TextField getTextField() {
        return control;
    }

    public UtrechtFormFieldTextbox setInputType(String arg) {
        inputType = arg;

        return this;
    }
}
