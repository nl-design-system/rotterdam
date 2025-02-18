package nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht;

import css.HTMLUtil;
import nl.rotterdam.design_system.wicket.components.checkbox.utrecht.UtrechtCheckboxBehavior;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldBehavior;
import nl.rotterdam.design_system.wicket.components.form_field_description.utrecht.UtrechtFormFieldDescriptionBehavior;
import nl.rotterdam.design_system.wicket.components.form_field_error_message.utrecht.UtrechtFormFieldErrorMessageBehavior;
import nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelBehavior;
import nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelType;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.UUID;

public class UtrechtFormFieldCheckbox extends Panel {

    private final CheckBox checkbox;
    private final Label description;
    private final IModel<String> errorMessageModel;
    private final Label errorMessage;
    private final String checkboxId;
    private final String fieldId;
    private final String descriptionId;
    private final String errorMessageId;

    public static final String FORM_FIELD_CLASSNAME = "utrecht-form-field";
    public static final String FORM_FIELD_CHECKBOX_CLASSNAME = "utrecht-form-field--checkbox";
    public static final String FORM_FIELD_INVALID_CLASSNAME = "utrecht-form-field--invalid";
    public static final String FORM_LABEL_CLASSNAME = "utrecht-form-label utrecht-form-label--checkbox";
    public static final String FORM_LABEL_DISABLED_CLASSNAME = "utrecht-form-label--disabled";
    public static final String CHECKBOX_CLASSNAME =
        "utrecht-checkbox utrecht-checkbox--html-input utrecht-checkbox--custom";
    public static final String CHECKBOX_DISABLED_CLASSNAME = "utrecht-checkbox--disabled";
    public static final String INVALID_CLASSNAME = "utrecht-checkbox--invalid";
    public static final String FORM_FIELD_INPUT_CLASSNAME = "utrecht-form-field__input";

    public UtrechtFormFieldCheckbox(String id, IModel<Boolean> model, String labelText) {
        this(id, model, Model.of(labelText), null, null);
    }

    public UtrechtFormFieldCheckbox(
        String id,
        IModel<Boolean> model,
        IModel<String> labelModel,
        IModel<String> descriptionModel,
        IModel<String> errorModel
    ) {
        super(id);
        add(UtrechtFormFieldBehavior.INSTANCE);
        add(UtrechtFormFieldDescriptionBehavior.INSTANCE);
        add(new UtrechtFormFieldErrorMessageBehavior());
        add(new UtrechtCheckboxBehavior());

        errorMessageModel = errorModel;

        // Generate unique IDs `for` and `aria-describedby` ID references
        fieldId = UUID.randomUUID().toString();
        checkboxId = UUID.randomUUID().toString();
        descriptionId = UUID.randomUUID().toString();
        errorMessageId = UUID.randomUUID().toString();

        // TODO: Implement disabled state
        Boolean disabled = false;

        // TODO: Implement indeterminate state, when someone needs it.

        // Create the checkbox input
        checkbox = new CheckBox("checkbox", model) {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                checkbox.setMarkupId(checkboxId);

                tag.put(
                    "class",
                    HTMLUtil.className(
                        UtrechtFormFieldCheckbox.CHECKBOX_CLASSNAME,
                        UtrechtFormFieldCheckbox.FORM_FIELD_INPUT_CLASSNAME,
                        disabled ? UtrechtFormFieldCheckbox.CHECKBOX_DISABLED_CLASSNAME : null,
                        isInvalid() ? UtrechtFormFieldCheckbox.INVALID_CLASSNAME : null
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

                add(new UtrechtFormLabelBehavior(UtrechtFormLabelType.CHECKBOX));
                add(labelText);
            }

            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("for", checkboxId);
                tag.put(
                    "class",
                    HTMLUtil.className(
                        UtrechtFormFieldCheckbox.FORM_LABEL_CLASSNAME,
                        disabled ? UtrechtFormFieldCheckbox.FORM_LABEL_DISABLED_CLASSNAME : null
                    )
                );
            }
        };

        // Create description and error message
        description = new Label("description", descriptionModel) {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
            }

            @Override
            protected void onInitialize() {
                super.onInitialize();
                setMarkupId(descriptionId);
            }

            @Override
            public boolean isVisible() {
                return getDefaultModelObject() != null;
            }
        };

        errorMessage = new Label("error", errorModel) {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
            }

            @Override
            protected void onInitialize() {
                super.onInitialize();
                UtrechtFormFieldCheckbox.this.setMarkupId(errorMessageId);
            }

            @Override
            public boolean isVisible() {
                return getDefaultModelObject() != null;
            }
        };

        // Add all components
        label.add(checkbox);
        add(label);
        add(labelText);
        add(description);
        add(errorMessage);
    }

    protected boolean isInvalid() {
        return errorMessageModel != null && errorMessageModel.getObject() != null;
    }

    protected boolean isRequired() {
        return checkbox.isRequired();
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);
        tag.put(
            "class",
            HTMLUtil.className(
                UtrechtFormFieldCheckbox.FORM_FIELD_CLASSNAME,
                UtrechtFormFieldCheckbox.FORM_FIELD_CHECKBOX_CLASSNAME,
                isInvalid() ? UtrechtFormFieldCheckbox.FORM_FIELD_INVALID_CLASSNAME : null
            )
        );
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        setMarkupId(fieldId);
    }

    public UtrechtFormFieldCheckbox setRequired(boolean required) {
        checkbox.setRequired(required);
        return this;
    }

    public CheckBox getCheckbox() {
        return checkbox;
    }
}
