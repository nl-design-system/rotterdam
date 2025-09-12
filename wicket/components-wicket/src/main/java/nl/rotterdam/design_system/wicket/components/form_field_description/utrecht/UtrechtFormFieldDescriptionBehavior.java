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
        // TODO asked on Slack, why with '-' and '__'? https://codefornl.slack.com/archives/C01DAT4TRPF/p1757681150681179
        super("div", "utrecht-form-field-description", "utrecht-form-field__description");
        addHeaderItem(cssReferenceHeaderItem(UtrechtFormFieldDescriptionBehavior.class,
            "@utrecht/form-field-description-css/dist/index.css"));
    }

}
