package nl.rotterdam.design_system.wicket.components.checkbox.utrecht;

import css.HTMLUtil;
import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

import static nl.rotterdam.design_system.wicket.components.models.DefaultModels.EMPTY_STRING_MODEL;

/**
 * Implementation of <a href="https://nldesignsystem.nl/checkbox/">NL Design System Checkbox</a>.
 *
 * <p>Based on <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-checkbox--docs">
 *     implementation of Utrecht
 *  </a></p>
 */
public class UtrechtCheckbox extends CheckBox {

    private final IModel<String> descriptionModel;

    @Nullable
    private final Component descriptionComponent;

    @Nullable
    private final Component errorMessageComponent;

    public UtrechtCheckbox(String id, IModel<Boolean> model) {
        this(id, model, EMPTY_STRING_MODEL, null, null);
    }

    public UtrechtCheckbox(String id, IModel<Boolean> model,
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
    protected void onInitialize() {
        super.onInitialize();
        add(UtrechtCheckboxBehavior.INSTANCE);
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        String ariaDescribedBy = HTMLUtil.idRefs(
            descriptionComponent != null && descriptionModel.getObject() != null ? descriptionComponent.getMarkupId() : null,
            errorMessageComponent != null && hasErrorMessage() ? errorMessageComponent.getMarkupId() : null
        );

        // Do not render an empty `aria-describedby` attribute.
        if (!ariaDescribedBy.isEmpty()) {
            tag.put("aria-describedby", ariaDescribedBy);
        }

    }
}
