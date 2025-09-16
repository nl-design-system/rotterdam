package nl.rotterdam.design_system.wicket.components.form_field_description.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtFormFieldDescriptionBehavior extends TagNameClassComponentBehavior {

    public static final UtrechtFormFieldDescriptionBehavior INSTANCE = new UtrechtFormFieldDescriptionBehavior();

    @Override
    public void bind(Component component) {
        component.setOutputMarkupId(true);
    }

    @Override
    public void onConfigure(Component component) {
        component.setVisible(component.getDefaultModelObject() != null);
    }

    private UtrechtFormFieldDescriptionBehavior() {
        super("div", "utrecht-form-field-description");
        addHeaderItem(cssReferenceHeaderItem(UtrechtFormFieldDescriptionBehavior.class,
            "@utrecht/form-field-description-css/dist/index.css"));
    }
}
