package nl.rotterdam.design_system.wicket.components.form_field_checkbox;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.panel.Panel;

import static nl.rotterdam.design_system.wicket.components.form_field_checkbox.RdFormFieldCheckboxCss.UTRECHT_FORM_FIELD_CHECKBOX;

class RdCheckboxFormFieldBehavior extends TagNameClassComponentBehavior<Panel> {

    public static final RdCheckboxFormFieldBehavior INSTANCE = new RdCheckboxFormFieldBehavior();

    private RdCheckboxFormFieldBehavior() {
        super("div", UTRECHT_FORM_FIELD_CHECKBOX);
    }
}
