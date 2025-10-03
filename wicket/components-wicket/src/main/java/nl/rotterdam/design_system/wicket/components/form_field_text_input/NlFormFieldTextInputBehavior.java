package nl.rotterdam.design_system.wicket.components.form_field_text_input;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.html.panel.Panel;

import static nl.rotterdam.design_system.wicket.components.form_field_text_input.NlFormFieldTexInputCss.UTRECHT_FORM_FIELD_TEXT;

public class NlFormFieldTextInputBehavior extends TagNameClassComponentBehavior<Panel> {

    public static final NlFormFieldTextInputBehavior INSTANCE = new NlFormFieldTextInputBehavior();

    private NlFormFieldTextInputBehavior() {
        super("div", UTRECHT_FORM_FIELD_TEXT);
    }

}
