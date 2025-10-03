package nl.rotterdam.design_system.wicket.components.form_field_checkbox;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.panel.Panel;

import static nl.rotterdam.design_system.wicket.components.form_field_checkbox.NlFormFieldCheckboxCss.UTRECHT_FORM_FIELD_CHECKBOX;

public class NlCheckboxFormFieldBehavior extends TagNameClassComponentBehavior<Panel> {

    public static final NlCheckboxFormFieldBehavior INSTANCE = new NlCheckboxFormFieldBehavior();

    private NlCheckboxFormFieldBehavior() {
        super("div", UTRECHT_FORM_FIELD_CHECKBOX);
    }
}
