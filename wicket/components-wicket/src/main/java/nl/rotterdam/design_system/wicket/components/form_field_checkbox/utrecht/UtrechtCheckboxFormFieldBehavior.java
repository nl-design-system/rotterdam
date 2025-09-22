package nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.panel.Panel;

import static nl.rotterdam.design_system.wicket.components.form_field_checkbox.utrecht.UtrechtFormFieldCheckboxClasses.UTRECHT_FORM_FIELD_CHECKBOX_CLASS_NAME;

public class UtrechtCheckboxFormFieldBehavior extends TagNameClassComponentBehavior<Panel> {

    public static final UtrechtCheckboxFormFieldBehavior INSTANCE = new UtrechtCheckboxFormFieldBehavior();

    private UtrechtCheckboxFormFieldBehavior() {
        super("div", UTRECHT_FORM_FIELD_CHECKBOX_CLASS_NAME);
    }
}
