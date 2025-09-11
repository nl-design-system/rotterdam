package nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht;

import css.HTMLUtil;
import nl.rotterdam.design_system.wicket.components.checkbox.utrecht.UtrechtCheckboxBehavior;
import nl.rotterdam.design_system.wicket.components.component_visibility.HideWhenModelIsNullBehavior;
import nl.rotterdam.design_system.wicket.components.form_field.utrecht.UtrechtFormFieldContainerBehavior;
import nl.rotterdam.design_system.wicket.components.form_field_description.utrecht.UtrechtFormFieldDescriptionBehavior;
import nl.rotterdam.design_system.wicket.components.form_field_error_message.utrecht.UtrechtFormFieldErrorMessageBehavior;
import nl.rotterdam.design_system.wicket.components.form_label.utrecht.UtrechtFormLabelBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class UtrechtFormFieldCheckbox extends GenericPanel<Boolean> {

    private final CheckBox checkbox;
    private final Component descriptionLabel;
    private final Component errorMessageLabel;

    public static final String FORM_FIELD_INVALID_CLASSNAME = "utrecht-form-field--invalid";
    public static final String FORM_LABEL_DISABLED_CLASSNAME = "utrecht-form-label--disabled";


    public static final String CHECKBOX_CUSTOM_CLASSNAME =
        "utrecht-checkbox utrecht-checkbox--html-input utrecht-checkbox--custom";
    public static final String CHECKBOX_DISABLED_CLASSNAME = "utrecht-checkbox--disabled";

    public static final String CHECKBOX_REQUIRED_CLASSNAME = "utrecht-checkbox--required";
    public static final String INVALID_CLASSNAME = "utrecht-checkbox--invalid";
    public static final String FORM_FIELD_INPUT_CLASSNAME = "utrecht-form-field__input";

    private static final IModel<String> EMPTY_DESCRIPTION_MODEL = () -> null;

    public UtrechtFormFieldCheckbox(String id, IModel<Boolean> model, String labelText) {
        this(id, model, Model.of(labelText), EMPTY_DESCRIPTION_MODEL);
    }

    public UtrechtFormFieldCheckbox(
        String id,
        IModel<Boolean> model,
        IModel<String> labelModel,
        IModel<String> descriptionModel
    ) {
        super(id);
        add(UtrechtFormFieldContainerBehavior.INSTANCE_CHECKBOX);

        checkbox = createCheckbox(model, descriptionModel);
        descriptionLabel = createDescriptionLabel(descriptionModel);
        errorMessageLabel = createErrorMessageLabel(model);

        add(

            createOuterLabelAndCheckbox(labelModel),
            descriptionLabel,
            errorMessageLabel
        );
    }

    private Component createDescriptionLabel(IModel<String> descriptionModel) {
        return new Label("description", descriptionModel)
            .setOutputMarkupId(true)
            .add(HideWhenModelIsNullBehavior.INSTANCE)
            .add(UtrechtFormFieldDescriptionBehavior.INSTANCE);
    }

    private Component createErrorMessageLabel(IModel<Boolean> model) {
        // TODO only shows the first feedback message. Is multiple messages desired by parkeren or afspraak?
        return new Label("error",
            model.map(x -> {
                FeedbackMessage first = checkbox.getFeedbackMessages().first(FeedbackMessage.ERROR);
                return first != null ? first.getMessage().toString() : null;
            })
        )
            .setOutputMarkupId(true)
            .add(HideWhenModelIsNullBehavior.INSTANCE)
            .add(UtrechtFormFieldErrorMessageBehavior.INSTANCE);
    }

    private WebMarkupContainer createOuterLabelAndCheckbox(IModel<String> labelModel) {
        return new WebMarkupContainer("label") {

            @Override
            protected void onInitialize() {
                super.onInitialize();

                add(UtrechtFormLabelBehavior.INSTANCE_CHECKBOX);

                add(
                    new Label("labelText", labelModel),
                    checkbox
                );
            }

            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("for", checkbox.getMarkupId());
                tag.put(
                    "class",
                    HTMLUtil.className(
                        isEnabledInHierarchy() ? null : UtrechtFormFieldCheckbox.FORM_LABEL_DISABLED_CLASSNAME
                    )
                );
            }
        };
    }

    protected boolean isInvalid() {
        return checkbox.getFeedbackMessages().hasMessage(FeedbackMessage.ERROR);
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);
        tag.put(
            "class",
            HTMLUtil.className(
                isInvalid() ? UtrechtFormFieldCheckbox.FORM_FIELD_INVALID_CLASSNAME : null
            )
        );
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        setOutputMarkupId(true);
    }

    public UtrechtFormFieldCheckbox setRequired(boolean required) {
        checkbox.setRequired(required);
        return this;
    }

    public CheckBox getCheckbox() {
        return checkbox;
    }

    public Component getDescriptionLabel() {
        return descriptionLabel;
    }

    public Component getErrorMessageLabel() {
        return errorMessageLabel;
    }

    private CheckBox createCheckbox(IModel<Boolean> model, IModel<String> descriptionModel) {
        return new CheckBox("checkbox", model) {

            {
                add(new UtrechtCheckboxBehavior());
                setOutputMarkupId(true);
            }

            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);

                tag.put(
                    "class",
                    HTMLUtil.className(
                        UtrechtFormFieldCheckbox.CHECKBOX_CUSTOM_CLASSNAME,
                        UtrechtFormFieldCheckbox.FORM_FIELD_INPUT_CLASSNAME,
                        isEnabledInHierarchy() ? null : UtrechtFormFieldCheckbox.CHECKBOX_DISABLED_CLASSNAME,
                        isInvalid() ? UtrechtFormFieldCheckbox.INVALID_CLASSNAME : null,
                        isRequired() ? UtrechtFormFieldCheckbox.CHECKBOX_REQUIRED_CLASSNAME : null
                    )
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

            protected void onDisabled(final ComponentTag tag) {
                tag.put("disabled", "disabled");
                // TODO: Add `CHECKBOX_DISABLED_CLASSNAME` class name
            }
        };
    }

}
