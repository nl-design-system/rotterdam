package nl.rotterdam.design_system.wicket.components.form_field_textbox.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.panel.Panel;

import static nl.rotterdam.design_system.wicket.components.form_field_textbox.utrecht.UtrechtFormFieldTextboxCss.UTRECHT_FORM_FIELD_TEXT;

public class UtrechtFormFieldTextboxBehavior extends TagNameClassComponentBehavior<Panel> {

    public static final UtrechtFormFieldTextboxBehavior INSTANCE = new UtrechtFormFieldTextboxBehavior();

    private UtrechtFormFieldTextboxBehavior() {
        super("div", UTRECHT_FORM_FIELD_TEXT);
    }

}
