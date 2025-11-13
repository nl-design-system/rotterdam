package nl.rotterdam.nl_design_system.wicket.components.form_field_description;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

/**
 * Apply Form field description behavior to an HTML element.
 */
public class RdFormFieldDescriptionBehavior extends TagNameClassComponentBehavior<Component> {

    /**
     * Singleton instance.
     */
    public static final RdFormFieldDescriptionBehavior INSTANCE = new RdFormFieldDescriptionBehavior();

    @Override
    public void bind(Component component) {
        component.setOutputMarkupId(true);
    }

    @Override
    public void onConfigure(Component component) {
        component.setVisible(component.getDefaultModelObject() != null);
    }

    private RdFormFieldDescriptionBehavior() {
        super("div", RdFormFieldDescriptionCss.DEFAULT);
        addHeaderItem(
            cssReferenceHeaderItem(
                RdFormFieldDescriptionBehavior.class,
                "@utrecht/form-field-description-css/dist/index.css"
            )
        );
    }
}
