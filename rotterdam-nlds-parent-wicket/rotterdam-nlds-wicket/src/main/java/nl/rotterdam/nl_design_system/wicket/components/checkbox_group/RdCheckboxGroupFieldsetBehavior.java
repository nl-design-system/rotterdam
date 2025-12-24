package nl.rotterdam.nl_design_system.wicket.components.checkbox_group;

import nl.rotterdam.nl_design_system.wicket.html.TokenSetBuilder;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.FormComponent;

class RdCheckboxGroupFieldsetBehavior extends Behavior {

    private final Component descriptionComponent;
    private final Component errorMessageComponent;

    RdCheckboxGroupFieldsetBehavior(Component descriptionComponent, Component errorMessageComponent) {
        this.descriptionComponent = descriptionComponent;
        this.errorMessageComponent = errorMessageComponent;
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        if (!"fieldset".equalsIgnoreCase(tag.getName())) {
            throw new IllegalStateException("Checkbox group fieldset must be attached to `<fieldset>`.");
        }
        
        super.onComponentTag(component, tag);

        if (component instanceof FormComponent<?> formComponent && !formComponent.isValid()) {
            tag.put("aria-invalid", "true");
        }
        new TokenSetBuilder(2)
            .append(descriptionComponent.isVisible(), descriptionComponent.getMarkupId())
            .append(errorMessageComponent.isVisible(), errorMessageComponent.getMarkupId())
            .use(tokenSet -> tag.put("aria-describedby", tokenSet));
    }
}
