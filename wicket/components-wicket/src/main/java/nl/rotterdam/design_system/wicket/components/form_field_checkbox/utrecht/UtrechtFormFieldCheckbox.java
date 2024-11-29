package nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht;

import static css.WicketComponentsCssReferences.CHECKBOX_HEADER_ITEM;
import static css.WicketComponentsCssReferences.CUSTOM_CHECKBOX_HEADER_ITEM;
import static css.WicketComponentsCssReferences.FORM_FIELD_DESCRIPTION_HEADER_ITEM;
import static css.WicketComponentsCssReferences.FORM_FIELD_ERROR_MESSAGE_HEADER_ITEM;
import static css.WicketComponentsCssReferences.FORM_FIELD_HEADER_ITEM;
import static css.WicketComponentsCssReferences.FORM_LABEL_HEADER_ITEM;

import css.HTMLUtil;
import java.util.UUID;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class UtrechtFormFieldCheckbox extends Panel {

    private static final long serialVersionUID = 1L;

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

        // Create the label
        Label label = new Label("label", labelModel) {
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

        Label labelText = new Label("labelText", labelModel) {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
            }
        };

        // Create description and error message
        description = new Label("description", descriptionModel) {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("id", descriptionId);
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
                tag.put("id", errorMessageId);
            }

            @Override
            public boolean isVisible() {
                return getDefaultModelObject() != null;
            }
        };

        // Add all components
        add(checkbox);
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
        tag.put("id", fieldId);
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
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(CHECKBOX_HEADER_ITEM);
        response.render(CUSTOM_CHECKBOX_HEADER_ITEM);
        response.render(FORM_FIELD_DESCRIPTION_HEADER_ITEM);
        response.render(FORM_FIELD_ERROR_MESSAGE_HEADER_ITEM);
        response.render(FORM_FIELD_HEADER_ITEM);
        response.render(FORM_LABEL_HEADER_ITEM);
    }

    public UtrechtFormFieldCheckbox setRequired(boolean required) {
        checkbox.setRequired(required);
        return this;
    }

    public CheckBox getCheckbox() {
        return checkbox;
    }
}
