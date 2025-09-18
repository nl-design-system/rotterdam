package nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.panel.Panel;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtCheckboxFormFieldBehavior extends TagNameClassComponentBehavior<Panel> {

    public static final UtrechtCheckboxFormFieldBehavior INSTANCE = new UtrechtCheckboxFormFieldBehavior();
    private UtrechtCheckboxFormFieldBehavior() {
        super("div", "utrecht-form-field--checkbox");

        addHeaderItem(cssReferenceHeaderItem(UtrechtCheckboxFormFieldBehavior.class, "@utrecht/checkbox-css/dist/index.css"));
        addHeaderItem(cssReferenceHeaderItem(UtrechtCheckboxFormFieldBehavior.class, "@utrecht/custom-checkbox-css/dist/index.css"));
    }
}
