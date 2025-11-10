package nl.rotterdam.nl_design_system.wicket.components.form_field_checkbox;

import static nl.rotterdam.nl_design_system.wicket.components.form_field_checkbox.RdFormFieldCheckboxCss.FORM_FIELD_CHECKBOX;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.panel.Panel;

class RdCheckboxFormFieldBehavior extends TagNameClassComponentBehavior<Panel> {

    public static final RdCheckboxFormFieldBehavior INSTANCE = new RdCheckboxFormFieldBehavior();

    private RdCheckboxFormFieldBehavior() {
        super("div", FORM_FIELD_CHECKBOX);
    }
}
