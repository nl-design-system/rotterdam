package nl.rotterdam.nl_design_system.wicket.components.form_field_description.utrecht;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;

public class UtrechtFormFieldDescriptionBehavior extends TagNameClassComponentBehavior<Component> {

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
        super("div", UtrechtFormFieldDescriptionCss.DEFAULT);
        addHeaderItem(
            cssReferenceHeaderItem(
                UtrechtFormFieldDescriptionBehavior.class,
                "@utrecht/form-field-description-css/dist/index.css"
            )
        );
    }
}
