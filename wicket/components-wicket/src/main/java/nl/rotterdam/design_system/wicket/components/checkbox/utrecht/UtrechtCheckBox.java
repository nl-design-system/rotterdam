package nl.rotterdam.design_system.wicket.components.checkbox.utrecht;

import css.HTMLUtil;
import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

import static nl.rotterdam.design_system.wicket.components.models.DefaultModels.EMPTY_STRING_MODEL;

public class UtrechtCheckBox extends CheckBox {

    private static final String DEFAULT_CLASS_NAMES =
        "utrecht-checkbox utrecht-checkbox--html-input utrecht-checkbox--custom";
    private static final String DISABLED_CLASSNAME = "utrecht-checkbox--disabled";
    private static final String INVALID_CLASSNAME = "utrecht-checkbox--invalid";

    private final IModel<String> descriptionModel;

    @Nullable
    private final Component descriptionComponent;

    @Nullable
    private final Component errorMessageComponent;

    public UtrechtCheckBox(String id, IModel<Boolean> model) {
        this(id, model, EMPTY_STRING_MODEL, null, null);
    }

    public UtrechtCheckBox(String id, IModel<Boolean> model,
                           IModel<String> descriptionModel,
                           @Nullable Component descriptionComponent,
                           @Nullable Component errorMessageComponent) {
        super(id, model);
        this.descriptionModel = descriptionModel;
        this.descriptionComponent = descriptionComponent;
        this.errorMessageComponent = errorMessageComponent;
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

        tag.put("class", className);

        String ariaDescribedBy = HTMLUtil.idRefs(
            descriptionComponent != null && descriptionModel.getObject() != null ? descriptionComponent.getMarkupId() : null,
            errorMessageComponent != null && hasErrorMessage() ? errorMessageComponent.getMarkupId() : null
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
