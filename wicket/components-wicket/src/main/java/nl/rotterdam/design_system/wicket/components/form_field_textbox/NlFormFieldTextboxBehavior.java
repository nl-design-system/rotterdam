package nl.rotterdam.design_system.wicket.components.form_field_textbox;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.panel.Panel;

import static nl.rotterdam.design_system.wicket.components.form_field_textbox.NlFormFieldTextboxCss.UTRECHT_FORM_FIELD_TEXT;

public class NlFormFieldTextboxBehavior extends TagNameClassComponentBehavior<Panel> {

    public static final NlFormFieldTextboxBehavior INSTANCE = new NlFormFieldTextboxBehavior();

    private NlFormFieldTextboxBehavior() {
        super("div", UTRECHT_FORM_FIELD_TEXT);
    }

}
